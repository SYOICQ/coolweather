package com.example.a13703.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 13703 on 2018/11/2.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;
    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
