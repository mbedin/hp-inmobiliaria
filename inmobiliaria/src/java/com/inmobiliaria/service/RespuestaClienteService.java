package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Persona;
import com.inmobiliaria.model.RespuestaCliente;


public interface RespuestaClienteService {
    public List<RespuestaCliente> findAll();

    public void save(RespuestaCliente respuestaCliente);

    public void remove(int id);

    public RespuestaCliente find(int id);
    
    public RespuestaCliente findRespuestaCliente(Persona cliente);
    
    public boolean isTriviaJugada(Persona cliente);
    
}
