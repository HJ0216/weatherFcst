package com.example.demo.service.mid;

import org.json.JSONObject;

public interface MidFcstInfoService {

    public void saveMidFcst(JSONObject item);

    public void saveMidLandFcst(JSONObject item);

    public void saveMidTa(JSONObject item);

    public void saveMidSeaFcst(JSONObject item);
}
