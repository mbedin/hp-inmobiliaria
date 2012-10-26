package com.inmobiliaria.model;

import java.io.Serializable;

public class PropiedadAdapter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2066341862394930151L;

	private Propiedad propiedad = new Propiedad();
	private String fechaAlta = "";
	private String descripcion = "";
	private String direccion = "";
	private String dniPropietario = "";

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public PropiedadAdapter() {

	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getDniPropietario() {
		return dniPropietario;
	}

	public void setDniPropietario(String dniPropietario) {
		this.dniPropietario = dniPropietario;
	}

}