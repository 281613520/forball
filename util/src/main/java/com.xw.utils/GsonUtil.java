package com.xw.utils;

import com.google.gson.Gson;


/**
 * Created by Ankh on 2017/6/4.
 */
public class GsonUtil {

    private GsonUtil() {
    }

    private Gson gson = null;

    public synchronized Gson getInstance(){
        if (gson == null){
            gson = new Gson();
            return gson;
        }else {
            return gson;
        }
    }

    private String  string= "";
}
