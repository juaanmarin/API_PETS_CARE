//package com.pets1.app.domain;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//@Entity
//@Table(name = "agenda_cita")
//public class AgendaVo {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "codigo_agen", nullable = false)
//	private Long codigoA;
//
//	@Column(name = "fecha_historiaClin", nullable = false)
//	private String fecha;
//	
//	@Column(name = "hora_agen", nullable = false)
//	private String hora;
//	
//	@OneToOne
//	@JoinColumn(name = "documento_us", referencedColumnName = "documento_usu")
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	private UsuarioVo agendaUs;
//	
//	@ManyToOne
//	@JoinColumn(name = "documento_vt", referencedColumnName = "documento_vt")
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	private VeterinarioVo veterinarioAg;
//	
//	public AgendaVo () {
//		
//	}
//
//	public AgendaVo(Long codigoA, String fecha, String hora,
//			UsuarioVo agendaUs, VeterinarioVo veterinarioAg) {
//		super();
//		this.codigoA = codigoA;
//		this.fecha = fecha;
//		this.hora = hora;
//		this.agendaUs = agendaUs;
//		this.veterinarioAg = veterinarioAg;
//	}
//
//	public Long getCodigoA() {
//		return codigoA;
//	}
//
//	public void setCodigoA(Long codigoA) {
//		this.codigoA = codigoA;
//	}
//
//	public String getFecha() {
//		return fecha;
//	}
//
//	public void setFecha(String fecha) {
//		this.fecha = fecha;
//	}
//
//	public String getHora() {
//		return hora;
//	}
//
//	public void setHora(String hora) {
//		this.hora = hora;
//	}
//
//	public UsuarioVo getAgendaUs() {
//		return agendaUs;
//	}
//
//	public void setAgendaUs(UsuarioVo agendaUs) {
//		this.agendaUs = agendaUs;
//	}
//
//
//	public VeterinarioVo getVeterinarioAg() {
//		return veterinarioAg;
//	}
//
//	public void setVeterinarioAg(VeterinarioVo veterinarioAg) {
//		this.veterinarioAg = veterinarioAg;
//	}	
//}
package com.pets1.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "agenda_cita")
public class AgendaVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_agen", nullable = false, unique = true)
	private Long codigoA;

	@Column(name = "fecha_historiaClin", nullable = false)
	private String fecha;
	
	@Column(name = "hora_agen", nullable = false)
	private String hora;
	
	@ManyToOne
	@JoinColumn(name = "documento_us", referencedColumnName = "documento_usu")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private UsuarioVo agendaUs;
	
	@ManyToOne
	@JoinColumn(name = "documento_vt", referencedColumnName = "documento_vt")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private VeterinarioVo veterinarioAg;
	
	public AgendaVo () {
		
	}

	public AgendaVo(Long codigoA, String fecha, String hora,
			UsuarioVo agendaUs, VeterinarioVo veterinarioAg) {
		super();
		this.codigoA = codigoA;
		this.fecha = fecha;
		this.hora = hora;
		this.agendaUs = agendaUs;
		this.veterinarioAg = veterinarioAg;
	}

	public Long getCodigoA() {
		return codigoA;
	}

	public void setCodigoA(Long codigoA) {
		this.codigoA = codigoA;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public UsuarioVo getAgendaUs() {
		return agendaUs;
	}

	public void setAgendaUs(UsuarioVo agendaUs) {
		this.agendaUs = agendaUs;
	}


	public VeterinarioVo getVeterinarioAg() {
		return veterinarioAg;
	}

	public void setVeterinarioAg(VeterinarioVo veterinarioAg) {
		this.veterinarioAg = veterinarioAg;
	}
	
}