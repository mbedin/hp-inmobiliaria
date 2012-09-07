package com.inmobiliaria.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Partido;

	@Transactional
	public class PartidoServiceImpl implements PartidoService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    @SuppressWarnings("unchecked")
     private EntityManager getEntityManager() {
        return em;
    }
    
    public List<Partido> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Partido o ");
        return query.getResultList();
    }

	
    public void save(Partido partido) {
		if (partido.getId() == 0) {
	            // new
	            em.persist(partido);
	        } else {
	            // update
	            em.merge(partido);
	        }
	}
	
	public void remove(int id) {
		Partido partido = find(id);
        if (partido != null) {
            em.remove(partido);
        }
	}
    
    public Partido find(int id) {
		 return em.find(Partido.class, id);
	}
    
    // Devuelve la cantidad total de partidos
    public int countPartidos() {
		Query query = getEntityManager().createQuery("select count(o) FROM Partido o ");
        int total = ((Long)query.getSingleResult()).intValue(); 
        return total;
	}

    // Devuelve los partidos de una pagina
    public List<Partido> findPartidos(int numeroPagina, int tamanoPagina ) {
    	Query query = getEntityManager().createQuery("select o FROM Partido o ORDER BY o.grupo.id asc, o.fecha asc, o.id asc ");

    	if (tamanoPagina > 0) {
    		query.setFirstResult((numeroPagina - 1) * tamanoPagina);
    		query.setMaxResults(tamanoPagina);
    	}
        return query.getResultList();
	
    }
	
	
}
