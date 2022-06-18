package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.VeterinarioVo;
import com.pets1.app.repository.IVeterinario;
import com.pets1.app.service.IVeterinarioService;

@Service
@Transactional
public class VeterinarioServiceImpl implements IVeterinarioService{
	
	@Autowired
	private IVeterinario veterinarioRepository;
	
	@Override
	public VeterinarioVo guardarVeterinario(VeterinarioVo veterinariVo) {
		return veterinarioRepository.save(veterinariVo);
	}

	@Override
	public List<VeterinarioVo> listaDeVeterinarios() {
		List<VeterinarioVo> listaDeVeterinarios=veterinarioRepository.findAll();
		return listaDeVeterinarios;
	}

	@Override
	public Optional<VeterinarioVo> buscarVeterinarioId(Long documento) {
		Optional<VeterinarioVo> buscarVeterinarioPorId=veterinarioRepository.findById(documento);
		return buscarVeterinarioPorId;
	}

	@Override
	public void eliminarVeterinario(Long documento) {
		veterinarioRepository.deleteById(documento);
	}

}
