package com.example.a13703.coolweather.util;

import android.text.TextUtils;

import com.example.a13703.coolweather.db.City;
import com.example.a13703.coolweather.db.Country;
import com.example.a13703.coolweather.db.Province;
import com.example.a13703.coolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 13703 on 2018/11/1.
 */

public class Utility {
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProviences = new JSONArray(response);
                for(int i=0;i<allProviences.length();i++){
                    JSONObject provinceObject = allProviences.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }
            catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities = new JSONArray(response);
                for(int i=0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceID(provinceId);
                    city.setCityCode(cityObject.getInt("id"));
                    city.save();
                }
                return true;
            }
            catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleContryResponse(String response,int CityId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounties = new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject contryObject = allCounties.getJSONObject(i);
                    Country country = new Country();
                    country.setContryName(contryObject.getString("name"));
                    country.setWeatherId(contryObject.getString("weather_id"));
                    country.setCityId(CityId);
                    country.save();
                }
                return true;
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
