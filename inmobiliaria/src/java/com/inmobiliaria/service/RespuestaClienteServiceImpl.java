package com.inmobiliaria.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Persona;
import com.inmobiliaria.model.RespuestaCliente;


@Transactional
public class RespuestaClienteServiceImpl implements RespuestaClienteService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<RespuestaCliente> findAll() {
        Query query = getEntityManager().createQuery("select o FROM RespuestaCliente o");
        return query.getResultList();
    }

    public void save(RespuestaCliente respuestaCliente) {
        if (respuestaCliente.getId() == 0) {
            // new
            em.persist(respuestaCliente);
        } else {
            // update
            em.merge(respuestaCliente);
        }
    }

    public void remove(int id) {
    	RespuestaCliente respuestaCliente = find(id);
        if (respuestaCliente != null) {
            em.remove(respuestaCliente);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public RespuestaCliente find(int id) {
        return em.find(RespuestaCliente.class, id);
    }

    public RespuestaCliente findRespuestaCliente(Persona cliente) {
    	RespuestaCliente respuestaCliente = null;
    	
        //String strQuery = " SELECT r.*, p.* from respuestasclientes r "+
        //			" INNER JOIN preguntas p ON r.IdPregunta = p.Id "+
        //			" WHERE FechaPublicacion <= :fecha AND :fecha <= FechaFinPublicacion " +
        //			" 	and r.IdCliente = :cliente";
        //Query query = em.createNativeQuery(strQuery, Cliente.class);
        //Query query = getEntityManager().createQuery("select o FROM RespuestaCliente o where o.fecha = :fecha and o.cliente = :cliente");
    	
    	String strQuery = " select r FROM RespuestaCliente r " +
    			" where r.pregunta.fechaPublicacion <= :fecha and :fecha <= r.pregunta.fechaFinPublicacion " +
    			"	and r.cliente = :cliente ";
    	
    	Query query = getEntityManager().createQuery(strQuery);
    	
    	query.setParameter("fecha", new Date());
    	query.setParameter("cliente", cliente);
        List<RespuestaCliente> list = query.getResultList();
    	if (list != null && list.size() > 0 )
    		respuestaCliente = list.get(0);
    	
    	return respuestaCliente;
    }
    
    public boolean isTriviaJugada(Persona cliente) {
    	boolean result = (findRespuestaCliente(cliente) != null );
    	return result;
    }

}
