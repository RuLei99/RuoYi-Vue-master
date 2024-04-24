package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预警设置对象 tb_warn
 * 
 * @author ruoyi
 * @date 2024-04-23
 */
public class TbWarn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 气温低报 */
    @Excel(name = "气温低报")
    private String qwLow;

    /** 气温高报 */
    @Excel(name = "气温高报")
    private String qwHeight;

    /** 降雨低报 */
    @Excel(name = "降雨低报")
    private String jyLow;

    /** 降雨高报 */
    @Excel(name = "降雨高报")
    private String jyHeight;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setQwLow(String qwLow) 
    {
        this.qwLow = qwLow;
    }

    public String getQwLow() 
    {
        return qwLow;
    }
    public void setQwHeight(String qwHeight) 
    {
        this.qwHeight = qwHeight;
    }

    public String getQwHeight() 
    {
        return qwHeight;
    }
    public void setJyLow(String jyLow) 
    {
        this.jyLow = jyLow;
    }

    public String getJyLow() 
    {
        return jyLow;
    }
    public void setJyHeight(String jyHeight) 
    {
        this.jyHeight = jyHeight;
    }

    public String getJyHeight() 
    {
        return jyHeight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("qwLow", getQwLow())
            .append("qwHeight", getQwHeight())
            .append("jyLow", getJyLow())
            .append("jyHeight", getJyHeight())
            .toString();
    }
}
