package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Provincia;


@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Provincia> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Provincia o Order by orden");
        return query.getResultList();
    }

    public void save(Provincia provincia) {
        if (provincia.getId() == 0) {
            // new
            em.persist(provincia);
        } else {
            // update
            em.merge(provincia);
        }
    }

    public void remove(int id) {
    	Provincia provincia = find(id);
        if (provincia != null) {
            em.remove(provincia);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Provincia find(int id) {
        return em.find(Provincia.class, id);
    }

}
