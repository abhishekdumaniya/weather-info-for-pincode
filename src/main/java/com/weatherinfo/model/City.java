package com.weatherinfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zip;
    private String name;
    private Long lat;
    private Long lon;
    private String country;
}
