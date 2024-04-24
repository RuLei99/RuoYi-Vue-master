package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 土壤分布管理对象 soil
 * 
 * @author ruoyi
 * @date 2024-04-08
 */
public class Soil extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 土种名称 */
    @Excel(name = "土种名称")
    private String tName;

    /** 土类名称 */
    @Excel(name = "土类名称")
    private String tType;

    /** 亚类名称 */
    @Excel(name = "亚类名称")
    private String yzName;

    /** 母质 */
    @Excel(name = "母质")
    private String mz;

    /** 县市 */
    @Excel(name = "县市")
    private String xian;

    /** 省份 */
    @Excel(name = "省份")
    private String shen;

    private List<String> xians;

    private List<String> shens;

    public List<String> getXians() {
        return xians;
    }

    public void setXians(List<String> xians) {
        this.xians = xians;
    }

    public List<String> getShens() {
        return shens;
    }

    public void setShens(List<String> shens) {
        this.shens = shens;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void settName(String tName) 
    {
        this.tName = tName;
    }

    public String gettName() 
    {
        return tName;
    }
    public void settType(String tType) 
    {
        this.tType = tType;
    }

    public String gettType() 
    {
        return tType;
    }
    public void setYzName(String yzName) 
    {
        this.yzName = yzName;
    }

    public String getYzName() 
    {
        return yzName;
    }
    public void setMz(String mz) 
    {
        this.mz = mz;
    }

    public String getMz() 
    {
        return mz;
    }
    public void setXian(String xian) 
    {
        this.xian = xian;
    }

    public String getXian() 
    {
        return xian;
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
            .append("tName", gettName())
            .append("tType", gettType())
            .append("yzName", getYzName())
            .append("mz", getMz())
            .append("xian", getXian())
            .append("shen", getShen())
            .toString();
    }
}
