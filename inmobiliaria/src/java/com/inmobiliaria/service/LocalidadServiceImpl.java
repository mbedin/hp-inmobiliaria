package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Localidad;



@Transactional
public class LocalidadServiceImpl implements LocalidadService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Localidad> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Localidad o Order by o.id ASC");
        return query.getResultList();
    }

    public void save(Localidad localidad) {
        if (localidad.getId() == 0) {
            // new
            em.persist(localidad);
        } else {
            // update
            em.merge(localidad);
        }
    }

    public void remove(int id) {
    	Localidad localidad = find(id);
        if (localidad != null) {
            em.remove(localidad);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Localidad find(int id) {
        return em.find(Localidad.class, id);
    }


}
