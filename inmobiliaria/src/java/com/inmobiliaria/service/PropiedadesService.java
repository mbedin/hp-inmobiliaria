package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Propiedad;

public interface PropiedadesService {

	public List<Propiedad> findAll();

	public void save(Propiedad propiedad);

	public void remove(int id);

	public Propiedad find(int id);

	public int countPropiedades();

	public List<Propiedad> findPropiedades(int numeroPagina, int tamanoPagina);

}
