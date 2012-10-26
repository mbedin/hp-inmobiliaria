package com.inmobiliaria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final int ID_TIPO_INQUILINO = 0;
	public static final int ID_TIPO_PROPIETARIO = 1;
	public static final String TIPO_INQUILINO = "Inquilino";
	public static final String TIPO_PROPIETARIO = "Propietario";

	private int id;
	private String EMail = "";
	private String dni = "";
	private String nombreYApellido = "";
	private String usuario = "";
	private String telefono;
	private boolean activo;
	private int tipoPersona;
	private String descTipoPersona = "";
	private Date fechaNacimiento = new Date();

	public Persona() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false, length = 200)
	public String getEMail() {
		return this.EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}

	@Column(name = "Dni", nullable = false, length = 200)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name = "NombreYApellido", nullable = false, length = 200)
	public String getNombreYApellido() {
		return this.nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	@Column(name = "Usuario", nullable = false, length = 20)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "Activo", nullable = false)
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Column(name = "telefono", nullable = false)
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono() {
		return telefono;
	}

	@Column(name = "tipoPersona", nullable = false)
	public void setTipoPersona(int tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public int getTipoPersona() {
		return tipoPersona;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaNacimiento", nullable = false)
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Transient
	public String getDescTipoPersona() {
		return descTipoPersona;
	}

	public void setDescTipoPersona(String descTipoPersona) {
		this.descTipoPersona = descTipoPersona;
	}

}