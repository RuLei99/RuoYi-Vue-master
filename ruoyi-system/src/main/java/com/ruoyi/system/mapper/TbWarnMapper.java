package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TbWarn;

/**
 * 预警设置Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-23
 */
public interface TbWarnMapper 
{
    /**
     * 查询预警设置
     * 
     * @param id 预警设置主键
     * @return 预警设置
     */
    public TbWarn selectTbWarnById(Long id);

    /**
     * 查询预警设置列表
     * 
     * @param tbWarn 预警设置
     * @return 预警设置集合
     */
    public List<TbWarn> selectTbWarnList(TbWarn tbWarn);

    /**
     * 新增预警设置
     * 
     * @param tbWarn 预警设置
     * @return 结果
     */
    public int insertTbWarn(TbWarn tbWarn);

    /**
     * 修改预警设置
     * 
     * @param tbWarn 预警设置
     * @return 结果
     */
    public int updateTbWarn(TbWarn tbWarn);

    /**
     * 删除预警设置
     * 
     * @param id 预警设置主键
     * @return 结果
     */
    public int deleteTbWarnById(Long id);

    /**
     * 批量删除预警设置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbWarnByIds(Long[] ids);
}
