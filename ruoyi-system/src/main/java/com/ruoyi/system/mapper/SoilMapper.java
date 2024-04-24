package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Soil;

/**
 * 土壤分布管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-08
 */
public interface SoilMapper 
{
    /**
     * 查询土壤分布管理
     * 
     * @param id 土壤分布管理主键
     * @return 土壤分布管理
     */
    public Soil selectSoilById(Long id);

    /**
     * 查询土壤分布管理列表
     * 
     * @param soil 土壤分布管理
     * @return 土壤分布管理集合
     */
    public List<Soil> selectSoilList(Soil soil);

    /**
     * 新增土壤分布管理
     * 
     * @param soil 土壤分布管理
     * @return 结果
     */
    public int insertSoil(Soil soil);

    /**
     * 修改土壤分布管理
     * 
     * @param soil 土壤分布管理
     * @return 结果
     */
    public int updateSoil(Soil soil);

    /**
     * 删除土壤分布管理
     * 
     * @param id 土壤分布管理主键
     * @return 结果
     */
    public int deleteSoilById(Long id);

    /**
     * 批量删除土壤分布管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSoilByIds(Long[] ids);
}
