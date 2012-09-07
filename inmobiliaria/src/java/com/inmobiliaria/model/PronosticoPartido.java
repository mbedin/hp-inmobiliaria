package com.inmobiliaria.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pronosticospartidos database table.
 * 
 */
@Entity
@Table(name="pronosticospartidos")
public class PronosticoPartido implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int golesLocal = 0;
	private int golesVisitante = 0;
	private int puntos = 0;
	private String resultado = "";
	private boolean tienePremio = false;
	private boolean estaCompleto = false;
	private Tarjeta tarjeta = new Tarjeta();
	private Partido partido = new Partido();

    public PronosticoPartido() {
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


	@Column(name="GolesLocal")
	public int getGolesLocal() {
		return this.golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}


	@Column(name="GolesVisitante")
	public int getGolesVisitante() {
		return this.golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}


	@Column(name="Puntos")
	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}


	@Column(name="Resultado", length=1)
	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	@Column(name="TienePremio")
	public boolean getTienePremio() {
		return this.tienePremio;
	}

	public void setTienePremio(boolean tienePremio) {
		this.tienePremio = tienePremio;
	}
	
	@Column(name="EstaCompleto")
	public boolean EstaCompleto() {
		return this.estaCompleto;
	}

	public void setEstaCompleto(boolean estaCompleto) {
		this.estaCompleto = estaCompleto;
	}



	//bi-directional many-to-one association to Tarjeta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdTarjetaProde", nullable=false)
	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	

	//bi-directional many-to-one association to Partido
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdPartido", nullable=false)
	public Partido getPartido() {
		return this.partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	@Transient
	public boolean getEsLocal() {
		return (!Util.isStringNullOrEmpty(this.getResultado()) && this.getResultado().equals("L"));
	}
	
	@Transient
	public boolean getEsEmpate() {
		return (!Util.isStringNullOrEmpty(this.getResultado()) && this.getResultado().equals("E"));	}
	
	@Transient
	public boolean getEsVisitante() {
		return (!Util.isStringNullOrEmpty(this.getResultado()) && this.getResultado().equals("V"));
	}


}