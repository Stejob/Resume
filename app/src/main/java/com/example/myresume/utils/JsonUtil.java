package com.example.myresume.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    public static String requestVersionControl (String urlApproval, String appVersion){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("url_approval", urlApproval);
            jsonObject.put("app_version", appVersion);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString().trim();
    }
}
