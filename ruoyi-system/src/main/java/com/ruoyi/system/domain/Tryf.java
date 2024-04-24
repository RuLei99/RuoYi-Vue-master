package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 土壤养分分布对象 tryf
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
public class Tryf extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 	
场地名称 */
    @Excel(name = "场地名称")
    private String cdname;

    /** 	行政地点 */
    @Excel(name = "	行政地点")
    private String dizhi;

    /** 省份 */
    @Excel(name = "省份")
    private String shen;

    /** 	县市 */
    @Excel(name = "	县市")
    private String xian;

    /** 土地利用类型 */
    @Excel(name = "土地利用类型")
    private String type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCdname(String cdname) 
    {
        this.cdname = cdname;
    }

    public String getCdname() 
    {
        return cdname;
    }
    public void setDizhi(String dizhi) 
    {
        this.dizhi = dizhi;
    }

    public String getDizhi() 
    {
        return dizhi;
    }
    public void setShen(String shen) 
    {
        this.shen = shen;
    }

    public String getShen() 
    {
        return shen;
    }
    public void setXian(String xian) 
    {
        this.xian = xian;
    }

    public String getXian() 
    {
        return xian;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cdname", getCdname())
            .append("dizhi", getDizhi())
            .append("shen", getShen())
            .append("xian", getXian())
            .append("type", getType())
            .toString();
    }
}
