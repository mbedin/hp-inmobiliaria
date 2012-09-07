package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Cita;



@Transactional
public class FaseServiceImpl implements FaseService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Cita> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Fase o Order by o.id ASC");
        return query.getResultList();
    }

    public void save(Cita fase) {
        if (fase.getId() == 0) {
            // new
            em.persist(fase);
        } else {
            // update
            em.merge(fase);
        }
    }

    public void remove(int id) {
    	Cita fase = find(id);
        if (fase != null) {
            em.remove(fase);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Cita find(int id) {
        return em.find(Cita.class, id);
    }


}
