package com.weatherinfo.services;

import com.weatherinfo.dao.CityInfoDao;
import com.weatherinfo.dao.WeatherInfoDao;
import com.weatherinfo.dto.WeatherInfoDto;
import com.weatherinfo.exception.WeatherException;
import com.weatherinfo.mapper.WeatherInfoMapper;
import com.weatherinfo.model.City;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class WeatherInfoService {

    @Autowired
    CityInfoDao cityInfoDao;
    @Autowired
    WeatherInfoDao weatherInfoDao;
    RestTemplate restTemplate = new RestTemplate();

    //  This is the main service to give a response to the user
    public ResponseEntity<?> getWeatherInfoUsingPost(String pincode, String date) throws BadRequestException {

        City city = getCityInfoUsingPincode(pincode);
        ResponseEntity<?> responseEntity = validateDate(date);

        if (responseEntity.getStatusCode().isSameCodeAs(HttpStatus.OK)) {
            try {
                //  This API gives the weather information based on the longitude, latitude and date
                String BUILD_API = "https://archive-api.open-meteo.com/v1/archive?latitude=" + city.getLat() + "&longitude=" + city.getLon() + "&start_date=" + date + "&end_date=" + date + "&daily=weather_code,temperature_2m_mean,sunrise,sunset,rain_sum,wind_speed_10m_max,wind_direction_10m_dominant,temperature_2m_min,temperature_2m_max";
                WeatherInfoDto result = restTemplate.getForObject(BUILD_API, WeatherInfoDto.class);
                weatherInfoDao.save(WeatherInfoMapper.getWeatherInfo(result, pincode, date));
                return new ResponseEntity<>(result, HttpStatus.OK);
            } catch (HttpClientErrorException.NotFound e) {
                return new ResponseEntity<>(new WeatherException("Please enter a valid date: " + date, 400), HttpStatus.BAD_REQUEST);
            }
        }
        return responseEntity;
    }

    //  This service to use to fetch the city details based on the pincode
    public City getCityInfoUsingPincode(String pincode) throws BadRequestException {
        try {
            String url = "http://api.openweathermap.org/geo/1.0/zip?zip=" + pincode + ",IN&appid=f3d14a5c2ee1269c14f28d41333242f3";
            City city = restTemplate.getForObject(url, City.class);
            if (city != null){
                cityInfoDao.save(city);
            }
            return city;
        } catch (HttpClientErrorException.NotFound e) {
            throw new BadRequestException("Please enter a valid pincode: " + pincode);
        }
    }

    //  This method checks the input date
    private ResponseEntity<?> validateDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(date, formatter);
            return new ResponseEntity<>(false, HttpStatus.OK);
        } catch (DateTimeParseException e) {
            return new ResponseEntity<>(new WeatherException("Invalid date format. Format should be YYYY-MM-DD, e.g., 2025-08-15 : " + date, 400), HttpStatus.BAD_REQUEST);
        }
    }

}