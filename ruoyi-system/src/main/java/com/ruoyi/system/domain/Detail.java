package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 天气管理对象 detail
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
public class Detail extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    private Long id;

    /** 地区 */
    @Excel(name = "地区")
    private String diqu;

    /** 气压 */
    @Excel(name = "气压")
    private String qy;

    /** 气温 */
    @Excel(name = "气温")
    private String qw;

    /** 最高气温 */
    @Excel(name = "最高气温")
    private String maxqw;

    /** 最低气温 */
    @Excel(name = "最低气温")
    private String minqw;

    /** 相对湿度 */
    @Excel(name = "相对湿度")
    private String sd;
    @Excel(name = "降雨量")
    private String jyl;
    @Excel(name = "风速")
    private String fs;
    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tjDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDiqu(String diqu) 
    {
        this.diqu = diqu;
    }

    public String getDiqu() 
    {
        return diqu;
    }
    public void setQy(String qy) 
    {
        this.qy = qy;
    }

    public String getQy() 
    {
        return qy;
    }
    public void setQw(String qw) 
    {
        this.qw = qw;
    }

    public String getQw() 
    {
        return qw;
    }
    public void setMaxqw(String maxqw) 
    {
        this.maxqw = maxqw;
    }

    public String getMaxqw() 
    {
        return maxqw;
    }
    public void setMinqw(String minqw) 
    {
        this.minqw = minqw;
    }

    public String getMinqw() 
    {
        return minqw;
    }
    public void setSd(String sd) 
    {
        this.sd = sd;
    }

    public String getSd() 
    {
        return sd;
    }
    public void setTjDate(Date tjDate) 
    {
        this.tjDate = tjDate;
    }

    public Date getTjDate() 
    {
        return tjDate;
    }

    public String getJyl() {
        return jyl;
    }

    public void setJyl(String jyl) {
        this.jyl = jyl;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("diqu", getDiqu())
            .append("qy", getQy())
            .append("qw", getQw())
            .append("maxqw", getMaxqw())
            .append("minqw", getMinqw())
            .append("sd", getSd())
            .append("tjDate", getTjDate())
            .toString();
    }
}
