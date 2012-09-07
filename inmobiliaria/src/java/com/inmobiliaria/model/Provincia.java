package com.inmobiliaria.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the provincias database table.
 * 
 */
@Entity
@Table(name="provincias")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private int orden;

    public Provincia() {
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


	@Column(name="Nombre", length=200)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name="Orden")
	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

}