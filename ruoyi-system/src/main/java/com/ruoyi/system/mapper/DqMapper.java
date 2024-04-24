package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Dq;

/**
 * 地区管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-08
 */
public interface DqMapper 
{
    /**
     * 查询地区管理
     * 
     * @param id 地区管理主键
     * @return 地区管理
     */
    public Dq selectDqById(Long id);

    /**
     * 查询地区管理列表
     * 
     * @param dq 地区管理
     * @return 地区管理集合
     */
    public List<Dq> selectDqList(Dq dq);

    /**
     * 新增地区管理
     * 
     * @param dq 地区管理
     * @return 结果
     */
    public int insertDq(Dq dq);

    /**
     * 修改地区管理
     * 
     * @param dq 地区管理
     * @return 结果
     */
    public int updateDq(Dq dq);

    /**
     * 删除地区管理
     * 
     * @param id 地区管理主键
     * @return 结果
     */
    public int deleteDqById(Long id);

    /**
     * 批量删除地区管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDqByIds(Long[] ids);

    List<String> selectxian();

    List<String> selectshen();
}
