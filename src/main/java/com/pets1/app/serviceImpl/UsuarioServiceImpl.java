package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.repository.IUsuario;
import com.pets1.app.service.IUsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuario usuarioRepository;
	
	@Override
	public UsuarioVo guardarUsuario(UsuarioVo usuarioVo) {
		return usuarioRepository.save(usuarioVo);
	}

	@Override
	public List<UsuarioVo> listaDeUsuarios() {
		List<UsuarioVo> listaDeUsuarios=usuarioRepository.findAll();
		return listaDeUsuarios;
	}

	@Override
	public Optional<UsuarioVo> buscarUsuarioID(Long documento) {
		Optional<UsuarioVo> buscarUsuarioPorId=usuarioRepository.findById(documento);
		return buscarUsuarioPorId;
	}

	@Override
	public void eliminarUsuario(Long documento) {
		usuarioRepository.deleteById(documento);		
	}

}
