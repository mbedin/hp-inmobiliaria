package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Respuesta;


@Transactional
public class RespuestaServiceImpl implements RespuestaService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Respuesta> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Respuesta o");
        return query.getResultList();
    }

    public void save(Respuesta respuesta) {
        if (respuesta.getId() == 0) {
            // new
            em.persist(respuesta);
        } else {
            // update
            em.merge(respuesta);
        }
    }

    public void remove(int id) {
    	Respuesta respuesta = find(id);
        if (respuesta != null) {
            em.remove(respuesta);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Respuesta find(int id) {
        return em.find(Respuesta.class, id);
    }

}
