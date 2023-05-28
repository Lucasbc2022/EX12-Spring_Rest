package br.edu.fateczl.Spring_Rest_temperatura.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import br.edu.fateczl.Spring_Rest_temperatura.model.entity.BME280;

public interface BME280Repository extends JpaRepository<BME280, LocalDateTime>{

	@Procedure(name = "BME280.sp_inserir_temperatura")
	String sp_inserir_temperatura(@Param("localDateTime") LocalDateTime localDateTime, 
			                      @Param("pressure") float pressure,
			                      @Param("humidity") float humidity,
			                      @Param("temperature") float temperature);
	                           
}
