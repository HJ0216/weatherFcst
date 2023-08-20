package com.example.demo.service.srt;

import com.example.demo.dao.srt.SrtFcstInfoDAO;
import com.example.demo.dao.srt.SrtFcstInfoRepository;
import com.example.demo.dto.srt.RqstParams;
import com.example.demo.entity.srt.UltraSrtFcst;
import com.example.demo.entity.srt.UltraSrtNcst;
import com.example.demo.entity.srt.VilageFcst;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class SrtFcstInfoServiceImpl implements SrtFcstInfoService {

    @Autowired
    private final SrtFcstInfoDAO srtFcstInfoDAO;

    @Autowired
    private final SrtFcstInfoRepository srtFcstInfoRepository;


    // UltraSrtNcst
    @Override
    public void getUltraSrtNcst(RqstParams rqstParams) {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst")
                .build();

        String url = "?serviceKey=" + rqstParams.getServiceKey() +
                "&numOfRows=" + rqstParams.getNumOfRows() +
                "&pageNo=" + rqstParams.getPageNo() +
                "&dataType=" + rqstParams.getDataType() +
                "&base_date=" + rqstParams.getBase_date() +
                "&base_time=" + rqstParams.getBase_time() +
                "&nx=" + rqstParams.getNx() +
                "&ny=" + rqstParams.getNy();

        Mono<String> result = webClient.get().uri(url)
                .retrieve()
                .bodyToMono(String.class);

        String response = result.block();

        saveUltraSrtNcst(response);
    }

    @Override
    public void saveUltraSrtNcst(String response) {
        JSONObject obj = XML.toJSONObject(response);

        JSONObject items = obj.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items");

        System.out.println(obj);

        JSONArray itemList = items.optJSONArray("item");
        if (itemList != null) {
            for (int i = 0; i < itemList.length(); i++) {
                JSONObject item = itemList.getJSONObject(i);

                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    UltraSrtNcst ultraSrtNcst = objectMapper.readValue(item.toString(), UltraSrtNcst.class);
                    srtFcstInfoRepository.save(ultraSrtNcst);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }


    // UltraSrtFcst
    @Override
    public void getUltraSrtFcst(RqstParams rqstParams) {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst")
                .build();

        String url = "?serviceKey=" + rqstParams.getServiceKey() +
                "&numOfRows=" + rqstParams.getNumOfRows() +
                "&pageNo=" + rqstParams.getPageNo() +
                "&dataType=" + rqstParams.getDataType() +
                "&base_date=" + rqstParams.getBase_date() +
                "&base_time=" + rqstParams.getBase_time() +
                "&nx=" + rqstParams.getNx() +
                "&ny=" + rqstParams.getNy();

        Mono<String> result = webClient.get().uri(url)
                .retrieve()
                .bodyToMono(String.class);

        String response = result.block();

        saveUltraSrtFcst(response);
    }

    @Override
    public void saveUltraSrtFcst(String response) {
        JSONObject obj = XML.toJSONObject(response);

        JSONObject items = obj.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items");

        System.out.println(obj);

        JSONArray itemList = items.optJSONArray("item");
        if (itemList != null) {
            for (int i = 0; i < itemList.length(); i++) {
                JSONObject item = itemList.getJSONObject(i);

                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    UltraSrtFcst ultraSrtFcst = objectMapper.readValue(item.toString(), UltraSrtFcst.class);
                    srtFcstInfoRepository.save(ultraSrtFcst);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }


    // VilageFcst
    @Override
    public void getVilageFcst(RqstParams rqstParams) {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst")
                .build();

        String url = "?serviceKey=" + rqstParams.getServiceKey() +
                "&numOfRows=" + rqstParams.getNumOfRows() +
                "&pageNo=" + rqstParams.getPageNo() +
                "&dataType=" + rqstParams.getDataType() +
                "&base_date=" + rqstParams.getBase_date() +
                "&base_time=" + rqstParams.getBase_time() +
                "&nx=" + rqstParams.getNx() +
                "&ny=" + rqstParams.getNy();

        Mono<String> result = webClient.get().uri(url)
                .retrieve()
                .bodyToMono(String.class);

        String response = result.block();

        saveVilageFcst(response);
    }

    @Override
    public void saveVilageFcst(String response) {
        JSONObject obj = XML.toJSONObject(response);

        JSONObject items = obj.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items");

        System.out.println(obj);

        JSONArray itemList = items.optJSONArray("item");
        if (itemList != null) {
            for (int i = 0; i < itemList.length(); i++) {
                JSONObject item = itemList.getJSONObject(i);

                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    VilageFcst vilageFcst = objectMapper.readValue(item.toString(), VilageFcst.class);
                    srtFcstInfoRepository.save(vilageFcst);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }



        /* DAO - JPQL

    @Override
    public void saveUltraSrtNcst(String response) {
        JSONObject obj = XML.toJSONObject(response);

        JSONObject items = obj.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items");

        System.out.println(obj);

        JSONArray itemList = items.optJSONArray("item");
        if (itemList != null) {
            for (int i = 0; i < itemList.length(); i++) {
                JSONObject item = itemList.getJSONObject(i);

                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    UltraSrtNcst ultraSrtNcst = objectMapper.readValue(item.toString(), UltraSrtNcst.class);
                    srtFcstInfoDAO.save(ultraSrtNcst);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }


    // UltraSrtFcst
    @Override
    public void saveUltraSrtFcst(String response) {
        JSONObject obj = XML.toJSONObject(response);

        JSONObject items = obj.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items");

        System.out.println(obj);

        JSONArray itemList = items.optJSONArray("item");
        if (itemList != null) {
            for (int i = 0; i < itemList.length(); i++) {
                JSONObject item = itemList.getJSONObject(i);

                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    UltraSrtFcst ultraSrtFcst = objectMapper.readValue(item.toString(), UltraSrtFcst.class);
                    srtFcstInfoDAO.save(ultraSrtFcst);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }


    // VilageFcst
    @Override
    public void saveVilageFcst(String response) {
        JSONObject obj = XML.toJSONObject(response);

        JSONObject items = obj.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items");

        System.out.println(obj);

        JSONArray itemList = items.optJSONArray("item");
        if (itemList != null) {
            for (int i = 0; i < itemList.length(); i++) {
                JSONObject item = itemList.getJSONObject(i);

                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    VilageFcst vilageFcst = objectMapper.readValue(item.toString(), VilageFcst.class);
                    srtFcstInfoDAO.save(vilageFcst);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

     */

}
