package com.weatherinfo.dao;

import com.weatherinfo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityInfoDao extends JpaRepository<City, Long> {
}
