package com.inmobiliaria.model;

import java.io.Serializable;
import java.sql.Time;
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
 * The persistent class for the partidos database table.
 * 
 */
@Entity
@Table(name="partidos")
public class Partido implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date fecha;
	private int golesLocal;
	private int golesVisitante;
	private Time hora;
	private String resultado = "";
	private Propiedad equipoLocal = new Propiedad();
	private Propiedad equipoVisitante = new Propiedad();
	private Cita fase = new Cita();
	private Localidad grupo = new Localidad();
	private Sede sede = new Sede();
	private int orden;
	private boolean premioEnviado = false;
	private boolean permiteCarga = false;

    public Partido() {
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


	@Column(name="Hora", nullable=false)
	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}


	@Column(name="Resultado", length=1)
	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	//bi-directional many-to-one association to Equipo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdEquipoLocal", nullable=false)
	public Propiedad getEquipoLocal() {
		return this.equipoLocal;
	}

	public void setEquipoLocal(Propiedad equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	

	//bi-directional many-to-one association to Equipo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdEquipoVisitante", nullable=false)
	public Propiedad getEquipoVisitante() {
		return this.equipoVisitante;
	}

	public void setEquipoVisitante(Propiedad equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	

	//bi-directional many-to-one association to Fase
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdFase", nullable=false)
	public Cita getFase() {
		return this.fase;
	}

	public void setFase(Cita fase) {
		this.fase = fase;
	}
	

	//bi-directional many-to-one association to Grupo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdGrupo")
	public Localidad getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Localidad grupo) {
		this.grupo = grupo;
	}
	

	//bi-directional many-to-one association to Sede
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdSede", nullable=false)
	public Sede getSede() {
		return this.sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}
	
	@Column(name="Orden")
	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	@Column(name="PremioEnviado")
	public void setPremioEnviado(boolean premioEnviado) {
		this.premioEnviado = premioEnviado;
	}

	public boolean isPremioEnviado() {
		return premioEnviado;
	}
	
	@Column(name="PermiteCarga")
	public void setPermiteCarga(boolean permiteCarga) {
		this.permiteCarga = permiteCarga;
	}

	public boolean isPermiteCarga() {
		return permiteCarga;
	}

}