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

import com.pets1.app.domain.MascotaVo;
import com.pets1.app.service.IMascotaService;

@RestController
@RequestMapping("/api")
public class MascotaRest {
	
	@Autowired
	private IMascotaService mascotaService;
	
	@GetMapping("/mascota")
	public List<MascotaVo> listaDeMascotas(){
		return mascotaService.listaDeMascotas();
	}
	
	@GetMapping("/mascota/{codigo}")
	public ResponseEntity<Optional<MascotaVo>> buscarMascotaId(@PathVariable Long codigo){
		Optional<MascotaVo> mascotaId=mascotaService.buscarMascotaId(codigo);	
		return ResponseEntity.ok().body(mascotaId);
	}
	
	@PostMapping("/mascota")
	public ResponseEntity<?> guardarMascota(@RequestBody MascotaVo mascotaVo)throws URISyntaxException{	
		Map<String,Object>response = new HashMap<>();
		if(mascotaVo.getCodigo() != null) {
			response.put("error", "ya existe una mascota con este id");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		MascotaVo miMascota=mascotaService.guardarMascotas(mascotaVo);
		response.put("guardado con exito", miMascota);
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@PutMapping("/mascota/{codigo}")
	public ResponseEntity<?> actualizarMascota(@PathVariable Long codigo ,@RequestBody MascotaVo mascotaVo)throws URISyntaxException{
		Optional<MascotaVo> mascota= mascotaService.buscarMascotaId(codigo);
		System.out.println("*****************************************");
		Map<String,Object> response = new HashMap<>();
		
		if(mascota == null) {
			response.put("error", "la mascota no existe en la bd");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		MascotaVo miMacotaVo=new MascotaVo();
		miMacotaVo.setCodigo(mascotaVo.getCodigo());
		miMacotaVo.setNombre(mascotaVo.getNombre());
		miMacotaVo.setRaza(mascotaVo.getRaza());
		miMacotaVo.setColor(mascotaVo.getColor());
		miMacotaVo.setPeso(mascotaVo.getPeso());
		miMacotaVo.setDiscapacidad(mascotaVo.getDiscapacidad());
		miMacotaVo.setTipoAnimal(mascotaVo.getTipoAnimal());
		miMacotaVo.setDuenioMasCo(mascotaVo.getDuenioMasCo());
		
		miMacotaVo=mascotaService.guardarMascotas(miMacotaVo);
		response.put("actualizado con exito", miMacotaVo);
		
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/mascota/{codigo}")
	public ResponseEntity<Void> eliminarMascota(@PathVariable Long codigo){
		mascotaService.eliminarMascota(codigo);
		return ResponseEntity.noContent().build();
	}
	
}
