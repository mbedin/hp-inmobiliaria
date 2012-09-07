package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Localidad;


public interface GrupoService {
    public List<Localidad> findAll();

    public void save(Localidad grupo);

    public void remove(int id);

    public Localidad find(int id);
    
}
