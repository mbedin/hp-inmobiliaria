package com.inmobiliaria.model;

import java.io.Serializable;
import java.util.Date;

public class PropietarioAdapter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2066341862394930151L;

	private Propiedad propiedad = new Propiedad();
	private String EMail = "";
	private String dni = "";
	private String nombreYApellido = "";
	private String telefono;
	private Date fechaNacimiento = new Date();

	public PropietarioAdapter() {

	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public String getEMail() {
		return EMail;
	}

	public void setEMail(String eMail) {
		EMail = eMail;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}