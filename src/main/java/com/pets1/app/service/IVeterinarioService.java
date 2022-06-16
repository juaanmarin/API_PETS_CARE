package com.pets1.app.service;

import java.util.List;
import java.util.Optional;
import com.pets1.app.domain.VeterinarioVo;

public interface IVeterinarioService {
	
	VeterinarioVo guardarVeterinario(VeterinarioVo veterinariVo);
	
	List<VeterinarioVo> listaDeVeterinarios();
	
	Optional<VeterinarioVo> buscarVeterinarioId(Long documento);
	
	void eliminarVeterinario(Long documento);
	
}
