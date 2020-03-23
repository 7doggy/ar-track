package com.ar.track.artrack.controller;

import com.ar.track.artrack.TrackHandler;
import com.ar.track.artrack.vo.PositionVO;
import com.ar.track.artrack.vo.ResponseVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {

    @GetMapping("/getposition")
    public ResponseVO getPosition() {
        PositionVO position = TrackHandler.position;
        ResponseVO responseVO = new ResponseVO();
        responseVO.setSuccess(1);
        responseVO.setCode("");
        responseVO.setErrMsg("");
        responseVO.setData(position);
        return responseVO;
    }
}