package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.MascotaVo;
import com.pets1.app.repository.IMascota;
import com.pets1.app.service.IMascotaService;

@Service
@Transactional
public class MascotaServiceImpl implements IMascotaService{
	
	@Autowired
	private IMascota mascotaRepository;
	
	@Override
	public MascotaVo guardarMascotas(MascotaVo mascotaVo) {
		return mascotaRepository.save(mascotaVo);
	}

	@Override
	public List<MascotaVo> listaDeMascotas() {
		List<MascotaVo> listaDeMascotas=mascotaRepository.findAll();
		return listaDeMascotas;
	}

	@Override
	public Optional<MascotaVo> buscarMascotaId(Long codigo) {
		Optional<MascotaVo> buscarMascotaPorId=mascotaRepository.findById(codigo);
		return buscarMascotaPorId;
	}

	@Override
	public void eliminarMascota(Long codigo) {
		mascotaRepository.deleteById(codigo);
	}
	
}
