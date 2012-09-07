package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Propiedad;


public interface EquipoService {
    public List<Propiedad> findAll();

    public void save(Propiedad equipo);

    public void remove(int id);

    public Propiedad find(int id);
    
}
