package br.edu.fateczl.Spring_Rest_temperatura.model.dto;

import java.time.LocalDateTime;



public class BME280DTO {

	private LocalDateTime localDateTime;
	
	private float pressure;
	
	private float humidity;
	
	private float temperature;

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "BME280DTO [localDateTime=" + localDateTime + ", pressure=" + pressure + ", humidity=" + humidity
				+ ", temperature=" + temperature + "]";
	}
	
	
}
