package com.inmobiliaria.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Promocion;


@Transactional
public class PromocionServiceImpl implements PromocionService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Promocion> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Promocion o Order by o.fechaDesde ASC");
        return query.getResultList();
    }

    public void save(Promocion promocion) {
        if (promocion.getId() == 0) {
            // new
            em.persist(promocion);
        } else {
            // update
            em.merge(promocion);
        }
    }

    public void remove(int id) {
    	Promocion promocion = find(id);
        if (promocion != null) {
            em.remove(promocion);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Promocion find(int id) {
        return em.find(Promocion.class, id);
    }

    public Promocion findPromocionVigente() {
        Query query = getEntityManager().createQuery("select o FROM Promocion o WHERE o.fechaDesde <= :fecha AND :fecha <= o.fechaHasta ");
        query .setParameter("fecha", new Date());
        List<Promocion> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		}
		
		return list.get(0);

    }


}
