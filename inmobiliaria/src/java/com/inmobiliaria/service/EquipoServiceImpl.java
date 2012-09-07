package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Propiedad;


@Transactional
public class EquipoServiceImpl implements EquipoService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Propiedad> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Equipo o Order by o.descripcion ASC");
        return query.getResultList();
    }

    public void save(Propiedad equipo) {
        if (equipo.getId() == 0) {
            // new
            em.persist(equipo);
        } else {
            // update
            em.merge(equipo);
        }
    }

    public void remove(int id) {
    	Propiedad equipo = find(id);
        if (equipo != null) {
            em.remove(equipo);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Propiedad find(int id) {
        return em.find(Propiedad.class, id);
    }


}
