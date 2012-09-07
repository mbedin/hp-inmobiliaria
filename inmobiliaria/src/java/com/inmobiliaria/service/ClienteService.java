package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Persona;


public interface ClienteService {
    public List<Persona> findAll();

    public void save(Persona cliente);

    public void remove(int id);

    public Persona find(int id);
    
    public Persona login(String usuario, String password);
    
    public List<Persona> findClientesConNuevasTarjetas();
    
    public List<Persona> findClientesSinTarjetas();
    
    public int ObtenerPuntosTriviaPorCliente(Persona cliente);
    
    public Persona findClienteByUsuario(String usuario);

    public List<Persona> findClientesProductor();
    
    public List<Persona> findClientesByAceptoBases(Boolean aceptoBases);

    public List<Persona> findClientesReporteTarjetas();
    
    public List<Persona> findClientesPuntosTrivia();
    
    public List<Persona> findClientesReporteGeneral();

	public List<Persona> findClientesConNuevasTarjetasOctavos();

	public List<Persona> findClientesPorPuntos();
	
	public Persona findPuntosCliente(int idCliente );

	public List<Persona> findClientesPuntosFinales();
    
}
