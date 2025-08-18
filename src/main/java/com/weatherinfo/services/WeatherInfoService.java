package com.weatherinfo.services;

import com.weatherinfo.dao.WeatherInfoDao;
import com.weatherinfo.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherInfoService {

    @Autowired
    WeatherInfoDao weatherInfoDao;

    RestTemplate restTemplate = new RestTemplate();

    public String getOpenWeatherAPI() {
        String url = "http://api.openweathermap.org/geo/1.0/zip?zip=411014,IN&appid=f3d14a5c2ee1269c14f28d41333242f3";
        City city = restTemplate.getForObject(url, City.class);
        System.out.println(city.toString());

//        This is used to save the information in database
        weatherInfoDao.save(city);

        return restTemplate.getForObject(url, String.class);
    }

}
