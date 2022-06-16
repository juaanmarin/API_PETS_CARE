package com.pets1.app.service;

import java.util.List;
import java.util.Optional;
import com.pets1.app.domain.UsuarioVo;

public interface IUsuarioService {
	
	UsuarioVo guardarUsuario(UsuarioVo usuariovo);
	
	List<UsuarioVo> listaDeUsuarios();
	
	Optional<UsuarioVo> buscarUsuarioID(Long documento);
	
	void eliminarUsuario(Long documento);
	
}
