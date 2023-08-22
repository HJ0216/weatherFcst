package com.example.demo.dto.srt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RqstParams {

    // 공통
    private String serviceKey;
    private String numOfRows;
    private String pageNo;
    private String dataType;


    // 중기
    private String stnId;
    private String regId;
    private String tmFc;


    // 단기
    private String base_date;
    private String base_time;
    private String nx;
    private String ny;

}
