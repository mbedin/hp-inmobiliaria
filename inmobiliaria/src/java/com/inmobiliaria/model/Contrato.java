package com.inmobiliaria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the contratos database table.
 * 
 */
@Entity
@Table(name = "contratos")
public class Contrato implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final int ID_ESTADO_VIGENTE = 0;
	public static final int ID_ESTADO_CANCELADO = 1;
	public static final String ESTADO_VIGENTE = "vigente";
	public static final String ESTADO_CANCELADO = "cancelado";
	

	private int id;
	private String observaciones = "";
	private Date fechaEmision = new Date();
	private Date fechaInicio = new Date();
	private Date fechaFin = new Date();
	private Propiedad propiedad = new Propiedad();
	private Persona inquilino = new Persona();
	private List<Pago> pagos = new ArrayList<Pago>();
	private int estado;
	private String descEstado = "";

	public Contrato() {
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

	@Column(name = "observaciones", nullable = false, length = 300)
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaEmision", nullable = false)
	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaInicio", nullable = false)
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaFin", nullable = false)
	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	// bi-directional many-to-one association to Propiedad
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdPropiedad")
	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	// bi-directional many-to-one association to Persona
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdPersona")
	public Persona getInquilino() {
		return inquilino;
	}

	public void setInquilino(Persona inquilino) {
		this.inquilino = inquilino;
	}

	// bi-directional many-to-one association to Persona
	@OneToMany(mappedBy = "contrato")
	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	@Column(name = "estado", nullable = false)
	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getEstado() {
		return estado;
	}

	@Transient
	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}

	public String getDescEstado() {
		return descEstado;
	}

	// @Transient
	// public boolean isEditable() {
	// if (fechaPublicacion == null) return true;
	// return (Util.compareOnlyDates(this.fechaPublicacion, new Date()) > 0);
	// }

}