package com.ar.track.artrack.controller;

import java.util.Arrays;

import com.ar.track.artrack.TrackHandler;
import com.ar.track.artrack.vo.Position;
import com.ar.track.artrack.vo.ResponseVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {

    @GetMapping("/getposition")
    public ResponseVO getPosition() {
        Position position = TrackHandler.position;
        ResponseVO responseVO = new ResponseVO();
        responseVO.setSuccess(1);
        responseVO.setCode("");
        responseVO.setErrMsg("");
        responseVO.setData(position);
        return responseVO;
    }
}