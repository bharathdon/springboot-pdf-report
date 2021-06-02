package com.abc.pdf.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.pdf.entity.City;
import com.abc.pdf.service.CityService;
import com.abc.pdf.util.GeneratePdfReport;

@RestController
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping(path = "/pdfreport", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> citeisReport() {

		List<City> cities = cityService.findAll();

		ByteArrayInputStream citiesReport = GeneratePdfReport.citiesReport(cities);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", "inline; filename=citiesReport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(citiesReport));

	}
}
