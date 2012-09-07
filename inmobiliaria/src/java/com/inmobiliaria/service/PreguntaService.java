package com.inmobiliaria.service;

import java.util.Date;
import java.util.List;

import com.inmobiliaria.model.Contrato;


public interface PreguntaService {
    public List<Contrato> findAll();

    public void save(Contrato pregunta);

    public void remove(int id);

    public Contrato find(int id);
    
    public Contrato findPreguntaVigente(int puntos);
    
    public int countPreguntas();
    
    public List<Contrato> findPreguntas(int numeroPagina, int tamanoPagina);
    
    public boolean isPreguntaUsada(int idPregunta);
    
    public boolean validaRangoFechas(int puntos, Date fechaPublicacion, Date fechaFinPublicacion);
    
    public boolean validaRangoFechasModificacion(int idPreg, int puntos, Date fechaPublicacion,Date fechaFinPublicacion);

}
