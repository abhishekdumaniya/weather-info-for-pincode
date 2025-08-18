package com.weatherinfo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.weatherinfo.dto.WeatherRequest;
import com.weatherinfo.services.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    Take the two input from the user - 1) pincode 2) date using PostMapping
    @PostMapping("/weather/post")
    public ResponseEntity<JsonNode> getInfo(@RequestBody WeatherRequest request) throws JsonProcessingException {
        return weatherInfoService.getWeatherInfoUsingPost(request.getPincode(), request.getDate());
    }


}
