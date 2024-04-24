package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.Detail;
import com.ruoyi.system.domain.model;

/**
 * 天气管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
public interface DetailMapper 
{
    /**
     * 查询天气管理
     * 
     * @param id 天气管理主键
     * @return 天气管理
     */
    public Detail selectDetailById(Long id);

    /**
     * 查询天气管理列表
     * 
     * @param detail 天气管理
     * @return 天气管理集合
     */
    public List<Detail> selectDetailList(Detail detail);

    /**
     * 新增天气管理
     * 
     * @param detail 天气管理
     * @return 结果
     */
    public int insertDetail(Detail detail);

    /**
     * 修改天气管理
     * 
     * @param detail 天气管理
     * @return 结果
     */
    public int updateDetail(Detail detail);

    /**
     * 删除天气管理
     * 
     * @param id 天气管理主键
     * @return 结果
     */
    public int deleteDetailById(Long id);

    /**
     * 批量删除天气管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDetailByIds(Long[] ids);

    List<model> selectone();

    List<model> selecttwo();

    List<model> selectthree();

    List<model> selectfour();

    List<String> selectSj(String city);

    List<String> selectQw(String city);

    List<String> selectSd(String city);

    List<String> selectQy(String city);

    List<Detail> selectDetailListHh(Detail detail);

    List<Detail> selectDetailListRh(Detail detail);

    List<Detail> selectDetailListGh(Detail detail);

    List<Detail> selectDetailListHl(Detail detail);

    List<Map> selectZhfx();
}
