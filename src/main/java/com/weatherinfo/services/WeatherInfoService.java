package com.weatherinfo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherinfo.dao.WeatherInfoDao;
import com.weatherinfo.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherInfoService {

    @Autowired
    WeatherInfoDao weatherInfoDao;

    RestTemplate restTemplate = new RestTemplate();

//    This service is used to find the only cityname, longitude, and latitude based on the pincode
    public String getOpenWeatherAPI() {
        String url = "http://api.openweathermap.org/geo/1.0/zip?zip=4014,IN&appid=f3d14a5c2ee1269c14f28d41333242f3";
        City city = restTemplate.getForObject(url, City.class);
        System.out.println(city.toString());
//        This is used to save the information in database
        try {
            weatherInfoDao.save(city);
        } catch (Exception e){
            System.out.println(e);
        }
        return restTemplate.getForObject(url, String.class);
    }


//    This service is used to fetch the weather data based on the pincode and date
    public ResponseEntity<JsonNode> getWeatherInfoUsingPost(String pincode, String date) throws JsonProcessingException {
        //This API is only used to find the city, longitude, and latitude based on the pincode
        String url = "http://api.openweathermap.org/geo/1.0/zip?zip="+pincode+",IN&appid=f3d14a5c2ee1269c14f28d41333242f3";
        City city = restTemplate.getForObject(url, City.class);

//        This API give the weather information based on the longitude, latitude and date
        String BUILD_API = "https://archive-api.open-meteo.com/v1/archive?latitude="+city.getLat()+"&longitude="+city.getLon()+"&start_date="+date+"&end_date="+date+"&daily=weather_code,temperature_2m_mean,sunrise,sunset,rain_sum,wind_speed_10m_max,wind_direction_10m_dominant,temperature_2m_min,temperature_2m_max";
        String result = restTemplate.getForObject(BUILD_API, String.class);

        // Extract data using ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(result);
        JsonNode daily = root.get("daily");
        
        return new ResponseEntity<>(daily, HttpStatus.OK);
    }

}
