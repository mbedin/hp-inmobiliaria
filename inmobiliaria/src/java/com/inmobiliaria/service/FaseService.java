package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Cita;



public interface FaseService {
    public List<Cita> findAll();

    public void save(Cita fase);

    public void remove(int id);

    public Cita find(int id);
    
}
