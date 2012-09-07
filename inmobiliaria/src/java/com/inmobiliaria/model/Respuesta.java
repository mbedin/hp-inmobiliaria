package com.inmobiliaria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the respuestas database table.
 * 
 */
@Entity
@Table(name="respuestas")
public class Respuesta implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String descripcion;
	private boolean esCorrecta;
	private Contrato pregunta;

    public Respuesta() {
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


	@Column(name="Descripcion", nullable=false, length=200)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(name="EsCorrecta", nullable=false)
	public boolean getEsCorrecta() {
		return this.esCorrecta;
	}

	public void setEsCorrecta(boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
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
	
}