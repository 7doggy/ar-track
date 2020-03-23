package com.ar.track.artrack.mapper;

import java.util.List;

import com.ar.track.artrack.po.Position;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PositionMapper {
    
    List<Position> getAllPosition();
}