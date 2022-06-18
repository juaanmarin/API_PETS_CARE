package com.pets1.app.rest;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pets1.app.domain.HistoriaClinicaVo;
import com.pets1.app.service.IHistoriaClinicaService;

@RestController
@RequestMapping("/api")
public class HistoriaClinicaRest {
	
	@Autowired
	private IHistoriaClinicaService historiaClinicaService;
	
	@GetMapping("/historiaClinica")
	public List<HistoriaClinicaVo> listaDeHistoriasClinicas(){
		return historiaClinicaService.listaDeHistoriasClinicas();
	}
	
	@GetMapping("/historiaClinica/{codigo}")
	public ResponseEntity<Optional<HistoriaClinicaVo>> buscarHistoriaClinicaId(@PathVariable Long codigo){
		Optional<HistoriaClinicaVo> HistoriaClinicaId=historiaClinicaService.buscarHistoriaClinicaId(codigo);
		return ResponseEntity.ok().body(HistoriaClinicaId);
	}
	
	@PostMapping("/historiaClinica")
	public ResponseEntity<?> guardarHistoriaClinica(@RequestBody HistoriaClinicaVo historiaclinicaVo)throws URISyntaxException{
		Map<String, Object> response=new HashMap<>();
		if(historiaclinicaVo.getCodigo() != null) {
			response.put("error", "ya existe una clinica con este nit");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		HistoriaClinicaVo miClinica=historiaClinicaService.guardarHistoriaClinica(historiaclinicaVo);
		response.put("guardado con exito", miClinica);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/historiaClinica/{codigo}")
	public ResponseEntity<?> actualizarHistoriaClinica(@PathVariable Long codigo, @RequestBody HistoriaClinicaVo historiaClinicaVo)throws URISyntaxException{
		Optional<HistoriaClinicaVo> historiaClinica=historiaClinicaService.buscarHistoriaClinicaId(codigo);
		Map<String, Object> response=new HashMap<>();
		if (historiaClinica == null) {
			response.put("error", "ya existe una clinica con este nit");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		HistoriaClinicaVo miHistoriaClinicaVo=new HistoriaClinicaVo();
		miHistoriaClinicaVo.setCodigo(historiaClinicaVo.getCodigo());
		
		miHistoriaClinicaVo=historiaClinicaService.guardarHistoriaClinica(miHistoriaClinicaVo);
		response.put("actualizado con exto", miHistoriaClinicaVo);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/historiaClinica/{codigo}")
	public ResponseEntity<Void> eliminarHistoriaClinica(@PathVariable Long codigo){
		historiaClinicaService.eliminarHistoriaClinica(codigo);
		return ResponseEntity.noContent().build();
	}

}
