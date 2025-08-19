package com.weatherinfo.controller;

import com.weatherinfo.dto.WeatherRequest;
import com.weatherinfo.exception.WeatherException;
import com.weatherinfo.services.WeatherInfoService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WeatherInfoController {
    @Autowired
    WeatherInfoService weatherInfoService;

    /**
     * Retrieves weather information for a given request.
     *
     * @param request the request object containing pincode and date information
     * @return a ResponseEntity containing the weather information DTO
     * @throws BadRequestException if the provided request parameters are invalid
     */
    @PostMapping("/weather")
    public ResponseEntity<?> getInfo(@RequestBody WeatherRequest request) throws BadRequestException {
        if ( request == null || request.getPincode() == null || request.getDate() == null || request.getPincode().isEmpty()
        || request.getDate().isEmpty()) {
            return new ResponseEntity<>(new WeatherException("Invalid Request", 400), HttpStatus.BAD_REQUEST);
        }
        return weatherInfoService.getWeatherInfoUsingPost(request.getPincode(), request.getDate());
    }
}