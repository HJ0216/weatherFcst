package com.example.demo.dto.srt;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RqstParams {

    private String serviceKey;
    private String numOfRows;
    private String pageNo;
    private String dataType;
    private String base_date;
    private String base_time;
    private String nx;
    private String ny;

}
