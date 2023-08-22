package com.example.demo.service.mid;

import com.example.demo.dao.mid.MidFcstInfoRepository;
import com.example.demo.entity.mid.MidFcst;
import com.example.demo.entity.mid.MidLandFcst;
import com.example.demo.entity.mid.MidSeaFcst;
import com.example.demo.entity.mid.MidTa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MidFcstInfoServiceImpl implements MidFcstInfoService {

    @Autowired
    private MidFcstInfoRepository midFcstInfoRepository;

    @Override
    public void midFcstData(String type, String modifiedUri) {
        WebClient webClient = WebClient.builder()
                .baseUrl(modifiedUri)
                .build();

        Mono<String> result = webClient.get()
                .retrieve()
                .bodyToMono(String.class);

        String response = result.block();

        JSONObject obj = XML.toJSONObject(response);

        JSONObject items = obj.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items");

        JSONObject item = items.getJSONObject("item");

        switch (type) {
            case "getMidFcst":
                saveMidFcst(item);
                break;
            case "getMidLandFcst":
                saveMidLandFcst(item);
                break;
            case "getMidTa":
                saveMidTa(item);
                break;
            case "getMidSeaFcst":
                saveMidSeaFcst(item);
                break;
        }

    }

    @Override
    public void saveMidFcst(JSONObject item) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MidFcst midFcst = objectMapper.readValue(item.toString(), MidFcst.class);
            midFcstInfoRepository.save(midFcst);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveMidLandFcst(JSONObject item) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MidLandFcst midLandFcst = objectMapper.readValue(item.toString(), MidLandFcst.class);
            midFcstInfoRepository.save(midLandFcst);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveMidTa(JSONObject item) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MidTa midTa = objectMapper.readValue(item.toString(), MidTa.class);
            midFcstInfoRepository.save(midTa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveMidSeaFcst(JSONObject item) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            MidSeaFcst midSeaFcst = objectMapper.readValue(item.toString(), MidSeaFcst.class);
            midFcstInfoRepository.save(midSeaFcst);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
