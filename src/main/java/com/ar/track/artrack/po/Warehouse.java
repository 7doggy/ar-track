package com.ar.track.artrack.po;

import lombok.Data;

@Data
public class Warehouse {
    private String id;
    private String shelf;
    private String location;
    private String pn;
    private Integer qity;
    private Float x;
    private Float y;
    private Float z;
    private Integer priority;
}