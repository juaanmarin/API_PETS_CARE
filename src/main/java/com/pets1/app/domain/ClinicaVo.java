//package com.pets1.app.domain;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//@Entity
//@Table(name = "clinica_veterinaria")
//public class ClinicaVo {
//	@Id
//	@Column(name = "nit_cv", nullable = false)
//	private Long nit;
//	
//	@Column(name = "nombre_cv", nullable = false)
//	private String nombre;
//	
//	@Column(name = "direccion_cv", nullable = false)
//	private String direccion; 
//	
//	@Column(name = "horario_atencio_cv", nullable = false)
//	private String horario_atencion;
//	
//	@Column(name = "rol_cv", nullable = false)
//	private int rol;
//	
//	
//	
//	@ManyToOne
//	@JoinColumn(name = "documentoVt", referencedColumnName = "documento_vt")
//	@JsonIgnoreProperties(value = {"documento"}, allowSetters=true)
//	private VeterinarioVo veterinarioCod;
//	
//	public ClinicaVo () {
//		
//	}
//
//	public ClinicaVo(Long nit, String nombre, String direccion, String horario_atencion, int rol,
//			VeterinarioVo veterinarioCod) {
//		super();
//		this.nit = nit;
//		this.nombre = nombre;
//		this.direccion = direccion;
//		this.horario_atencion = horario_atencion;
//		this.rol = rol;
//		this.veterinarioCod = veterinarioCod;
//	}
//
//	public Long getNit() {
//		return nit;
//	}
//
//	public void setNit(Long nit) {
//		this.nit = nit;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public String getDireccion() {
//		return direccion;
//	}
//
//	public void setDireccion(String direccion) {
//		this.direccion = direccion;
//	}
//
//	public String getHorario_atencion() {
//		return horario_atencion;
//	}
//
//	public void setHorario_atencion(String horario_atencion) {
//		this.horario_atencion = horario_atencion;
//	}
//
//	public int getRol() {
//		return rol;
//	}
//
//	public void setRol(int rol) {
//		this.rol = rol;
//	}
//
//	public VeterinarioVo getVeterinarioCod() {
//		return veterinarioCod;
//	}
//
//	public void setVeterinarioCod(VeterinarioVo veterinarioCod) {
//		this.veterinarioCod = veterinarioCod;
//	}
//
//}
package com.pets1.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "clinica_veterinaria")
public class ClinicaVo {
	
	@Id
	@Column(name = "nit_cv", nullable = false)
	private Long nit;
	
	@Column(name = "nombre_cv", nullable = false)
	private String nombre;
	
	@Column(name = "direccion_cv", nullable = false)
	private String direccion; 
	
	@Column(name = "horario_atencio_cv", nullable = false)
	private String horario_atencion;
	
	@Column(name = "rol_cv", nullable = false)
	private int rol;
	
	@ManyToOne
	@JoinColumn(name = "documento_vt", referencedColumnName = "documento_vt")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private VeterinarioVo veterinarioCod;
	
	
	
	public ClinicaVo () {
		
	}

	public ClinicaVo(Long nit, String nombre, String direccion, String horario_atencion, int rol,
			VeterinarioVo veterinarioCod) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.direccion = direccion;
		this.horario_atencion = horario_atencion;
		this.rol = rol;
		this.veterinarioCod = veterinarioCod;
	}

	public Long getNit() {
		return nit;
	}

	public void setNit(Long nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario_atencion() {
		return horario_atencion;
	}

	public void setHorario_atencion(String horario_atencion) {
		this.horario_atencion = horario_atencion;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public VeterinarioVo getVeterinarioCod() {
		return veterinarioCod;
	}

	public void setVeterinarioCod(VeterinarioVo veterinarioCod) {
		this.veterinarioCod = veterinarioCod;
	}

}