package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.PronosticoPartido;



@Transactional
public class PronosticoPartidoServiceImpl implements PronosticoPartidoService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<PronosticoPartido> findAll() {
        Query query = getEntityManager().createQuery("select o FROM PronosticoPartido o");
        return query.getResultList();
    }

    public void save(PronosticoPartido pronosticoPartido) {
        if (pronosticoPartido.getId() == 0) {
            // new
            em.persist(pronosticoPartido);
        } else {
            // update
            em.merge(pronosticoPartido);
        }
    }

    public void remove(int id) {
    	PronosticoPartido pronosticoPartido = find(id);
        if (pronosticoPartido != null) {
            em.remove(pronosticoPartido);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public PronosticoPartido find(int id) {
        return em.find(PronosticoPartido.class, id);
    }

	public List<PronosticoPartido> findPronosticosPorIdPartido(int idPartido) {
		String strQuery = "select pp.Id, pp.IdTarjetaProde, pp.IdPartido, pp.Resultado,"+ 
		"pp.GolesLocal, pp.GolesVisitante, pp.Puntos, pp.TienePremio "+
		"from pronosticospartidos pp, tarjetasprode t "+
		"where pp.IdPartido = :idPartido and t.Id = pp.IdtarjetaProde and t.EstaCompleta=:estaCompleta ";
		Query query = em.createNativeQuery(strQuery, PronosticoPartido.class);
        query.setParameter("idPartido", idPartido);
        query.setParameter("estaCompleta", true);
        return query.getResultList();
	}
 
}
