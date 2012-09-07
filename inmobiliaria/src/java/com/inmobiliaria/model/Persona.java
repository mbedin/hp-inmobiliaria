package com.inmobiliaria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
	private String razonSocial = "";
	private String nombreYApellido = "";
	private String password = "";
	private String usuario = "";
	private String telefono;
	private boolean activo;
	private int tipoPersona;
	private String descTipoPersona = "";

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

	@Column(name = "RazonSocial", nullable = false, length = 200)
	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Column(name = "NombreYApellido", nullable = false, length = 200)
	public String getNombreYApellido() {
		return this.nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	@Column(name = "Password", nullable = false, length = 200)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Transient
	public String getDescTipoPersona() {
		return descTipoPersona;
	}

	public void setDescTipoPersona(String descTipoPersona) {
		this.descTipoPersona = descTipoPersona;
	}

}