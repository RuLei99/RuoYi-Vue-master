package com.ruoyi.web.controller.system;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Detail;
import com.ruoyi.system.domain.MovesDto;
import com.ruoyi.system.service.HdfsService;
import com.ruoyi.system.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 天气管理Controller
 *
 * @author ruoyi
 * @date 2024-04-09
 */
@RestController
@RequestMapping("/system/detail")
public class DetailController extends BaseController {
    @Autowired
    private IDetailService detailService;
    @Autowired
    private HdfsService hdfsService;

    /**
     * 查询天气管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(Detail detail) {
        startPage();
        List<Detail> list = detailService.selectDetailList(detail);
        return getDataTable(list);
    }

    /**
     * 数据导入
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<Detail> util = new ExcelUtil<Detail>(Detail.class);
        List<Detail> userList = util.importExcel(file.getInputStream());
        // 调用hadoop，文件上传hodoop，并数据解析
        JSONObject object = new JSONObject();
        String originalFilename = file.getOriginalFilename();
        String path = "C:\\upload/";
        File temp = new File(path + originalFilename);
        file.transferTo(temp);
        String srcPath = path + originalFilename;
        String distPath = "/opt/m2/" + originalFilename;
        hdfsService.uploadFileToHdfs(false, true, srcPath, distPath);
        String operName = getUsername();
        String message = detailService.importUser(userList, updateSupport, operName);
        return success(message);
    }

    /**
     * 导出天气管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:export')")
    @Log(title = "天气管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Detail detail) {
        List<Detail> list = detailService.selectDetailList(detail);
        ExcelUtil<Detail> util = new ExcelUtil<Detail>(Detail.class);
        util.exportExcel(response, list, "天气管理数据");
    }

    /**
     * 获取天气管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(detailService.selectDetailById(id));
    }

    /**
     * 新增天气管理
     */
    @PreAuthorize("@ss.hasPermi('system:detail:add')")
    @Log(title = "天气管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Detail detail) {
        return toAjax(detailService.insertDetail(detail));
    }

    /**
     * 修改天气管理
     */
    @PreAuthorize("@ss.hasPermi('system:detail:edit')")
    @Log(title = "天气管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Detail detail) {
        return toAjax(detailService.updateDetail(detail));
    }

    /**
     * 删除天气管理
     */
    @PreAuthorize("@ss.hasPermi('system:detail:remove')")
    @Log(title = "天气管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(detailService.deleteDetailByIds(ids));
    }

    @GetMapping(value = "/alldetail")
    public MovesDto allmoves() {

        MovesDto dto = detailService.selectAll();
        return dto;
    }

