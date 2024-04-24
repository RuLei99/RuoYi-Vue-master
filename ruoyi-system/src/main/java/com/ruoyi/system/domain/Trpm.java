package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 土壤刨面分布对象 trpm
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
public class Trpm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 剖面编号 */
    @Excel(name = "剖面编号")
    private String pmCode;

    /** 天气 */
    @Excel(name = "天气")
    private String tianqi;

    /** 省份 */
    @Excel(name = "省份")
    private String shen;

    /** 	市县 */
    @Excel(name = "	市县")
    private String shixian;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPmCode(String pmCode) 
    {
        this.pmCode = pmCode;
    }

    public String getPmCode() 
    {
        return pmCode;
    }
    public void setTianqi(String tianqi) 
    {
        this.tianqi = tianqi;
    }

    public String getTianqi() 
    {
        return tianqi;
    }
    public void setShen(String shen) 
    {
        this.shen = shen;
    }

    public String getShen() 
    {
        return shen;
    }
    public void setShixian(String shixian) 
    {
        this.shixian = shixian;
    }

    public String getShixian() 
    {
        return shixian;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pmCode", getPmCode())
            .append("tianqi", getTianqi())
            .append("shen", getShen())
            .append("shixian", getShixian())
            .toString();
    }
}
