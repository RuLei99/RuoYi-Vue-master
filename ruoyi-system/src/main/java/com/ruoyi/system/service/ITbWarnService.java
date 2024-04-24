package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TbWarn;

/**
 * 预警设置Service接口
 * 
 * @author ruoyi
 * @date 2024-04-23
 */
public interface ITbWarnService 
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
     * 批量删除预警设置
     * 
     * @param ids 需要删除的预警设置主键集合
     * @return 结果
     */
    public int deleteTbWarnByIds(Long[] ids);

    /**
     * 删除预警设置信息
     * 
     * @param id 预警设置主键
     * @return 结果
     */
    public int deleteTbWarnById(Long id);
}
