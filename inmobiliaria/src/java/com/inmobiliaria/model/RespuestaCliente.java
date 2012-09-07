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
 * The persistent class for the respuestasclientes database table.
 * 
 */
@Entity
@Table(name="respuestasclientes")
public class RespuestaCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date fecha = new Date();
	private int puntos;
	private Persona cliente = new Persona();
	private Contrato pregunta = new Contrato();
	private Respuesta respuesta = new Respuesta();

    public RespuestaCliente() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="Fecha", nullable=false)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Column(name="Puntos")
	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdCliente", nullable=false)
	public Persona getCliente() {
		return this.cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	

	//bi-directional many-to-one association to Pregunta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdPregunta", nullable=false)
	public Contrato getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Contrato pregunta) {
		this.pregunta = pregunta;
	}

	//bi-directional many-to-one association to Respuesta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdRespuesta")
	public Respuesta getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

}