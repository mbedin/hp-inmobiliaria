package com.inmobiliaria.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the promociones database table.
 * 
 */
@Entity
@Table(name="promociones")
public class Promocion implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id = 0;
	private Date fechaDesde = new Date();
	private Date fechaHasta = new Date();
	private String imagen = "";
	private String nombreProducto = "";
	private String textoPromocion = "";

    public Promocion() {
    
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
	@Column(name="FechaDesde")
	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="FechaHasta")
	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	@Column(name="Imagen", length=200)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	@Column(name="NombreProducto", length=200)
	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	@Column(name="TextoPromocion", length=200)
	public String getTextoPromocion() {
		return this.textoPromocion;
	}

	public void setTextoPromocion(String textoPromocion) {
		this.textoPromocion = textoPromocion;
	}
	
	@Transient
	public String getVigencia() {
		SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
		return formatter.format(this.fechaDesde) + " - " + formatter.format(this.fechaHasta);
	}

}