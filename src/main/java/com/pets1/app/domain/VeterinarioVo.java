package com.pets1.app.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "veterinario")
public class VeterinarioVo {
	@Id
	@Column(name = "documento_vt", nullable=false)
	private Long documento ;

	@Column(name = "nombre_vt", nullable=false) 
	private String nombre ;

	@Column(name = "apellido_vt", nullable = false) 
	private String apellidos ;

	@Column(name = "telefono_vt", nullable = false) 
	private String telefono ;

	@Column(name = "correo_vt", nullable = false) 
	private String correo ;

	@Column(name = "especialidad_vt", nullable = false) 
	private String especialidad ;

	@Column(name = "password_vt", nullable = false)
	private String password ;
	
	@OneToMany(mappedBy = "veterinarioCod", cascade = {CascadeType.PERSIST, CascadeType.ALL})
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
	private List<ClinicaVo> listaClinica;
	
	@OneToMany(mappedBy = "veterinarioAg", cascade = {CascadeType.PERSIST, CascadeType.ALL})
	@JsonIgnoreProperties(value = {"veterinarioAg"}, allowSetters=true)
	private List<AgendaVo> listaAgenda;
	
		
	public VeterinarioVo () {
		
	}

	public VeterinarioVo(long documento, String nombre, String apellidos, String telefono, String correo,
			String especialidad, String password, List<ClinicaVo> listaClinica, List<AgendaVo> listaAgenda) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.especialidad = especialidad;
		this.password = password;
		this.listaClinica = listaClinica;
		this.listaAgenda = listaAgenda;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ClinicaVo> getListaClinica() {
		return listaClinica;
	}

	public void setListaClinica(List<ClinicaVo> listaClinica) {
		this.listaClinica = listaClinica;
	}

	public List<AgendaVo> getListaAgenda() {
		return listaAgenda;
	}

	public void setListaAgenda(List<AgendaVo> listaAgenda) {
		this.listaAgenda = listaAgenda;
	}
	

}
