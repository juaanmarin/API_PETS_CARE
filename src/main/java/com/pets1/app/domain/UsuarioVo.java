package com.pets1.app.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuarios")
public class UsuarioVo {
	@Id
	@Column(name = "documento_usu", nullable = false)
	private Long documentoUs;

	@Column(name = "nombre_usu", nullable = false)
	private String nombreUs;

	@Column(name = "apellido_usu", nullable = false)
	private String apellidoUs;

	@Column(name = "telefono_usu", nullable = false)
	private String telefonoUs;
	
	@Column(name = "correo_usu", nullable = false)
	private String correoUs;

	@Column(name = "password_usu", nullable = false)
	private String passwordUs;

	@Column(name = "rol_usu", nullable = false)
	private int rolUs;
	
	@OneToMany(mappedBy = "duenioMasCo", cascade = {CascadeType.PERSIST, CascadeType.ALL} )
	@JsonIgnoreProperties(value = {"duenioMasCo"}, allowSetters=true)
	private List<MascotaVo> listaMascotas;
	
//	@OneToOne(mappedBy = "agendaUs", cascade = {CascadeType.PERSIST, CascadeType.ALL})
//	@JsonIgnoreProperties(value = {"agendaUs"}, allowSetters=true)
//	private List<AgendaVo> listaAgendas;
	
	public UsuarioVo() {
		
	}

	public UsuarioVo(Long documentoUs, String nombreUs, String apellidoUs, String telefonoUs, String correoUs,
			String passwordUs, int rolUs, List<MascotaVo> listaMascotas) {
		super();
		this.documentoUs = documentoUs;
		this.nombreUs = nombreUs;
		this.apellidoUs = apellidoUs;
		this.telefonoUs = telefonoUs;
		this.correoUs = correoUs;
		this.passwordUs = passwordUs;
		this.rolUs = rolUs;
		this.listaMascotas = listaMascotas;
		
	}



	public Long getDocumentoUs() {
		return documentoUs;
	}

	public void setDocumentoUs(Long documentoUs) {
		this.documentoUs = documentoUs;
	}

	public String getNombreUs() {
		return nombreUs;
	}

	public void setNombreUs(String nombreUs) {
		this.nombreUs = nombreUs;
	}

	public String getApellidoUs() {
		return apellidoUs;
	}

	public void setApellidoUs(String apellidoUs) {
		this.apellidoUs = apellidoUs;
	}

	public String getTelefonoUs() {
		return telefonoUs;
	}

	public void setTelefonoUs(String telefonoUs) {
		this.telefonoUs = telefonoUs;
	}

	public String getCorreoUs() {
		return correoUs;
	}

	public void setCorreoUs(String correoUs) {
		this.correoUs = correoUs;
	}

	public String getPasswordUs() {
		return passwordUs;
	}

	public void setPasswordUs(String passwordUs) {
		this.passwordUs = passwordUs;
	}

	public int getRolUs() {
		return rolUs;
	}

	public void setRolUs(int rolUs) {
		this.rolUs = rolUs;
	}

	public List<MascotaVo> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<MascotaVo> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}


}
