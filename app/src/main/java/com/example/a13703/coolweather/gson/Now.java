package com.example.a13703.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 13703 on 2018/11/2.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;
    public class More{
        @SerializedName("txt")
        public String info;
    }
}
