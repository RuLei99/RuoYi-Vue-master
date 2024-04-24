package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TbWarnMapper;
import com.ruoyi.system.domain.TbWarn;
import com.ruoyi.system.service.ITbWarnService;

/**
 * 预警设置Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-23
 */
@Service
public class TbWarnServiceImpl implements ITbWarnService 
{
    @Autowired
    private TbWarnMapper tbWarnMapper;

    /**
     * 查询预警设置
     * 
     * @param id 预警设置主键
     * @return 预警设置
     */
    @Override
    public TbWarn selectTbWarnById(Long id)
    {
        return tbWarnMapper.selectTbWarnById(id);
    }

    /**
     * 查询预警设置列表
     * 
     * @param tbWarn 预警设置
     * @return 预警设置
     */
    @Override
    public List<TbWarn> selectTbWarnList(TbWarn tbWarn)
    {
        return tbWarnMapper.selectTbWarnList(tbWarn);
    }

    /**
     * 新增预警设置
     * 
     * @param tbWarn 预警设置
     * @return 结果
     */
    @Override
    public int insertTbWarn(TbWarn tbWarn)
    {
        return tbWarnMapper.insertTbWarn(tbWarn);
    }

    /**
     * 修改预警设置
     * 
     * @param tbWarn 预警设置
     * @return 结果
     */
    @Override
    public int updateTbWarn(TbWarn tbWarn)
    {
        return tbWarnMapper.updateTbWarn(tbWarn);
    }

    /**
     * 批量删除预警设置
     * 
     * @param ids 需要删除的预警设置主键
     * @return 结果
     */
    @Override
    public int deleteTbWarnByIds(Long[] ids)
    {
        return tbWarnMapper.deleteTbWarnByIds(ids);
    }

    /**
     * 删除预警设置信息
     * 
     * @param id 预警设置主键
     * @return 结果
     */
    @Override
    public int deleteTbWarnById(Long id)
    {
        return tbWarnMapper.deleteTbWarnById(id);
    }
}
