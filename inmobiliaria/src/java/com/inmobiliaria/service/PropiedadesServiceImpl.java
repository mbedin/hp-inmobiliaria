package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Propiedad;

	@Transactional
	public class PropiedadesServiceImpl implements PropiedadesService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    @SuppressWarnings("unchecked")
     private EntityManager getEntityManager() {
        return em;
    }
    
    public List<Propiedad> findAll() {
        Query query = getEntityManager().createQuery("select p FROM Propiedades p ");
        return query.getResultList();
    }

	
    public void save(Propiedad propiedad) {
		if (propiedad.getId() == 0) {
	            // new
	            em.persist(propiedad);
	        } else {
	            // update
	            em.merge(propiedad);
	        }
	}
	
	public void remove(int id) {
		Propiedad propiedad = find(id);
        if (propiedad != null) {
            em.remove(propiedad);
        }
	}
    
    public Propiedad find(int id) {
		 return em.find(Propiedad.class, id);
	}
    
    // Devuelve la cantidad total de Propiedads
    public int countPropiedades() {
		Query query = getEntityManager().createQuery("select count(o) FROM Propiedad o ");
        int total = ((Long)query.getSingleResult()).intValue(); 
        return total;
	}

    // Devuelve los Propiedads de una pagina
    public List<Propiedad> findPropiedades(int numeroPagina, int tamanoPagina ) {
    	Query query = getEntityManager().createQuery("select o FROM Propiedad o ORDER BY o.id asc ");

    	if (tamanoPagina > 0) {
    		query.setFirstResult((numeroPagina - 1) * tamanoPagina);
    		query.setMaxResults(tamanoPagina);
    	}
        return query.getResultList();
	
    }
	
	
}
