package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Tryf;
import com.ruoyi.system.domain.model;

/**
 * 土壤养分分布Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
public interface TryfMapper 
{
    /**
     * 查询土壤养分分布
     * 
     * @param id 土壤养分分布主键
     * @return 土壤养分分布
     */
    public Tryf selectTryfById(Long id);

    /**
     * 查询土壤养分分布列表
     * 
     * @param tryf 土壤养分分布
     * @return 土壤养分分布集合
     */
    public List<Tryf> selectTryfList(Tryf tryf);

    /**
     * 新增土壤养分分布
     * 
     * @param tryf 土壤养分分布
     * @return 结果
     */
    public int insertTryf(Tryf tryf);

    /**
     * 修改土壤养分分布
     * 
     * @param tryf 土壤养分分布
     * @return 结果
     */
    public int updateTryf(Tryf tryf);

    /**
     * 删除土壤养分分布
     * 
     * @param id 土壤养分分布主键
     * @return 结果
     */
    public int deleteTryfById(Long id);

    /**
     * 批量删除土壤养分分布
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTryfByIds(Long[] ids);


    List<model> selectone();

    List<model> selecttwo();

    List<model> selectthree();

    List<model> selectfour();
}
