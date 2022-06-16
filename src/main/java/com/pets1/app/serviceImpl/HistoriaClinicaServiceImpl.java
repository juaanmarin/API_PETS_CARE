package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pets1.app.domain.HistoriaClinicaVo;
import com.pets1.app.repository.IHistoriaClinica;
import com.pets1.app.service.IHistoriaClinicaService;

@Service
@Transactional
public class HistoriaClinicaServiceImpl implements IHistoriaClinicaService{
	
	@Autowired
	private IHistoriaClinica historiaClinicaRepository;
	
	@Override
	public HistoriaClinicaVo guardarHistoriaClinica(HistoriaClinicaVo historiaClinica) {
		return historiaClinicaRepository.save(historiaClinica);
	}

	@Override
	public List<HistoriaClinicaVo> listaDeHistoriasClinicas() {
		List<HistoriaClinicaVo> listaDeHistoriasClinicas=historiaClinicaRepository.findAll();
		return listaDeHistoriasClinicas;
	}

	@Override
	public Optional<HistoriaClinicaVo> buscarHistoriaClinicaId(Long codigo) {
		Optional<HistoriaClinicaVo> buscarHistoriaClinicaPorId=historiaClinicaRepository.findById(codigo);
		return buscarHistoriaClinicaPorId;
	}

	@Override
	public void eliminarHistoriaClinica(Long codigo) {
		historiaClinicaRepository.deleteById(codigo);
	}
	
}
