package com.weatherinfo.controller;

import com.weatherinfo.services.weatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class weatherInfoController {

    @Autowired
    weatherInfoService weatherInfoService;


//    This Controller is used to fetch the openweatherapi api based on the zipcode(pincode)
    @GetMapping("/weather")
    public String getWeather(){
        return weatherInfoService.getOpenWeatherAPI();
    }

}
