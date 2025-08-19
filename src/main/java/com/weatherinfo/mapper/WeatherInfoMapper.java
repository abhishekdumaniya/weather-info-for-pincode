package com.weatherinfo.mapper;

import com.weatherinfo.dto.WeatherInfoDto;
import com.weatherinfo.model.WeatherInfo;

public class WeatherInfoMapper {

    public static WeatherInfo getWeatherInfo(WeatherInfoDto weatherInfoDto, String picode, String date){
        WeatherInfo weatherInfo = new WeatherInfo();
        if (weatherInfoDto == null) {
            return weatherInfo;
        }
        System.out.println("Weather : "+ weatherInfoDto);
        weatherInfo.setWeather_code(weatherInfoDto.getDaily().getWeather_code());
        weatherInfo.setTemperature_2m_mean(weatherInfoDto.getDaily().getTemperature_2m_mean());
        weatherInfo.setSunrise(weatherInfoDto.getDaily().getSunrise());
        weatherInfo.setSunset(weatherInfoDto.getDaily().getSunset());
        weatherInfo.setRain_sum(weatherInfoDto.getDaily().getRain_sum());
        weatherInfo.setWind_speed_10m_max(weatherInfoDto.getDaily().getWind_speed_10m_max());
        weatherInfo.setWind_direction_10m_dominant(weatherInfoDto.getDaily().getWind_direction_10m_dominant());
        weatherInfo.setTemperature_2m_max(weatherInfoDto.getDaily().getTemperature_2m_max());
        weatherInfo.setTemperature_2m_min(weatherInfoDto.getDaily().getTemperature_2m_min());
        weatherInfo.setPincode(picode);
        weatherInfo.setDate(date);
        return weatherInfo;
    }

}
