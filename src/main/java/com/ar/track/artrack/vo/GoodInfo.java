package com.ar.track.artrack.vo;

import lombok.Data;

@Data
public class GoodInfo {
    private String id;
    /**
     * 出库或入库 type
     */
    private String type;
    /**
     * 物料编号
     */
    private String code;
    /**
     * 物料名称
     */
    private String name;

    /**
     * 货架号
     */
    private String shelf;
    /**
     * 货位号
     */
    private String location;
    
    private float h;

    private float x;

    private float y;

}