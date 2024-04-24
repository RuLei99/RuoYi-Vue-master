package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 地区管理对象 dq
 * 
 * @author ruoyi
 * @date 2024-04-08
 */
public class Dq extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 省份代码 */
    @Excel(name = "省份代码")
    private String shencode;

    /** 县市 */
    @Excel(name = "县市")
    private String xian;

    /** 精度 */
    @Excel(name = "精度")
    private String jd;

    /** 纬度 */
    @Excel(name = "纬度")
    private String wd;

    /** 省份 */
    @Excel(name = "省份")
    private String shen;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShencode(String shencode) 
    {
        this.shencode = shencode;
    }

    public String getShencode() 
    {
        return shencode;
    }
    public void setXian(String xian) 
    {
        this.xian = xian;
    }

    public String getXian() 
    {
        return xian;
    }
    public void setJd(String jd) 
    {
        this.jd = jd;
    }

    public String getJd() 
    {
        return jd;
    }
    public void setWd(String wd) 
    {
        this.wd = wd;
    }

    public String getWd() 
    {
        return wd;
    }
    public void setShen(String shen) 
    {
        this.shen = shen;
    }

    public String getShen() 
    {
        return shen;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shencode", getShencode())
            .append("xian", getXian())
            .append("jd", getJd())
            .append("wd", getWd())
            .append("shen", getShen())
            .toString();
    }
}
