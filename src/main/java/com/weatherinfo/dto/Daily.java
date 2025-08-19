package com.weatherinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Daily {
    private List<Double> weather_code;
    private List<Double> temperature_2m_mean;
    private List<String> sunrise;
    private List<String> sunset;
    private List<Double> rain_sum;
    private List<Double> wind_speed_10m_max;
    private List<Double> wind_direction_10m_dominant;
    private List<Double> temperature_2m_min;
    private List<Double> temperature_2m_max;
}
