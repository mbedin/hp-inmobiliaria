package com.inmobiliaria.model;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 * The persistent class for the pronosticosmundial database table.
 * 
 */
@Entity
@Table(name = "pagos")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Contrato contrato = new Contrato();
	private BigDecimal montoMensual = new BigDecimal(0);
	private Date fechaVencimiento = new Date();

	public Pago() {
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

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public BigDecimal getMontoMensual() {
		return montoMensual;
	}

	public void setMontoMensual(BigDecimal montoMensual) {
		this.montoMensual = montoMensual;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	

}