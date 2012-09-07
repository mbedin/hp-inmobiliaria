package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Parametro;



@Transactional
public class ParametroServiceImpl implements ParametroService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Parametro> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Parametro o Order by o.id ASC");
        return query.getResultList();
    }

    public void save(Parametro parametro) {
        if (parametro.getId() == 0) {
            // new
            em.persist(parametro);
        } else {
            // update
            em.merge(parametro);
        }
    }

    public void remove(int id) {
    	Parametro parametro = find(id);
        if (parametro != null) {
            em.remove(parametro);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Parametro find(int id) {
        return em.find(Parametro.class, id);
    }

    public boolean getCargaHabilitadaTPFaseGrupo() {
    	Parametro parametro = find(1);
    	if (parametro == null) return false;
    	
    	return ("1".equals(parametro.getValor()));
    }

}
