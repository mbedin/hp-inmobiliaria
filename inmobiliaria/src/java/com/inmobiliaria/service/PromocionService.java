package com.inmobiliaria.service;

import java.util.List;

import com.inmobiliaria.model.Propiedad;
import com.inmobiliaria.model.Promocion;


public interface PromocionService {
    public List<Promocion> findAll();

    public void save(Promocion promocion);

    public void remove(int id);

    public Promocion find(int id);
    
    public Promocion findPromocionVigente();
    
}
