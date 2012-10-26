package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Localidad;

public interface LocalidadService {
	public List<Localidad> findAll();

	public void save(Localidad localidad);

	public void remove(int id);

	public Localidad find(int id);

}
