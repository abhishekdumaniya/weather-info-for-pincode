package com.weatherinfo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class weatherInfoController {


    @GetMapping("/check")
    public String check(){
        return "Checking the api";
    }

    

}
