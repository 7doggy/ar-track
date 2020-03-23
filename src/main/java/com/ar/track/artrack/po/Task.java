package com.ar.track.artrack.po;

import java.util.Date;

import lombok.Data;

@Data
public class Task {
    private String id;
    private Date applyDate;
    /**
     * 0 待下发
     * 1 已下发
     * 2 已完成
     */
    private String status;
    private String receiveStatus;
    /**
     * 1 出库
     * 2 入库
     */
    private String applyType;
}