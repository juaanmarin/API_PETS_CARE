package com.pets1.app.service;

import java.util.List;
import java.util.Optional;

import com.pets1.app.domain.HistoriaClinicaVo;

public interface IHistoriaClinicaService {

	HistoriaClinicaVo guardarHistoriaClinica(HistoriaClinicaVo historiaClinica);
	
	List<HistoriaClinicaVo> listaDeHistoriasClinicas();
	
	Optional<HistoriaClinicaVo> buscarHistoriaClinicaId(Long codigo);
	
	void eliminarHistoriaClinica(Long codigo);
	
}
