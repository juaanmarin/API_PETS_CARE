package com.pets1.app.rest;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.tomcat.util.http.ResponseUtil;
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

import com.pets1.app.domain.AgendaVo;
import com.pets1.app.service.IAgendaService;

@RestController
@RequestMapping("/api")
public class AgendaRest {
	
	private static final String ENTITY_NAME="AgendaVo";
	
	@Autowired
	private IAgendaService agendaService;
	
	@GetMapping("/agenda")
	public List<AgendaVo> listaAgenda(){
		return agendaService.listaDeAgendas();
	}
	
	@GetMapping("/agenda/{codigo}")
	public ResponseEntity<Optional<AgendaVo>> buscarAgendaID(@PathVariable Long codigo){
		Optional<AgendaVo> agendaId=agendaService.buscarAgendaId(codigo);	
		return ResponseEntity.ok().body(agendaId);
	}
	
	@PostMapping("/agenda")
	public ResponseEntity<?> guardarAgenda(@RequestBody AgendaVo agendaVo)throws URISyntaxException{	
		Map<String,Object>response = new HashMap<>();
		if(agendaVo.getCodigoA() != null) {
			response.put("error", "ya existe esta agenda con este id");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		AgendaVo MiAgenda=agendaService.guardarAgenda(agendaVo);
		response.put("guardado con exito", MiAgenda);
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@PutMapping("/agenda/{codigo}")
	public ResponseEntity<?> actualizarAgenda(@PathVariable Long codigo ,@RequestBody AgendaVo agendaVo)throws URISyntaxException{
		Optional<AgendaVo> agenda= agendaService.buscarAgendaId(codigo);
		Map<String,Object> response = new HashMap<>();
		
		if(agenda == null) {
			response.put("error", "la agenda no existe en la bd");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		AgendaVo miAgendaVo=new AgendaVo();
		miAgendaVo.setCodigoA(agendaVo.getCodigoA());
		miAgendaVo.setFecha(agendaVo.getFecha());
		miAgendaVo.setHora(agendaVo.getHora());
		
		miAgendaVo=agendaService.guardarAgenda(miAgendaVo);
		response.put("actualizado con exito", miAgendaVo);
		
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/agenda/{codigo}")
	public ResponseEntity<Void> eliminarAgenda(@PathVariable Long codigo){
		agendaService.eliminarAgenda(codigo);
		return ResponseEntity.noContent().build();
	}
	
}
