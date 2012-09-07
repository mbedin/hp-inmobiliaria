package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Localidad;


@Transactional
public class GrupoServiceImpl implements GrupoService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Localidad> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Grupo o Order by o.orden");
        return query.getResultList();
    }

    public void save(Localidad grupo) {
        if (grupo.getId() == 0) {
            // new
            em.persist(grupo);
        } else {
            // update
            em.merge(grupo);
        }
    }

    public void remove(int id) {
    	Localidad grupo = find(id);
        if (grupo != null) {
            em.remove(grupo);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Localidad find(int id) {
        return em.find(Localidad.class, id);
    }


}
