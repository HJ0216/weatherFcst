package com.example.demo.controller;

import com.example.demo.dto.srt.RqstParams;
import com.example.demo.service.mid.MidFcstInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ApiController {

    // 중기 예보
    @Autowired
    private MidFcstInfoService midFcstInfoService;

    @GetMapping(value = "/{type}")
    public void getMidFcst(@PathVariable String type, @ModelAttribute RqstParams rqstParams) {
        String midFcstInfo_url = "https://apis.data.go.kr/1360000/MidFcstInfoService/";

        UriComponentsBuilder modifiedUriBuilder = UriComponentsBuilder
                .fromHttpUrl(midFcstInfo_url + type)
                .queryParam("serviceKey", rqstParams.getServiceKey())
                .queryParam("numOfRows", rqstParams.getNumOfRows())
                .queryParam("pageNo", rqstParams.getPageNo())
                .queryParam("dataType", rqstParams.getDataType())
                .queryParam("tmFc", rqstParams.getTmFc());

        if ("getMidFcst".equals(type)) {
            modifiedUriBuilder.queryParam("stnId", rqstParams.getStnId());
        } else {
            modifiedUriBuilder.queryParam("regId", rqstParams.getRegId());
        }

        UriComponents modifiedUri = modifiedUriBuilder.build();
        midFcstInfoService.midFcstData(type, modifiedUri.toString());

    }

}
