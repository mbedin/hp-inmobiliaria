package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Persona;

public interface PersonaService {

	public List<Persona> findAll();

	public void save(Persona persona);

	public void remove(int id);

	public Persona find(int id);

	public int countPersonas();

	public List<Persona> findPersonas(int numeroPagina, int tamanoPagina);

	public Persona findByDni(String dniPropietario);

}
