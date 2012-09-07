package com.inmobiliaria.service;

import java.util.List;


import com.inmobiliaria.model.Parametro;



public interface ParametroService {
    
	public List<Parametro> findAll();

    public void save(Parametro parametro);

    public void remove(int id);

    public Parametro find(int id);
    
    public boolean getCargaHabilitadaTPFaseGrupo();
}
