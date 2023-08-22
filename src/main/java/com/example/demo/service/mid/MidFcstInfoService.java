package com.example.demo.service.mid;

import org.json.JSONObject;
import org.springframework.web.util.UriComponents;

public interface MidFcstInfoService {

    public void midFcstData(String type, String modifiedUri);

    public void saveMidFcst(JSONObject item);

    public void saveMidLandFcst(JSONObject item);

    public void saveMidTa(JSONObject item);

    public void saveMidSeaFcst(JSONObject item);

}
