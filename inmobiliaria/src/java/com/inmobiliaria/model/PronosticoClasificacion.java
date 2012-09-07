package com.inmobiliaria.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pronosticosclasificacion database table.
 * 
 */
@Entity
@Table(name="pronosticosclasificacion")
public class PronosticoClasificacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private boolean tienePremio;
	private Propiedad equipoPrimero = new Propiedad();
	private Propiedad equipoSegundo = new Propiedad();
	private Localidad grupo  = new Localidad();
	private Tarjeta tarjeta = new Tarjeta();

    public PronosticoClasificacion() {
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


	@Column(name="TienePremio")
	public boolean getTienePremio() {
		return this.tienePremio;
	}

	public void setTienePremio(boolean tienePremio) {
		this.tienePremio = tienePremio;
	}


	//bi-directional many-to-one association to Equipo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdEquipoSegundo", nullable=true)
	public Propiedad getEquipoSegundo() {
		return this.equipoSegundo;
	}

	public void setEquipoSegundo(Propiedad equipoSegundo) {
		this.equipoSegundo = equipoSegundo;
	}
	

	//bi-directional many-to-one association to Equipo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdEquipoPrimero", nullable=true)
	public Propiedad getEquipoPrimero() {
		return this.equipoPrimero;
	}

	public void setEquipoPrimero(Propiedad equipoPrimero) {
		this.equipoPrimero = equipoPrimero;
	}
	

	//bi-directional many-to-one association to Grupo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdGrupo", nullable=false)
	public Localidad getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Localidad grupo) {
		this.grupo = grupo;
	}
	

	//bi-directional many-to-one association to Tarjetasprode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdTarjetaProde", nullable=false)
	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
}