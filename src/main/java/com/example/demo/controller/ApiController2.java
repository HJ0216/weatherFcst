package com.example.demo.controller;

import com.example.demo.dto.srt.RqstParams;
import com.example.demo.service.srt.SrtFcstInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "weather")
public class ApiController2 {

    @Autowired
    private SrtFcstInfoService srtFcstInfoService;

    @GetMapping(value = "/getUltraSrtNcst")
    public void getUltraSrtNcst(@ModelAttribute RqstParams rqstParams) {
        srtFcstInfoService.getUltraSrtNcst(rqstParams);
    }

    @GetMapping(value = "/getUltraSrtFcst")
    public void getUltraSrtFcst(@ModelAttribute RqstParams rqstParams) {
        srtFcstInfoService.getUltraSrtFcst(rqstParams);
    }

    @GetMapping(value = "/getVilageFcst")
    public void getVilageFcst(@ModelAttribute RqstParams rqstParams) {
        srtFcstInfoService.getVilageFcst(rqstParams);
    }

}
