package com.example.demo.controller;

import com.example.demo.dto.srt.RqstParams;
import com.example.demo.service.mid.MidFcstInfoService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ApiController apiController;

    @MockBean
    MidFcstInfoService midFcstInfoService;

    // 중기 예보
    @DisplayName("중기 예보 API 호출")
    @Test
    public void 중기예보조회() throws Exception {

        // given
        RqstParams rqstParams = createRqstParams();

        // when then
        apiController.getMidFcst("getMidFcst", rqstParams);

        mockMvc.perform(
                        get("/getMidFcst")
                                .param("serviceKey", rqstParams.getServiceKey())
                                .param("numOfRows", rqstParams.getNumOfRows())
                                .param("pageNo", rqstParams.getPageNo())
                                .param("dataType", rqstParams.getDataType())
                                .param("tmFc", rqstParams.getTmFc())
                                .param("stnId", rqstParams.getStnId())
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    private RqstParams createRqstParams() {
        RqstParams rqstParams = new RqstParams();
        rqstParams.setServiceKey("K191VdXCbr8NWPrKcAnq1uzT01WQHRPglu0oJzfYyzYD2sjner2RWLyEB8peuW2v7E46s28axdc9EAYncGUX7A=="); // Enter the DecodingServiceKey
        rqstParams.setNumOfRows("5");
        rqstParams.setPageNo("1");
        rqstParams.setDataType("XML");
        rqstParams.setStnId("108");
        rqstParams.setRegId("11B00000");
        rqstParams.setTmFc("202308210600");
        return rqstParams;
    }

}
