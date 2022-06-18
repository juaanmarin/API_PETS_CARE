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

import com.pets1.app.domain.VeterinarioVo;
import com.pets1.app.service.IVeterinarioService;

@RestController
@RequestMapping("/api")
public class VeterinarioRest {
	
	@Autowired
	private IVeterinarioService veterinarioService;
	
	@GetMapping("/veterinario")
	public List<VeterinarioVo> listaDeVeterinarios(){
		return veterinarioService.listaDeVeterinarios();
	}
	
	@GetMapping("/veterinario/{codigo}")
	public ResponseEntity<Optional<VeterinarioVo>> buscarVeterinarioId(@PathVariable Long documento){
		Optional<VeterinarioVo> veterinarioId=veterinarioService.buscarVeterinarioId(documento);	
		return ResponseEntity.ok().body(veterinarioId);
	}
	
	@PostMapping("/veterinario")
	public ResponseEntity<?> guardarVeterinario(@RequestBody VeterinarioVo veterinarioVo)throws URISyntaxException{	
		Map<String,Object>response = new HashMap<>();
		if(veterinarioVo.getDocumento() != null) {
			response.put("error", "ya existe esta agenda con este id");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		VeterinarioVo miVeterinario=veterinarioService.guardarVeterinario(veterinarioVo);
		response.put("guardado con exito", miVeterinario);
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@PutMapping("/veterinario/{codigo}")
	public ResponseEntity<?> actualizarVeterinario(@PathVariable Long documento ,@RequestBody VeterinarioVo veterinarioVo)throws URISyntaxException{
		Optional<VeterinarioVo> veterinario= veterinarioService.buscarVeterinarioId(documento);
		Map<String,Object> response = new HashMap<>();
		
		if(veterinario == null) {
			response.put("error", "la agenda no existe en la bd");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		VeterinarioVo miVeterinarioVo=new VeterinarioVo();
		miVeterinarioVo.setDocumento(veterinarioVo.getDocumento());
		miVeterinarioVo.setNombre(veterinarioVo.getNombre());
		miVeterinarioVo.setApellidos(veterinarioVo.getApellidos());
		miVeterinarioVo.setTelefono(veterinarioVo.getTelefono());
		miVeterinarioVo.setCorreo(veterinarioVo.getCorreo());
		miVeterinarioVo.setEspecialidad(veterinarioVo.getEspecialidad());
		miVeterinarioVo.setPassword(veterinarioVo.getPassword());
		
		miVeterinarioVo=veterinarioService.guardarVeterinario(miVeterinarioVo);
		response.put("actualizado con exito", miVeterinarioVo);
		
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/veterinario/{codigo}")
	public ResponseEntity<Void> eliminarVeterinario(@PathVariable Long documento){
		veterinarioService.eliminarVeterinario(documento);
		return ResponseEntity.noContent().build();
	}
	
	
}
