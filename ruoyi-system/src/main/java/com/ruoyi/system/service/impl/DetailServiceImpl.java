package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.system.domain.MovesDto;
import com.ruoyi.system.domain.model;
import com.ruoyi.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DetailMapper;
import com.ruoyi.system.domain.Detail;
import com.ruoyi.system.service.IDetailService;

import javax.validation.Validator;

/**
 * 天气管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
@Service
public class DetailServiceImpl implements IDetailService 
{
    @Autowired
    private DetailMapper detailMapper;
    @Autowired
    private ISysConfigService configService;

    @Autowired
    protected Validator validator;
    /**
     * 查询天气管理
     * 
     * @param id 天气管理主键
     * @return 天气管理
     */
    @Override
    public Detail selectDetailById(Long id)
    {
        return detailMapper.selectDetailById(id);
    }

    /**
     * 查询天气管理列表
     * 
     * @param detail 天气管理
     * @return 天气管理
     */
    @Override
    public List<Detail> selectDetailList(Detail detail)
    {
        return detailMapper.selectDetailList(detail);
    }

    /**
     * 新增天气管理
     * 
     * @param detail 天气管理
     * @return 结果
     */
    @Override
    public int insertDetail(Detail detail)
    {
        return detailMapper.insertDetail(detail);
    }

    /**
     * 修改天气管理
     * 
     * @param detail 天气管理
     * @return 结果
     */
    @Override
    public int updateDetail(Detail detail)
    {
        return detailMapper.updateDetail(detail);
    }

    /**
     * 批量删除天气管理
     * 
     * @param ids 需要删除的天气管理主键
     * @return 结果
     */
    @Override
    public int deleteDetailByIds(Long[] ids)
    {
        return detailMapper.deleteDetailByIds(ids);
    }

    /**
     * 删除天气管理信息
     * 
     * @param id 天气管理主键
     * @return 结果
     */
    @Override
    public int deleteDetailById(Long id)
    {
        return detailMapper.deleteDetailById(id);
    }

    @Override
    public String importUser(List<Detail> userList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (Detail detail : userList)
        {
            try
            {


                    BeanValidators.validateWithException(validator, detail);
//                    detail.setPassword(SecurityUtils.encryptPassword(password));
//                    detail.setDiqu(SecurityUtils.e);
//                    detail.setQy();
//                    detail.setQw();
//                    detail.setMaxqw();
//                    detail.setMinqw();
//                    detail.setSd();
//                    detail.setTjDate();
//                    user.setCreateBy(operName);
                    detailMapper.insertDetail(detail);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + detail.getDiqu() + " 导入成功");


            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + detail.getDiqu() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());

            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public MovesDto selectAll() {
        MovesDto dto =  new MovesDto();
        dto.setDiquname(new ArrayList<>());
        dto.setDiquvalue(new ArrayList<>());
        dto.setLeixingname(new ArrayList<>());
        dto.setLeixingvalue(new ArrayList<>());
        dto.setTicainame(new ArrayList<>());
        dto.setTicaivalue(new ArrayList<>());
        dto.setZifeiname(new ArrayList<>());
        dto.setZifeivalue(new ArrayList<>());
        List<model> selectdiqu = detailMapper.selectone();
        List<model> selectleixing = detailMapper.selecttwo();
        List<model> selectticai = detailMapper.selectthree();
        List<model> selectzifei = detailMapper.selectfour();
        for (model models : selectdiqu) {
            System.out.println(models.getName());
            dto.getDiquname().add(models.getName());
            dto.getDiquvalue().add(models.getCount());
        }
        for (model models : selectleixing) {
            dto.getLeixingname().add(models.getName());
            dto.getLeixingvalue().add(models.getCount());
        }
        for (model models : selectticai) {
            dto.getTicainame().add(models.getName());
            dto.getTicaivalue().add(models.getCount());
        }
        for (model models : selectzifei) {
            dto.getZifeiname().add(models.getName());
            dto.getZifeivalue().add(models.getCount());
        }
        return dto;
    }

    @Override
    public Map qwyc(String city) {
        List sj = detailMapper.selectSj(city);
        List qw = detailMapper.selectQw(city);
        Map map = new HashMap();
        map.put("sj",sj);
        map.put("qw",qw);
        return map;
    }

    @Override
    public Map sdyc(String city) {
        List sj = detailMapper.selectSj(city);
        List sd = detailMapper.selectSd(city);
        Map map = new HashMap();
        map.put("sj",sj);
        map.put("sd",sd);
        return map;
    }

    @Override
    public Map qyyc(String city) {
        List sj = detailMapper.selectSj(city);
        List sd = detailMapper.selectQy(city);
        Map map = new HashMap();
        map.put("sj",sj);
        map.put("qy",sd);
        return map;
    }

    @Override
    public List<Detail> selectDetailListhh_warn(Detail detail) {
        return detailMapper.selectDetailListHh(detail);
    }

    @Override
    public List<Detail> selectDetailListrh_warn(Detail detail) {
        return detailMapper.selectDetailListRh(detail);
    }

    @Override
    public List<Detail> selectDetailListgh_warn(Detail detail) {
        return detailMapper.selectDetailListGh(detail);
    }

    @Override
    public List<Detail> selectDetailListhl_warn(Detail detail) {
         return detailMapper.selectDetailListHl(detail);
    }

    @Override
    public List<Map> selectZhfx() {
        return detailMapper.selectZhfx();
    }

}
