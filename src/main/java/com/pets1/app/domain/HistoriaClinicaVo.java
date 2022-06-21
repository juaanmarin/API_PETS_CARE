package com.pets1.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinicaVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_hc", nullable = false, unique = true)
	private Long codigo;
	
	@Column(name = "fecha_hc", nullable = false)
	private String fecha;
	
	@Column(name = "motivoConsulta_hc", nullable = false, length = 200)
	private String motivoConsulta;
		
	@OneToOne
	@JoinColumn(name = "codmascota", referencedColumnName = "codigo_mc")
	@JsonIgnoreProperties(value = {"codigo"}, allowSetters=true)
	private MascotaVo mascotaCod;
	
	public HistoriaClinicaVo () {
		
	}

	public HistoriaClinicaVo(Long codigo, String fecha, String motivoConsulta,
			MascotaVo mascotaCod) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.motivoConsulta = motivoConsulta;
		this.mascotaCod = mascotaCod;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	
	public MascotaVo getMascotaCod() {
		return mascotaCod;
	}

	public void setMascotaCod(MascotaVo mascotaCod) {
		this.mascotaCod = mascotaCod;
	}

}
