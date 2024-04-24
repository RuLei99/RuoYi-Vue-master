package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Trpm;

/**
 * 土壤刨面分布Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
public interface TrpmMapper 
{
    /**
     * 查询土壤刨面分布
     * 
     * @param id 土壤刨面分布主键
     * @return 土壤刨面分布
     */
    public Trpm selectTrpmById(Long id);

    /**
     * 查询土壤刨面分布列表
     * 
     * @param trpm 土壤刨面分布
     * @return 土壤刨面分布集合
     */
    public List<Trpm> selectTrpmList(Trpm trpm);

    /**
     * 新增土壤刨面分布
     * 
     * @param trpm 土壤刨面分布
     * @return 结果
     */
    public int insertTrpm(Trpm trpm);

    /**
     * 修改土壤刨面分布
     * 
     * @param trpm 土壤刨面分布
     * @return 结果
     */
    public int updateTrpm(Trpm trpm);

    /**
     * 删除土壤刨面分布
     * 
     * @param id 土壤刨面分布主键
     * @return 结果
     */
    public int deleteTrpmById(Long id);

    /**
     * 批量删除土壤刨面分布
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTrpmByIds(Long[] ids);
}
