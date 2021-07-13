package com.github.mtzimba.consuming.infra.openweather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.mtzimba.consuming.infra.openweather.client.OpenWeatherMap;
import com.github.mtzimba.consuming.service.WeatherDTO;
import com.github.mtzimba.consuming.service.WeatherForecastService;

@Service
public class OpenWeatherServiceImpl implements WeatherForecastService {
	
	@Value("${openweather.api.url}")
    private String urlApi;
	
	@Value("${openweather.api.key}")
    private String keyApi;
	
	private final RestTemplate restTemplate;
	
	public OpenWeatherServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	@Override
	@Cacheable(value = "getWeatherByCity")
	public WeatherDTO getWeatherByCity(String city) {
		StringBuilder url = new StringBuilder(urlApi)
				.append(city)
				.append("&appid=").append(keyApi)
				.append("&units=metric")
				.append("&lang=pt_br");
		OpenWeatherMap openWeather = restTemplate.getForObject(url.toString(), OpenWeatherMap.class);
		return openWeather.toWeatherDTO();
	}

}
