
package com.github.mtzimba.consuming.infra.openweather.client;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.github.mtzimba.consuming.service.WeatherDTO;

@Generated("jsonschema2pojo")
public class OpenWeatherMap {

    private Coord coord;
    private List<Weather> weather = new ArrayList<Weather>();
    private String base;
    private Main main;
    private Integer visibility;
    private Wind wind;
    private Clouds clouds;
    private Integer dt;
    private Sys sys;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    // TODO Colocar num builder
	public WeatherDTO toWeatherDTO() {
		return new WeatherDTO(this.getWeather().iterator().next().getDescription(),
				this.getMain().getTemp() != null ? Double.toString(this.getMain().getTemp()) : null,
				this.getMain().getTempMin() != null ? Double.toString(this.getMain().getTempMin()) : null,
				this.getMain().getTempMax() != null ? Double.toString(this.getMain().getTempMax()) : null,
				this.getMain().getPressure() != null ? Double.toString(this.getMain().getPressure()) : null,
				this.getMain().getHumidity() != null ? Double.toString(this.getMain().getHumidity()) : null);
	}
			

}
