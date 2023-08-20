package com.example.demo.service.mid;

import com.example.demo.dao.mid.MidFcstDAO;
import com.example.demo.dao.mid.MidLandFcstDAO;
import com.example.demo.dao.mid.MidSeaFcstDAO;
import com.example.demo.dao.mid.MidTaDAO;
import com.example.demo.entity.mid.MidFcst;
import com.example.demo.entity.mid.MidLandFcst;
import com.example.demo.entity.mid.MidSeaFcst;
import com.example.demo.entity.mid.MidTa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MidFcstInfoServiceImpl implements MidFcstInfoService {

    @Autowired
    private MidFcstDAO midFcstDAO;

    @Autowired
    private MidLandFcstDAO midFcstLandDAO;

    @Autowired
    private MidTaDAO midTaDAO;

    @Autowired
    private MidSeaFcstDAO midSeaFcstDAO;

    @Override
    public void saveMidFcst(JSONObject item) {
        MidFcst midFcst = new MidFcst(item.getString("wfSv"));
        midFcstDAO.save(midFcst);
    }

    @Override
    public void saveMidLandFcst(JSONObject item) {

        /*
        String regId = item.optString("regId");

        String rnSt3Am = item.optString("rnSt3Am");
        String rnSt3Pm = item.optString("rnSt3Am");
        String rnSt4Am = item.optString("rnSt4Am");
        String rnSt4Pm = item.optString("rnSt4Pm");
        String rnSt5Am = item.optString("rnSt5Am");
        String rnSt5Pm = item.optString("rnSt5Pm");
        String rnSt6Am = item.optString("rnSt6Am");
        String rnSt6Pm = item.optString("rnSt6Pm");
        String rnSt7Am = item.optString("rnSt7Am");
        String rnSt7Pm = item.optString("rnSt7Pm");
        String rnSt8 = item.optString("rnSt8");
        String rnSt9 = item.optString("rnSt9");
        String rnSt10 = item.optString("rnSt10");

        String wf3Am = item.optString("wf3Am");
        String wf3Pm = item.optString("wf3Pm");
        String wf4Am = item.optString("wf4Am");
        String wf4Pm = item.optString("wf4Pm");
        String wf5Am = item.optString("wf5Am");
        String wf5Pm = item.optString("wf5Pm");
        String wf6Am = item.optString("wf6Am");
        String wf6Pm = item.optString("wf6Pm");
        String wf7Am = item.optString("wf7Am");
        String wf7Pm = item.optString("wf7Pm");
        String wf8 = item.optString("wf8");
        String wf9 = item.optString("wf9");
        String wf10 = item.optString("wf10");

        // Constructor
        MidLandFcst midLandFcst = new MidLandFcst(regId,
                rnSt3Am, rnSt3Pm, rnSt4Am, rnSt4Pm, rnSt5Am, rnSt5Pm, rnSt6Am, rnSt6Pm, rnSt7Am, rnSt7Pm, rnSt8, rnSt9, rnSt10,
                wf3Am, wf3Pm, wf4Am, wf4Pm, wf5Am, wf5Pm, wf6Am, wf6Pm, wf7Am, wf7Pm, wf8, wf9, wf10);
        midFcstLandDAO.save(midLandFcst);



        // Builder
        MidLandFcst midLandFcst = MidLandFcst.builder()
                .regId(regId)
                .rnSt3Am(rnSt3Am).rnSt3Pm(rnSt3Pm)
                .rnSt4Am(rnSt4Am).rnSt4Pm(rnSt4Pm)
                .rnSt5Am(rnSt5Am).rnSt5Pm(rnSt5Pm)
                .rnSt6Am(rnSt6Am).rnSt6Pm(rnSt6Pm)
                .rnSt7Am(rnSt7Am).rnSt7Pm(rnSt7Pm)
                .rnSt8(rnSt8).rnSt9(rnSt9).rnSt10(rnSt10)
                .wf3Am(wf3Am).wf3Pm(wf3Pm)
                .wf4Am(wf4Am).wf4Pm(wf4Pm)
                .wf5Am(wf5Am).wf5Pm(wf5Pm)
                .wf6Am(wf6Am).wf6Pm(wf6Pm)
                .wf7Am(wf7Am).wf7Pm(wf7Pm)
                .wf8(wf8).wf9(wf9).wf10(wf10)
                .build();

        midFcstLandDAO.save(midLandFcst);

         */


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MidLandFcst midLandFcst = objectMapper.readValue(item.toString(), MidLandFcst.class);
            midFcstLandDAO.save(midLandFcst);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveMidTa(JSONObject item) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MidTa midTa = objectMapper.readValue(item.toString(), MidTa.class);
            midTaDAO.save(midTa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveMidSeaFcst(JSONObject item) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MidSeaFcst midSeaFcst = objectMapper.readValue(item.toString(), MidSeaFcst.class);
            midSeaFcstDAO.save(midSeaFcst);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
