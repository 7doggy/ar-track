package com.ar.track.artrack.service;

import java.util.ArrayList;
import java.util.List;

import com.ar.track.artrack.TrackHandler;
import com.ar.track.artrack.vo.PositionVO;
import com.ar.track.artrack.vo.TrackVO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

    @Value("${pX}")
    private float pX;

    @Value("${pY}")
    private float pY;
    // 出入库区尺寸
    @Value("${areaX}")
    private float areaX;
    // 出入库区尺寸
    @Value("${areaY}")
    private float areaY;

    @Value("${s1X}")
    private float s1X;

    @Value("${s1Y}")
    private float s1Y;

    /**
     * 获取当前位置到收货点的路径（包括收货点）
     * 
     * @return list
     */
    @Override
    public List<TrackVO> findInTrack() {
        List<TrackVO> tList = new ArrayList<>();
        // 获取当前位置坐标
        PositionVO currentP = TrackHandler.position;
        // 获取收货区域中心点
        PositionVO inP = new PositionVO();
        inP.setX(areaX / 2 + pX);
        inP.setY(areaY / 2 + pY);
        //初始化入库收货区域中心点
        TrackVO tVo = new TrackVO();
        tVo.setType("sh");
        tVo.setX(inP.getX());
        tVo.setY(inP.getY());
        //判断是否转弯点
        if ((currentP.getX() >= inP.getX() - areaX / 2 
            && currentP.getX() <= inP.getX() + areaX / 2)
            ||
           (currentP.getY() >= inP.getY() - areaY / 2
            && currentP.getY() <= inP.getY() + areaY / 2)) {
            //在入库区域内，不需要转弯点
            //给出入库收货区域中心点
            tList.add(tVo);
        } else {
            //需要一个转弯点
            TrackVO tVo1 = new TrackVO();
            tVo1.setType("zw");
            tVo1.setX(currentP.getX());
            tVo1.setY(inP.getY());
            tList.add(tVo1);
            //再加入库收货区域中心点
            tList.add(tVo);
        }
        return tList;
    }

}