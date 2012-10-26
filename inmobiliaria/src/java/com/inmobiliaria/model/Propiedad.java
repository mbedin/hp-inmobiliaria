package com.inmobiliaria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the propiedades database table.
 * 
 */
@Entity
@Table(name = "propiedades")
public class Propiedad implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String descripcion = "";
	private String direccion = "";
	private Date fechaAlta = new Date();
	private boolean activa = false;
	private boolean alquilada = false;
	private Persona propietario = new Persona();
	private Localidad localidad = new Localidad();
	private String estado = "";
	private int cantHabitaciones;
	private int cantAmbientes;

	public Propiedad() {
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

	@Column(name = "descripcion", nullable = false, length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "direccion", nullable = false, length = 200)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "activa", nullable = false)
	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	@Column(name = "alquilada", nullable = false)
	public boolean isAlquilada() {
		return alquilada;
	}

	public void setAlquilada(boolean alquilada) {
		this.alquilada = alquilada;
	}

	// bi-directional many-to-one association to Propietario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdPropietario")
	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaAlta", nullable = false)
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Column(name = "estado", nullable = false)
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	// bi-directional many-to-one association to Localidad
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdLocalidad")
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	@Column(name = "cantHabitaciones", nullable = false)
	public int getCantHabitaciones() {
		return cantHabitaciones;
	}

	public void setCantHabitaciones(int cantHabitaciones) {
		this.cantHabitaciones = cantHabitaciones;
	}

	@Column(name = "cantAmbientes", nullable = false)
	public int getCantAmbientes() {
		return cantAmbientes;
	}

	public void setCantAmbientes(int cantAmbientes) {
		this.cantAmbientes = cantAmbientes;
	}

}