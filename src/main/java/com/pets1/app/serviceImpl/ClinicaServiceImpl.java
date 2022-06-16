package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pets1.app.domain.ClinicaVo;
import com.pets1.app.repository.IClinica;
import com.pets1.app.service.IClinicaService;

@Service
@Transactional
public class ClinicaServiceImpl implements IClinicaService{
	
	@Autowired
	private IClinica clinicaRepository;
	
	@Override
	public ClinicaVo guardarClinica(ClinicaVo clinicaVo) {
		return clinicaRepository.save(clinicaVo);
	}

	@Override
	public List<ClinicaVo> listaDeClinicas() {
		List<ClinicaVo> listaDeClinicas=clinicaRepository.findAll();
		return listaDeClinicas;
	}

	@Override
	public Optional<ClinicaVo> buscarClincaId(Long nit) {
		Optional<ClinicaVo> buscarClinicaId=clinicaRepository.findById(nit);
		return buscarClinicaId;
	}

	@Override
	public void eliminarClinica(Long nit) {
		clinicaRepository.deleteById(nit);
	}
	
}
