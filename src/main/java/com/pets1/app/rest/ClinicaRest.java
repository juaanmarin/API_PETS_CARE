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

import com.pets1.app.domain.ClinicaVo;
import com.pets1.app.service.IClinicaService;

@RestController
@RequestMapping("/api")
public class ClinicaRest {
	
	@Autowired
	private IClinicaService clinicaService;
	
	@GetMapping("/clinica")
	public List<ClinicaVo> listaDeClicas(){
		return clinicaService.listaDeClinicas();
	}
	
	@GetMapping("/clinica/{nit}")
	public ResponseEntity<Optional<ClinicaVo>> buscarClinicaId(@PathVariable Long nit){
		Optional<ClinicaVo> clinicaId=clinicaService.buscarClincaId(nit);
		return ResponseEntity.ok().body(clinicaId);
	}
	
	@PostMapping("/clinica")
	public ResponseEntity<?> guardarClinica(@RequestBody ClinicaVo clinicaVo)throws URISyntaxException{
		Map<String, Object> response=new HashMap<>();
		if(clinicaVo.getNit() != null) {
			response.put("error", "ya existe una clinica con este nit");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		ClinicaVo miClinica=clinicaService.guardarClinica(clinicaVo);
		response.put("guardado con exito", miClinica);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/clinica/{nit}")
	public ResponseEntity<?> actualizarClinica(@PathVariable Long nit, @RequestBody ClinicaVo clinicaVo)throws URISyntaxException{
		Optional<ClinicaVo> clinica=clinicaService.buscarClincaId(nit);
		Map<String, Object> response=new HashMap<>();
		if (clinica == null) {
			response.put("error", "ya existe una clinica con este nit");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		ClinicaVo miClinicaVo=new ClinicaVo();
		miClinicaVo.setNit(clinicaVo.getNit());
		miClinicaVo.setNombre(clinicaVo.getNombre());
		miClinicaVo.setDireccion(clinicaVo.getDireccion());
		miClinicaVo.setHorario_atencion(clinicaVo.getHorario_atencion());
		miClinicaVo.setRol(miClinicaVo.getRol());
		
		miClinicaVo=clinicaService.guardarClinica(miClinicaVo);
		response.put("actualizado con exto", miClinicaVo);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/clinica/{nit}")
	public ResponseEntity<Void> eliminarClinica(@PathVariable Long nit){
		clinicaService.eliminarClinica(nit);
		return ResponseEntity.noContent().build();
	}
	
}
