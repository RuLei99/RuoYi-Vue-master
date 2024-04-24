package com.ruoyi.system.domain;

import lombok.Data;

import java.util.List;

/**
 * @packageName: com.ruoyi.system.domain
 * @author:
 * @date: 2024/4/7 17:54
 * @description:
 */
@Data
public class MovesDto {
    private List<String> diquname;
    private List<Integer> diquvalue;
    private List<String> leixingname;
    private List<Integer> leixingvalue;
    private List<String> ticainame;
    private List<Integer> ticaivalue;
    private List<String> zifeiname;
    private List<Integer> zifeivalue;
}