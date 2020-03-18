package com.ar.track.artrack.vo;

import lombok.Data;

@Data
public class ResponseVO {
    public int success;
    public String code;
    public String errMsg;
    public Object data;
}