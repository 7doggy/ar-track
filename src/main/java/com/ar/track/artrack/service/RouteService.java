package com.ar.track.artrack.service;

import java.util.List;

import com.ar.track.artrack.vo.TrackVO;

public interface RouteService {
    /**
     * 获取到收货点的路径（包括收货点）
     * @return list
     */
    List<TrackVO> findInTrack();
}