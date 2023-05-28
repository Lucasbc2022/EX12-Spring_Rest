package br.edu.fateczl.Spring_Rest_temperatura.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BME280")
public class BME280 {

	@Id
	@Column(name = "localDateTime", nullable = false)
	private LocalDateTime localDateTime;
	
	@Column(name = "pressure", nullable = true)
	private float pressure;
	
	@Column(name = "humidity", nullable = true)
	private float humidity;
	
	@Column(name = "temperature", nullable = true)
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
		return "BME280 [localDateTime=" + localDateTime + ", pressure=" + pressure + ", humidity=" + humidity
				+ ", temperature=" + temperature + "]";
	}
	
	
	
}
