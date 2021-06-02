package com.abc.pdf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.pdf.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
