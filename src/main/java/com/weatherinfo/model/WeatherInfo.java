package com.weatherinfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;


import java.util.List;

@Entity
@Data
@Getter
public class WeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    private String date;
    private Double weather_code;
    private Double temperature_2m_mean;
    private String sunrise;
    private String sunset;
    private Double rain_sum;
    private Double wind_speed_10m_max;
    private Double wind_direction_10m_dominant;
    private Double temperature_2m_min;
    private Double temperature_2m_max;

    public void setWeather_code(List<Double> weather_code) {
        this.weather_code = weather_code.get(0);
    }

    public void setTemperature_2m_mean(List<Double> temperature_2m_mean) {
        this.temperature_2m_mean = temperature_2m_mean.get(0);
    }

    public void setSunrise(List<String> sunrise) {
        this.sunrise = sunrise.get(0);
    }

    public void setSunset(List<String> sunset) {
        this.sunset = sunset.get(0);
    }

    public void setRain_sum(List<Double> rain_sum) {
        this.rain_sum = rain_sum.get(0);
    }

    public void setWind_speed_10m_max(List<Double> wind_speed_10m_max) {
        this.wind_speed_10m_max = wind_speed_10m_max.get(0);
    }

    public void setWind_direction_10m_dominant(List<Double> wind_direction_10m_dominant) {
        this.wind_direction_10m_dominant = wind_direction_10m_dominant.get(0);
    }

    public void setTemperature_2m_min(List<Double> temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min.get(0);
    }

    public void setTemperature_2m_max(List<Double> temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max.get(0);
    }
}