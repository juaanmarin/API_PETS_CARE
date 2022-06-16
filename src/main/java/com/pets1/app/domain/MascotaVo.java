package com.pets1.app.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mascotas")
public class MascotaVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_mc", nullable = false)
	private Long codigo;
	
	@Column(name = "nombre_mc", nullable = false)
	private String nombre;
	
	@Column(name = "raza_mc", nullable = false)
	private String raza;
	
	@Column(name = "color_mc", nullable = false)
	private String color;
	
	@Column(name = "peso_mc", nullable = false)
	private double peso;
	
	@Column(name = "discapacidad_mc", nullable = false)
	private String discapacidad;
	
	@Column(name = "tipoAnimal_mc", nullable = false)
	private String tipoAnimal;
	
	@ManyToOne
	@JoinColumn( name = "documentoUs", referencedColumnName = "documento_usu")
	@JsonIgnoreProperties(value = {"documentoUs"}, allowSetters=true)
	private UsuarioVo duenioMasCo;
	
	@OneToMany(mappedBy = "mascotaCod", cascade = {CascadeType.PERSIST,CascadeType.ALL})
	@JsonIgnoreProperties(value = {"mascotaCod"}, allowSetters=true)
	private List<HistoriaClinicaVo> listaHistoriasCl;
	
	public MascotaVo () {
		
	}

	public MascotaVo(Long codigo, String nombre, String raza, String color, double peso, String discapacidad,
			String tipoAnimal, List<HistoriaClinicaVo> listaHistoriasCl,
			UsuarioVo duenioMasCo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.raza = raza;
		this.color = color;
		this.peso = peso;
		this.discapacidad = discapacidad;
		this.tipoAnimal = tipoAnimal;
		this.listaHistoriasCl = listaHistoriasCl;
		this.duenioMasCo = duenioMasCo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getDiscapacidad() {
		return discapacidad;
	}

	public void setDiscapacidad(String discapacidad) {
		this.discapacidad = discapacidad;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public List<HistoriaClinicaVo> getListaHistoriasCl() {
		return listaHistoriasCl;
	}

	public void setListaHistoriasCl(List<HistoriaClinicaVo> listaHistoriasCl) {
		this.listaHistoriasCl = listaHistoriasCl;
	}

	public UsuarioVo getDuenioMasCo() {
		return duenioMasCo;
	}

	public void setDuenioMasCo(UsuarioVo duenioMasCo) {
		this.duenioMasCo = duenioMasCo;
	}
}
