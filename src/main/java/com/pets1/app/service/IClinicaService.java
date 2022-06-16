package com.pets1.app.service;

import java.util.List;
import java.util.Optional;

import com.pets1.app.domain.ClinicaVo;

public interface IClinicaService {
	
	ClinicaVo guardarClinica(ClinicaVo clinicaVo);
	
	List<ClinicaVo> listaDeClinicas();
	
	Optional<ClinicaVo> buscarClincaId(Long nit);
	
	void eliminarClinica(Long nit);
	
}
