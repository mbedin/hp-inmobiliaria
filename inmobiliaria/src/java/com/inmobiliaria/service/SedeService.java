package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Sede;


public interface SedeService {
    
	public List<Sede> findAll();

    public void save(Sede sede);

    public void remove(int id);

    public Sede find(int id);
    
}
