package com.github.mtzimba.consuming.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientResponseException;

import com.github.mtzimba.consuming.service.WeatherDTO;
import com.github.mtzimba.consuming.service.WeatherForecastService;

/**
 * @author Matheus Cardoso
 */
@RestController
@RequestMapping("/api")
public class ConsumingController {

	final static Logger LOG = LoggerFactory.getLogger(ConsumingController.class);
	
	private final WeatherForecastService weatherForecastService;
	
	@Autowired
	public ConsumingController(WeatherForecastService weatherForecastService) {
		this.weatherForecastService = weatherForecastService;
	}
	
	@GetMapping("/about")	
	public ResponseEntity<?> about() {
		return ResponseEntity.ok("ok");
	}
	
	@GetMapping("/weather")
	public ResponseEntity<?> byCity(@RequestParam(value = "city") String city) {
	
		try {
			WeatherDTO weather = weatherForecastService.getWeatherByCity(city);
			return ResponseEntity.ok(weather);
		} catch (RestClientResponseException e) {
			return ResponseEntity.status(e.getRawStatusCode()).build();
		}
	}
}