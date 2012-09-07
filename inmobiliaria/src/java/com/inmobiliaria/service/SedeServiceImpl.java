package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;


import com.inmobiliaria.model.Sede;


@Transactional
public class SedeServiceImpl implements SedeService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Sede> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Sede o Order by o.id ASC");
        return query.getResultList();
    }

    public void save(Sede sede) {
        if (sede.getId() == 0) {
            // new
            em.persist(sede);
        } else {
            // update
            em.merge(sede);
        }
    }

    public void remove(int id) {
    	Sede sede = find(id);
        if (sede != null) {
            em.remove(sede);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Sede find(int id) {
        return em.find(Sede.class, id);
    }




}
