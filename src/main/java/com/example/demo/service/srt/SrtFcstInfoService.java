package com.example.demo.service.srt;

import com.example.demo.dto.srt.RqstParams;

public interface SrtFcstInfoService {

    // UltraSrtNcst
    public void getUltraSrtNcst(RqstParams rqstParams);

    public void saveUltraSrtNcst(String response);


    // UltraSrtFcst
    public void getUltraSrtFcst(RqstParams rqstParams);

    public void saveUltraSrtFcst(String response);


    // UltraSrtFcst
    public void getVilageFcst(RqstParams rqstParams);

    public void saveVilageFcst(String response);

}
