package com.weatherinfo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class weatherInfoService {

    RestTemplate restTemplate = new RestTemplate();

    public String getOpenWeatherAPI() {
        String url = "http://api.openweathermap.org/geo/1.0/zip?zip=411014,IN&appid=f3d14a5c2ee1269c14f28d41333242f3";
        return restTemplate.getForObject(url, String.class);
    }

}
