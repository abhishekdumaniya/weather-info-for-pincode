package com.weatherinfo.controller;

import com.weatherinfo.services.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherInfoController {

    @Autowired
    WeatherInfoService weatherInfoService;


//    This Controller is used to fetch the cityname, longitude, and latitude api based on the zipcode(pincode)
    @GetMapping("/weather")
    public String getWeather(){
        return weatherInfoService.getOpenWeatherAPI();
    }

}
