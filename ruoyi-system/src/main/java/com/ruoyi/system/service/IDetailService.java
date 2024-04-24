package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.Detail;
import com.ruoyi.system.domain.MovesDto;

/**
 * 天气管理Service接口
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
public interface IDetailService 
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
     * 批量删除天气管理
     * 
     * @param ids 需要删除的天气管理主键集合
     * @return 结果
     */
    public int deleteDetailByIds(Long[] ids);

    /**
     * 删除天气管理信息
     * 
     * @param id 天气管理主键
     * @return 结果
     */
    public int deleteDetailById(Long id);

    String importUser(List<Detail> userList, boolean updateSupport, String operName);

    MovesDto selectAll();

    Map qwyc(String city);

    Map sdyc(String city);

    Map qyyc(String city);

    List<Detail> selectDetailListhh_warn(Detail detail);

    List<Detail> selectDetailListrh_warn(Detail detail);

    List<Detail> selectDetailListgh_warn(Detail detail);

    List<Detail> selectDetailListhl_warn(Detail detail);

    List<Map> selectZhfx();
}
