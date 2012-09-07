package com.inmobiliaria.model;

import java.io.Serializable;


public class PartidoAdapter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2066341862394930151L;
	
	private Partido partido = new Partido();
	private String golesLocal = "";
	private String golesVisitante = "";
	private String fechaPartido = "";
	private String horaPartido = "" ;
	
	public PartidoAdapter() {

    }

	
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public Partido getPartido() {
		return partido;
	}

	public void setGolesLocal(String golesLocal) {
		this.golesLocal = golesLocal;
	}
	public String getGolesLocal() {
		return golesLocal;
	}

	public void setGolesVisitante(String golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	public String getGolesVisitante() {
		return golesVisitante;
	}

	public void setFechaPartido(String fechaPartido) {
		this.fechaPartido = fechaPartido;
	}
	public String getFechaPartido() {
		return fechaPartido;
	}

	public void setHoraPartido(String horaPartido) {
		this.horaPartido = horaPartido;
	}
	public String getHoraPartido() {
		return horaPartido;
	}

}