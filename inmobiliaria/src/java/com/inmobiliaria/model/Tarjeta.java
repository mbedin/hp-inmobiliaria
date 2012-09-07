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
import javax.persistence.Transient;

/**
 * The persistent class for the tarjetas database table.
 * 
 */
@Entity
@Table(name="tarjetasprode")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String RESULTADO_LOCAL = "L";
	public static final String RESULTADO_EMPATE = "E";
	public static final String RESULTADO_VISITANTE = "V";
	
	public static final int TIPO_TARJETA_CLIENTE = 0;
	public static final int TIPO_TARJETA_PRODUCTOR = 1;
	public static final int TIPO_TARJETA_OCTAVOS = 2;
	public static final int TIPO_TARJETA_CUARTOS = 3;
	public static final int TIPO_TARJETA_SEMI = 4;
	public static final int TIPO_TARJETA_FINAL = 5;
	
	
	private int id;
	private boolean activa = true;
	private boolean estaCompleta = false;
	private Date fechaModificacion = new Date();
	private List<PronosticoClasificacion> pronosticosClasificacion = new ArrayList<PronosticoClasificacion>();
	private List<PronosticoPartido> pronosticosPartidos = new ArrayList<PronosticoPartido>();
	private Persona cliente;
	
	private String goleador = "";
	private String mejorJugador = "";
	private int puntosCampeon;
	private int puntosGoleador;
	private int puntosMejorJugador;
	private int puntosSubcampeon;
	private Propiedad equipoCampeon = new Propiedad();
	private Propiedad equipoSubcampeon = new Propiedad();
	private Caracteristicas productor = new Caracteristicas();
	private int tipoTarjeta;
	

    public Tarjeta() {
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


	@Column(name="Activa", nullable=false)
	public boolean getActiva() {
		return this.activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}


	@Column(name="EstaCompleta", nullable=false)
	public boolean getEstaCompleta() {
		return this.estaCompleta;
	}

	public void setEstaCompleta(boolean estaCompleta) {
		this.estaCompleta = estaCompleta;
	}


	//@Temporal( TemporalType.TIMESTAMP)
	@Column(name="FechaModificacion", nullable=false)
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	//bi-directional many-to-one association to Pronosticosclasificacion
	@OneToMany(mappedBy="tarjeta")
	public List<PronosticoClasificacion> getPronosticosClasificacion() {
		return this.pronosticosClasificacion;
	}

	public void setPronosticosClasificacion(List<PronosticoClasificacion> pronosticosClasificacion) {
		this.pronosticosClasificacion = pronosticosClasificacion;
	}
	

	//bi-directional many-to-one association to Pronosticospartido
	@OneToMany(mappedBy="tarjeta")
	public List<PronosticoPartido> getPronosticosPartidos() {
		return this.pronosticosPartidos;
	}

	public void setPronosticosPartidos(List<PronosticoPartido> pronosticosPartidos) {
		this.pronosticosPartidos = pronosticosPartidos;
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

	@Column(name="Goleador",length=200)
	public String getGoleador() {
		return this.goleador;
	}

	public void setGoleador(String goleador) {
		this.goleador = goleador;
	}


	@Column(name="MejorJugador", length=200)
	public String getMejorJugador() {
		return this.mejorJugador;
	}

	public void setMejorJugador(String mejorJugador) {
		this.mejorJugador = mejorJugador;
	}


	@Column(name="PuntosCampeon")
	public int getPuntosCampeon() {
		return this.puntosCampeon;
	}

	public void setPuntosCampeon(int puntosCampeon) {
		this.puntosCampeon = puntosCampeon;
	}


	@Column(name="PuntosGoleador")
	public int getPuntosGoleador() {
		return this.puntosGoleador;
	}

	public void setPuntosGoleador(int puntosGoleador) {
		this.puntosGoleador = puntosGoleador;
	}


	@Column(name="PuntosMejorJugador")
	public int getPuntosMejorJugador() {
		return this.puntosMejorJugador;
	}

	public void setPuntosMejorJugador(int puntosMejorJugador) {
		this.puntosMejorJugador = puntosMejorJugador;
	}


	@Column(name="PuntosSubcampeon")
	public int getPuntosSubcampeon() {
		return this.puntosSubcampeon;
	}

	public void setPuntosSubcampeon(int puntosSubcampeon) {
		this.puntosSubcampeon = puntosSubcampeon;
	}


	//bi-directional many-to-one association to Equipo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdEquipoCampeon", nullable=true)
	public Propiedad getEquipoCampeon() {
		return this.equipoCampeon;
	}

	public void setEquipoCampeon(Propiedad equipoCampeon) {
		this.equipoCampeon = equipoCampeon;
	}
	

	//bi-directional many-to-one association to Equipo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdEquipoSubcampeon", nullable=true)
	public Propiedad getEquipoSubcampeon() {
		return this.equipoSubcampeon;
	}

	public void setEquipoSubcampeon(Propiedad equipoSubcampeon) {
		this.equipoSubcampeon = equipoSubcampeon;
	}

	//bi-directional many-to-one association to Productor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdProductor", nullable=true)
	public Caracteristicas getProductor() {
		return this.productor;
	}

	public void setProductor(Caracteristicas productor) {
		this.productor = productor;
	}

	@Column(name="TipoTarjeta")
	public int getTipoTarjeta() {
		return this.tipoTarjeta;
	}

	public void setTipoTarjeta(int tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	@Transient
	public boolean isTarjetaProductor() {
		return (this.getTipoTarjeta() == TIPO_TARJETA_PRODUCTOR);
	}

	@Transient
	public String getNumeroTarjeta() {
		String numero = String.format("%05d", this.id);
		if (this.getTipoTarjeta() == TIPO_TARJETA_PRODUCTOR) {
			numero += "/P";
		}
		return numero;
	}

	@Transient
	public boolean isTarjetaOctavos() {
		return (this.getTipoTarjeta() == TIPO_TARJETA_OCTAVOS );
	}
	
	@Transient
	public boolean isTarjetaCuartos() {
		return (this.getTipoTarjeta() == TIPO_TARJETA_CUARTOS );
	}
	
	@Transient
	public boolean isTarjetaSemi() {
		return (this.getTipoTarjeta() == TIPO_TARJETA_SEMI );
	}
	
	@Transient
	public boolean isTarjetaFinal() {
		return (this.getTipoTarjeta() == TIPO_TARJETA_FINAL );
	}
	



	
}