    @GetMapping("qwyc")
    public AjaxResult qwyc(String city) throws Exception {
        // 明确泛型
        Map<String, List<String>> qwyc = detailService.qwyc(city);
        List<String> rqs = qwyc.get("sj");
        List<String> qws = qwyc.get("qw");

        if (rqs == null || rqs.isEmpty()) {
            return AjaxResult.error("日期列表为空");
        }

        if (qws == null) {
            qws = new ArrayList<>(); // 初始化，防止空指针
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 获取最新的日期
        String maxRqStr = rqs.get(rqs.size() - 1);
        LocalDate maxRq = LocalDate.parse(maxRqStr, formatter);

        int iterations = 5; // 要添加的日期数量
        for (int i = 1; i <= iterations; i++) {
            LocalDate nextDate = maxRq.plusDays(1); // 增加一天
            String nextDateStr = nextDate.format(formatter);

            // 检查日期是否已存在，防止重复
            if (!rqs.contains(nextDateStr)) {
                Double yqwd = yqwd(rqs, qws, nextDateStr, i);
                rqs.add(nextDateStr);
                qws.add(yqwd.toString());
                maxRq = nextDate; // 更新最大日期
            }
        }

        // 更新结果并返回
        qwyc.put("sj", rqs);
        qwyc.put("qw", qws);

        return AjaxResult.success(qwyc);
    }

    @GetMapping("sdyc")
    public AjaxResult sdyc(String city) throws Exception {
        Map<String, List<String>> qwyc = detailService.sdyc(city);
        List<String> rqs = qwyc.get("sj");
        List<String> qws = qwyc.get("sd");

        // 定义日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 获取最新的日期并确保它是有效的
        LocalDate maxRq = LocalDate.parse(rqs.get(rqs.size() - 1), formatter);

        int iterations = 5;
        for (int i = 1; i <= iterations; i++) {
            LocalDate nextDate = maxRq.plusDays(1); // 增加一天
            String nextDateString = nextDate.format(formatter);

            if (!rqs.contains(nextDateString)) { // 避免重复
                Double yqwd = yqwd(rqs, qws, nextDateString, i);
                rqs.add(nextDateString);
                qws.add(yqwd.toString());
                maxRq = nextDate; // 更新最大日期
            }
        }

        qwyc.put("sj", rqs);
        qwyc.put("qw", qws);

        return AjaxResult.success(qwyc);
    }



    @GetMapping("qyyc")
    public AjaxResult qyyc(String city) throws Exception {
        // 明确泛型
        Map<String, List<String>> qwyc = detailService.qyyc(city);
        List<String> rqs = qwyc.get("sj");
        List<String> qws = qwyc.get("qy");

        if (rqs == null || rqs.isEmpty()) {
            return AjaxResult.error("日期列表为空");
        }

        if (qws == null) {
            qws = new ArrayList<>(); // 初始化，如果为空
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 获取最新的日期
        String maxRqStr = rqs.get(rqs.size() - 1);
        LocalDate maxRq = LocalDate.parse(maxRqStr, formatter);

        int iterations = 5; // 设定要添加的日期数量
        for (int i = 1; i <= iterations; i++) {
            LocalDate nextDate = maxRq.plusDays(1); // 添加一天
            String nextDateStr = nextDate.format(formatter); // 转换回字符串

            if (!rqs.contains(nextDateStr)) { // 避免重复添加
                Double yqwd = yqwd(rqs, qws, nextDateStr, i);
                rqs.add(nextDateStr);
                qws.add(yqwd.toString());
                maxRq = nextDate; // 更新最大日期
            }
        }

        qwyc.put("sj", rqs);
        qwyc.put("qw", qws);

        return AjaxResult.success(qwyc);
    }

    public String getDate(String dateString, Integer num) throws ParseException {

        // 定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 将字符串转换为日期
        Date date = sdf.parse(dateString);

        // 使用 Calendar 进行日期操作
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // 将日期加3天
        calendar.add(Calendar.DAY_OF_MONTH, num);

        // 获取加3天后的日期
        Date newDate = calendar.getTime();

        // 将日期转换为字符串
        String newDateString = sdf.format(newDate);

        return newDateString;
    }

    public Double yqwd(List<String> rqs, List<String> wds, String newDate, Integer i1) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("d:\\wd_dataset.arff"));

        // 写入ARFF文件头部信息
        writer.write("@relation temperature\n\n");
        writer.write("@attribute Date date \"yyyy-MM-dd\"\n");
        writer.write("@attribute Temperature numeric\n");
        writer.write("@data\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < rqs.size(); i++) {
            String date = rqs.get(i);

            Double wd = Double.parseDouble(wds.get(i));
            writer.write("\"" + date + "\"," + wd + "\n");
        }
        writer.close();
        ConverterUtils.DataSource source = new ConverterUtils.DataSource("d:\\wd_dataset.arff");
        Instances data = source.getDataSet();
        // 设置类别索引（假设气温数据在最后一列）
        data.setClassIndex(data.numAttributes() - 1);
        // 创建LinearRegression对象
        LinearRegression model = new LinearRegression();
        model.buildClassifier(data);
        Instance newInstance = (Instance) data.lastInstance().copy();
        // 设置时间戳
        newInstance.setValue(data.attribute("Date"), data.lastInstance().value(data.attribute("Date")) + i1);
        // 使用模型进行预测
        double predictedTemperature = model.classifyInstance(newInstance);
        return predictedTemperature;
    }

    /**
     * 寒害预警
     * @param detail
     * @return
     */
    @GetMapping("/hhyj")
    public TableDataInfo hhyj(Detail detail) {
        startPage();
        List<Detail> list = detailService.selectDetailListhh_warn(detail);
        return getDataTable(list);
    }

    /**
     * 热害预警
     * @param detail
     * @return
     */
    @GetMapping("/rhyj")
    public TableDataInfo rhyj(Detail detail) {
        startPage();
        List<Detail> list = detailService.selectDetailListrh_warn(detail);
        return getDataTable(list);
    }

    /**
     * 干旱预警
     * @param detail
     * @return
     */
    @GetMapping("/ghyj")
    public TableDataInfo ghyj(Detail detail) {
        startPage();
        List<Detail> list = detailService.selectDetailListgh_warn(detail);
        return getDataTable(list);
    }

    /**
     * 干旱预警
     * @param detail
     * @return
     */
    @GetMapping("/hlyj")
    public TableDataInfo hlyj(Detail detail) {
        startPage();
        List<Detail> list = detailService.selectDetailListhl_warn(detail);
        return getDataTable(list);
    }

    @GetMapping("/dpfx")
    public AjaxResult dpfx() {
        List<Map> list = detailService.selectZhfx();
        return AjaxResult.success(list);
    }
}
