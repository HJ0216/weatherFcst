package com.example.demo.service;

import com.example.demo.dao.mid.MidFcstInfoDAO;
import com.example.demo.dao.mid.MidFcstInfoRepository;
import com.example.demo.entity.mid.MidFcst;
import com.example.demo.entity.mid.MidLandFcst;
import com.example.demo.entity.mid.MidSeaFcst;
import com.example.demo.entity.mid.MidTa;
import com.example.demo.service.mid.MidFcstInfoService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MidFcstInfoServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    MidFcstInfoService midFcstInfoService;

    @Autowired
    MidFcstInfoDAO midFcstInfoDAO;

    @Autowired
    MidFcstInfoRepository midFcstInfoRepository;

    // 중기 전망 조회
    @DisplayName("MidFcst 저장")
    @Test
    public void midFcst_저장() throws Exception {

        // given
        JSONObject item = new JSONObject();
        item.put("wfSv", "test");

        // when
        midFcstInfoService.saveMidFcst(item);

        // then
        List<MidFcst> savedMidFcstList = midFcstInfoRepository.findByWfSv("test"); // 저장된 데이터 조회
        assertThat(savedMidFcstList.size()).isEqualTo(1);
    }


    // 중기 육상 예보 조회
    @DisplayName("MidLandFcst 저장")
    @Test
    public void MidLandFcst_저장() throws Exception {

        // given
        JSONObject item = new JSONObject();
        item.put("regId", "test");

        String[] rnStArr = {"rnSt3Am", "rnSt3Pm", "rnSt4Am", "rnSt4Pm", "rnSt5Am", "rnSt5Pm", "rnSt6Am", "rnSt6Pm", "rnSt7Am", "rnSt7Pm", "rnSt8", "rnSt9", "rnSt10"};
        String[] wfArr = {"wf3Am", "wf3Pm", "wf4Am", "wf4Pm", "wf5Am", "wf5Pm", "wf6Am", "wf6Pm", "wf7Am", "wf7Pm", "wf8", "wf9", "wf10"};

        for (int i = 0; i < rnStArr.length; i++) {
            item.put(rnStArr[i], "rnStSampleData");
        }
        for (int i = 0; i < wfArr.length; i++) {
            item.put(wfArr[i], "wfSampleData");
        }

        // when
        midFcstInfoService.saveMidLandFcst(item);

        // then
        List<MidLandFcst> savedMidLandFcstList = midFcstInfoRepository.findByRegIdFromMidLandFcst("test"); // 저장된 데이터 조회
        assertThat(savedMidLandFcstList.size()).isEqualTo(1);
    }


    // 중기 기온 조회
    @DisplayName("MidTa 저장")
    @Test
    public void MidTa_저장() throws Exception {

        // given
        JSONObject item = new JSONObject();
        item.put("regId", "test");

        String[] taMin = {"taMin3", "taMin4", "taMin5", "taMin6", "taMin7", "taMin8", "taMin9", "taMin10"};
        String[] taMinLow = {"taMin3Low", "taMin4Low", "taMin5Low", "taMin6Low", "taMin7Low", "taMin8Low", "taMin9Low", "taMin10Low"};
        String[] taMinHigh = {"taMin3High", "taMin4High", "taMin5High", "taMin6High", "taMin7High", "taMin8High", "taMin9High", "taMin10High"};

        String[] taMax = {"taMax3", "taMax4", "taMax5", "taMax6", "taMax7", "taMax8", "taMax9", "taMax10"};
        String[] taMaxLow = {"taMax3Low", "taMax4Low", "taMax5Low", "taMax6Low", "taMax7Low", "taMax8Low", "taMax9Low", "taMax10Low"};
        String[] taMaxHigh = {"taMax3High", "taMax4High", "taMax5High", "taMax6High", "taMax7High", "taMax8High", "taMax9High", "taMax10High"};

        for (int i = 0; i < taMin.length; i++) {
            item.put(taMin[i], "taMinSampleData");
            item.put(taMinLow[i], "taMinLowSampleData");
            item.put(taMinHigh[i], "taMinHighSampleData");
        }
        for (int i = 0; i < taMax.length; i++) {
            item.put(taMax[i], "taMaxSampleData");
            item.put(taMaxLow[i], "taMaxLowSampleData");
            item.put(taMaxHigh[i], "taMaxHighSampleData");
        }

        // when
        midFcstInfoService.saveMidTa(item);

        // then
        List<MidTa> savedMidTaList = midFcstInfoRepository.findByRegIdFromMidTa("test");
        assertThat(savedMidTaList.size()).isEqualTo(1);
    }


    // 중기 해상 예보 조회
    @DisplayName("MidSeaFcst 저장")
    @Test
    public void MidSeaFcst_저장() throws Exception {

        // given
        JSONObject item = new JSONObject();
        item.put("regId", "test");

        String[] wfArr = {"wf3Am", "wf3Pm", "wf4Am", "wf4Pm", "wf5Am", "wf5Pm", "wf6Am", "wf6Pm", "wf7Am", "wf7Pm", "wf8", "wf9", "wf10"};
        String[] whAArr = {"wh3AAm", "wh3APm", "wh4AAm", "wh4APm", "wh5AAm", "wh5APm", "wh6AAm", "wh6APm", "wh7AAm", "wh7APm", "wh8A", "wh9A", "wh10A"};
        String[] whABrr = {"wh3BAm", "wh3BPm", "wh4BAm", "wh4BPm", "wh5BAm", "wh5BPm", "wh6BAm", "wh6BPm", "wh7BAm", "wh7BPm", "wh8B", "wh9B", "wh10B"};

        for (int i = 0; i < wfArr.length; i++) {
            item.put(wfArr[i], "wfSampleData");
        }
        for (int i = 0; i < whAArr.length; i++) {
            item.put(whAArr[i], "whASampleData");
        }
        for (int i = 0; i < whABrr.length; i++) {
            item.put(whABrr[i], "whBSampleData");
        }

        // when
        midFcstInfoService.saveMidSeaFcst(item);

        // then
        List<MidSeaFcst> savedMidSeaFcstList = midFcstInfoRepository.findByRegIdFromMidSeaFcst("test");
        assertThat(savedMidSeaFcstList.size()).isEqualTo(1);
    }

}
