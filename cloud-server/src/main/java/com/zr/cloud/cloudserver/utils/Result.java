package com.zr.cloud.cloudserver.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by zhuran on 2018/8/7 0007
 */
public class Result {
    public static String make(Integer errNo, Object data,String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errNo", errNo);
        jsonObject.put("data", data);
        jsonObject.put("errMsg", msg);
        return jsonObject.toJSONString();
    }
}
