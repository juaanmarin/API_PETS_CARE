package com.pets1.app.service;

import java.util.List;
import java.util.Optional;
import com.pets1.app.domain.AgendaVo;

public interface IAgendaService {
	
	AgendaVo guardarAgenda(AgendaVo agendaVo);
	
	List<AgendaVo> listaDeAgendas();
	
	Optional<AgendaVo> buscarAgendaId(Long codigo);
	
	void eliminarAgenda(Long codigo);

}
