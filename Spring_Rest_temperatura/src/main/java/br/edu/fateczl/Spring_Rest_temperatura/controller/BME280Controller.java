package br.edu.fateczl.Spring_Rest_temperatura.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.Spring_Rest_temperatura.model.dto.BME280DTO;
import br.edu.fateczl.Spring_Rest_temperatura.model.entity.BME280;
import br.edu.fateczl.Spring_Rest_temperatura.repository.BME280Repository;


@RestController
@RequestMapping("/api")
public class BME280Controller {

	@Autowired
	private BME280Repository bmeRep;
	
	@GetMapping("/BME280") 
	public List<BME280DTO> list(){
		List<BME280> lista_bme280 = bmeRep.findAll();
		List<BME280DTO> lista_bme280DTO = converteListaBME280(lista_bme280);
		return lista_bme280DTO;
	}
	
	@GetMapping("/BME280/{idlocalDateTime}")
	public ResponseEntity<BME280DTO> busca(@PathVariable(value = "idlocalDateTime") LocalDateTime idlocalDateTime) throws ResourceNotFoundException {
		BME280 bme280 = bmeRep.findById(idlocalDateTime).orElseThrow(
				() -> new ResourceNotFoundException(idlocalDateTime+ " invalido")
				);
		BME280DTO bme280DTO = converteBME280DTO(bme280);
		return ResponseEntity.ok().body(bme280DTO);
	}
	
	@PostMapping("/BME280")
	public ResponseEntity<String> insert(@Valid @RequestBody BME280DTO bme280DTO) {
		BME280 bme280 = converteBME280(bme280DTO);
		bmeRep.save(bme280);
		String saida = "BME cadastrado com sucesso";
		return ResponseEntity.ok().body(saida);
	}
	
	@PutMapping("/BME280")
	public ResponseEntity<String> update(@Valid @RequestBody BME280DTO bme280DTO) {
		BME280 bme280 = converteBME280(bme280DTO);
		bmeRep.save(bme280);
		String saida = "BME atualizado com sucesso";
		return ResponseEntity.ok().body(saida);		
	}

	@DeleteMapping("/BME280")
	public ResponseEntity<String> delete(@Valid @RequestBody BME280DTO bme280DTO) {
		BME280 bme280 = converteBME280(bme280DTO);
		bmeRep.delete(bme280);
		String saida = "BME excluido com sucesso";
		return ResponseEntity.ok().body(saida);		
	}	
	
	private BME280DTO converteBME280DTO(BME280 bme280) {
			BME280DTO bme280DTO = new BME280DTO();
			
			bme280DTO.setLocalDateTime(bme280.getLocalDateTime());
			bme280DTO.setPressure(bme280.getPressure());
			bme280DTO.setHumidity(bme280.getHumidity());
			bme280DTO.setTemperature(bme280.getTemperature());	
			
		return bme280DTO;
	}
	
	private BME280 converteBME280(BME280DTO bme280DTO) {
		BME280 bme280 = new BME280();
		
		bme280.setLocalDateTime(bme280DTO.getLocalDateTime());
		bme280.setPressure(bme280DTO.getPressure());
		bme280.setHumidity(bme280DTO.getHumidity());
		bme280.setTemperature(bme280DTO.getTemperature());	
		
	
		return bme280;
    }		
	
	private List<BME280DTO> converteListaBME280(List<BME280> lista_bme280){
		List<BME280DTO> lista_bme280DTO = new ArrayList<BME280DTO>();
		for(BME280 bme280 : lista_bme280) {
			BME280DTO bme280DTO = new BME280DTO();
			bme280DTO.setLocalDateTime(bme280.getLocalDateTime());
			bme280DTO.setPressure(bme280.getPressure());
			bme280DTO.setHumidity(bme280.getHumidity());
			bme280DTO.setTemperature(bme280.getTemperature());

            lista_bme280DTO.add(bme280DTO);		
		}
		return lista_bme280DTO;
	}
}
