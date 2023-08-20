package com.example.demo.controller;

import com.example.demo.service.mid.MidFcstInfoService;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "weather")
public class ApiController {

    // 중기 예보

    @Autowired
    private MidFcstInfoService midFcstInfoService;


        @GetMapping(value = "/getMidFcst")
        public void getMidFcst(
                @RequestParam String serviceKey,
                @RequestParam String numOfRows,
                @RequestParam String pageNo,
                @RequestParam String dataType,
                @RequestParam String stnId,
                @RequestParam String tmFc
        ) {

            // Default Settings
            WebClient webClient = WebClient.builder()
                    .baseUrl("https://apis.data.go.kr/1360000/MidFcstInfoService/getMidFcst")
                    .build();

            // API 요청
            String url = "?serviceKey=" + serviceKey +
                    "&numOfRows=" + numOfRows +
                    "&pageNo=" + pageNo +
                    "&dataType=" + dataType +
                    "&stnId=" + stnId +
                    "&tmFc=" + tmFc;

            // 비동기적 결과 반환 (처리 속도 빠름)
            Mono<String> result = webClient.get().uri(url)
                    .retrieve() // 생성한 요청을 서버로 보내고, 응답을 받아옴
                    .bodyToMono(String.class); // 응답 데이터를 비동기적 처리

            String response = result.block();

            JSONObject obj = XML.toJSONObject(response.toString());
            JSONObject items = obj.getJSONObject("response")
                    .getJSONObject("body")
                    .getJSONObject("items");
    //        System.out.println(obj);
            // {"response":{"header":{"resultCode":"00","resultMsg":"NORMAL_SERVICE"}, ...

            JSONObject item = items.getJSONObject("item");
            System.out.println(item);
            // {"wfSv":"○ (강수) 22일(화) 수도권과 강원영서, 충청권에, 23일(수)~24일(목) 전국에 비가 오겠습니다. ...

            midFcstInfoService.saveMidFcst(item);

        }

        @GetMapping(value = "/getMidLandFcst")
        public void getMidLandFcst(
                @RequestParam String serviceKey,
                @RequestParam String numOfRows,
                @RequestParam String pageNo,
                @RequestParam String dataType,
                @RequestParam String regId,
                @RequestParam String tmFc
        ) {

            WebClient webClient = WebClient.builder()
                    .baseUrl("https://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst")
                    .build();

            String url = "?serviceKey=" + serviceKey +
                    "&numOfRows=" + numOfRows +
                    "&pageNo=" + pageNo +
                    "&dataType=" + dataType +
                    "&regId=" + regId +
                    "&tmFc=" + tmFc;

            Mono<String> result = webClient.get().uri(url)
                    .retrieve()
                    .bodyToMono(String.class);

            String response = result.block();

            JSONObject obj = XML.toJSONObject(response.toString());
            JSONObject items = obj.getJSONObject("response")
                    .getJSONObject("body")
                    .getJSONObject("items");
    //        System.out.println(obj);

            JSONObject item = items.getJSONObject("item");
            System.out.println(item);

            midFcstInfoService.saveMidLandFcst(item);

        }

    @GetMapping(value = "/getMidTa")
    public void getMidTa(
            @RequestParam String serviceKey,
            @RequestParam String numOfRows,
            @RequestParam String pageNo,
            @RequestParam String dataType,
            @RequestParam String regId,
            @RequestParam String tmFc
    ) {

        WebClient webClient = WebClient.builder()
                .baseUrl("https://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa")
                .build();

        String url = "?serviceKey=" + serviceKey +
                "&numOfRows=" + numOfRows +
                "&pageNo=" + pageNo +
                "&dataType=" + dataType +
                "&regId=" + regId +
                "&tmFc=" + tmFc;

        Mono<String> result = webClient.get().uri(url)
                .retrieve()
                .bodyToMono(String.class);

        String response = result.block();

        JSONObject obj = XML.toJSONObject(response.toString());
        JSONObject items = obj.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items");
        System.out.println(obj);

        JSONObject item = items.getJSONObject("item");
        System.out.println(item);

        midFcstInfoService.saveMidTa(item);

    }


    @GetMapping(value = "/getMidSeaFcst")
    public void getMidSeaFcst(
            @RequestParam String serviceKey,
            @RequestParam String numOfRows,
            @RequestParam String pageNo,
            @RequestParam String dataType,
            @RequestParam String regId,
            @RequestParam String tmFc
    ) {

        WebClient webClient = WebClient.builder()
                .baseUrl("https://apis.data.go.kr/1360000/MidFcstInfoService/getMidSeaFcst")
                .build();

        String url = "?serviceKey=" + serviceKey +
                "&numOfRows=" + numOfRows +
                "&pageNo=" + pageNo +
                "&dataType=" + dataType +
                "&regId=" + regId +
                "&tmFc=" + tmFc;

        Mono<String> result = webClient.get().uri(url)
                .retrieve()
                .bodyToMono(String.class);

        String response = result.block();

        JSONObject obj = XML.toJSONObject(response.toString());
        JSONObject items = obj.getJSONObject("response")
                .getJSONObject("body")
                .getJSONObject("items");
        System.out.println(obj);

        JSONObject item = items.getJSONObject("item");
        System.out.println(item);

        midFcstInfoService.saveMidSeaFcst(item);

    }

}
