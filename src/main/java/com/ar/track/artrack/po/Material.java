package com.ar.track.artrack.po;

import lombok.Data;

@Data
public class Material {
    private Integer id;
    private String pn;
    private String name;
    private Integer qty;
    private String location;
}