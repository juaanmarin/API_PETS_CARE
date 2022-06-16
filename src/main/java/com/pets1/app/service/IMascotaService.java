package com.pets1.app.service;

import java.util.List;
import java.util.Optional;
import com.pets1.app.domain.MascotaVo;

public interface IMascotaService {
	
	MascotaVo guardarMascotas(MascotaVo mascotaVo);
	
	List<MascotaVo> listaDeMascotas();
	
	Optional<MascotaVo> buscarMascotaId(Long codigo);
	
	void eliminarMascota(Long codigo);
	
}
