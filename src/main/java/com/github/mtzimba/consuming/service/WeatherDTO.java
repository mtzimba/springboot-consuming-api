package com.github.mtzimba.consuming.service;

public class WeatherDTO {
 
	private String condition;
	private String temp;
	private String tempMin;
	private String tempMax;
	private String pressure;
	private String humidity;
	
	public WeatherDTO(String condition, String temp, String tempMin, String tempMax, String pressure, String humidity) {
		this.condition = condition;
		this.temp = temp;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.pressure = pressure;
		this.humidity = humidity;
	}

	public String getCondition() {
		return condition;
	}

	public String getTemp() {
		return temp;
	}

	public String getTempMin() {
		return tempMin;
	}

	public String getTempMax() {
		return tempMax;
	}

	public String getPressure() {
		return pressure;
	}

	public String getHumidity() {
		return humidity;
	}
	
}
