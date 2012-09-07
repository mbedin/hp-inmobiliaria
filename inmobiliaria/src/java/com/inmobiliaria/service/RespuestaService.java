package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Respuesta;


public interface RespuestaService {
    public List<Respuesta> findAll();

    public void save(Respuesta respuesta);

    public void remove(int id);

    public Respuesta find(int id);
    
}
