package com.example.demo.service;

import com.example.demo.dao.srt.SrtFcstInfoDAO;
import com.example.demo.dao.srt.SrtFcstInfoRepository;
import com.example.demo.dto.srt.RqstParams;
import com.example.demo.entity.srt.UltraSrtFcst;
import com.example.demo.entity.srt.UltraSrtNcst;
import com.example.demo.entity.srt.VilageFcst;
import com.example.demo.service.srt.SrtFcstInfoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SrtFcstInfoServiceTest {

    @Autowired
    SrtFcstInfoServiceImpl srtFcstInfoService;
    @Autowired
    SrtFcstInfoDAO srtFcstInfoDAO;
    @Autowired
    SrtFcstInfoRepository srtFcstInfoRepository;



    // UltraSrtNcst
    @Test
    public void 초단기실황조회() throws Exception {

        // given
        RqstParams rqstParams = createRqstParams();

        // when
        srtFcstInfoService.getUltraSrtNcst(rqstParams);

        // then
        List<UltraSrtNcst> savedDataList = srtFcstInfoRepository.findAllUltraSrtNcst();
        assertEquals(Integer.parseInt(rqstParams.getNumOfRows()), savedDataList.size());

    }



    // UltraSrtFcst
    @Test
    public void 초단기예보조회() throws Exception {

        // given
        RqstParams rqstParams = createRqstParams();

        // when
        srtFcstInfoService.getUltraSrtFcst(rqstParams);

        // then
        List<UltraSrtFcst> savedDataList = srtFcstInfoRepository.findAllUltraSrtFcst();
        assertEquals(Integer.parseInt(rqstParams.getNumOfRows()), savedDataList.size());

    }


    // VilageFcst
    @Test
    public void 단기예보조회() throws Exception {

        // given
        RqstParams rqstParams = createRqstParams();

        // when
        srtFcstInfoService.getVilageFcst(rqstParams);

        // then
        List<VilageFcst> savedDataList = srtFcstInfoRepository.findAllVilageFcst();
        assertEquals(Integer.parseInt(rqstParams.getNumOfRows()), savedDataList.size());

    }

    private RqstParams createRqstParams() {
        RqstParams rqstParams = new RqstParams();
        rqstParams.setServiceKey(""); // Enter the DecodingServiceKey
        rqstParams.setNumOfRows("5");
        rqstParams.setPageNo("1");
        rqstParams.setDataType("XML");
        rqstParams.setBase_date("20230821");
        rqstParams.setBase_time("0500");
        rqstParams.setNx("55");
        rqstParams.setNy("127");
        return rqstParams;
    }

}
