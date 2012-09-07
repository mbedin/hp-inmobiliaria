package com.inmobiliaria.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Contrato;


@Transactional
public class PreguntaServiceImpl implements PreguntaService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Contrato> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Pregunta o");
        return query.getResultList();
    }

    public void save(Contrato pregunta) {
        if (pregunta.getId() == 0) {
            // new
            em.persist(pregunta);
        } else {
            // update
            em.merge(pregunta);
        }
    }

    public void remove(int id) {
    	Contrato pregunta = find(id);
        if (pregunta != null) {
            em.remove(pregunta);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Contrato find(int id) {
        return em.find(Contrato.class, id);
    }

    public Contrato findPreguntaVigente(int puntos) {
    	Contrato pregunta = null;
    	//Query query = getEntityManager().createQuery("select o FROM Pregunta o where o.puntos = :puntos and o.fechaPublicacion = :fecha");
    	Query query = getEntityManager().createQuery("select o FROM Pregunta o where o.puntos = :puntos and o.fechaPublicacion <= :fecha AND :fecha <= o.fechaFinPublicacion ");
    	query.setParameter("puntos", puntos);
    	query.setParameter("fecha", new Date());
    	List<Contrato> list = query.getResultList();
    	if (list != null && list.size() > 0 )
    		pregunta = list.get(0);
        return pregunta;
    }

    // Devuelve la cantidad de preguntas
    public int countPreguntas() {
    	Query query = getEntityManager().createQuery("select count(o) FROM Pregunta o ");
        int total = ((Long)query.getSingleResult()).intValue(); 
        return total;
    }
    
    // Devuelve las preguntas de una una pagina
    public List<Contrato> findPreguntas(int numeroPagina, int tamanoPagina ) {
    	Query query = getEntityManager().createQuery("select o FROM Pregunta o ORDER BY o.fechaPublicacion DESC, o.puntos ASC, o.id");

    	if (tamanoPagina > 0) {
    		query.setFirstResult((numeroPagina - 1) * tamanoPagina);
    		query.setMaxResults(tamanoPagina);
    	}
        return query.getResultList();
	
    }

    // Devuelve true si la pregunta ya fue utilizada en la trivia
    public boolean isPreguntaUsada(int idPregunta){
    	Query query = getEntityManager().createQuery("select count(o) FROM RespuestaCliente o WHERE o.pregunta.id = :idPregunta");
        query.setParameter("idPregunta", idPregunta);
    	int total = ((Long)query.getSingleResult()).intValue();
    	return (total > 0);
    }
    
    // Valida que no exista una pregunta del mismo puntaje, 
    // con rangos de fechas superpuestos a los pasados
    // true => no existe
    public boolean validaRangoFechas(int puntos, Date fechaPublicacion, Date fechaFinPublicacion){
    	Query query = getEntityManager().createQuery("select count(o) FROM Pregunta o WHERE  o.puntos = :puntos and o.fechaPublicacion <= :fechaFinPublicacion and o.fechaFinPublicacion >= :fechaPublicacion ");
    	query.setParameter("puntos", puntos);
    	query.setParameter("fechaPublicacion", fechaPublicacion);
    	query.setParameter("fechaFinPublicacion", fechaFinPublicacion);
    	int total = ((Long)query.getSingleResult()).intValue(); 
    	return (total == 0);
    }

    // Valida que no exista una pregunta del mismo puntaje, 
    // con rangos de fechas superpuestos a los pasados, distinta a la del parametro
    // true => no existe
    public boolean validaRangoFechasModificacion(int idPreg, int puntos, Date fechaPublicacion,Date fechaFinPublicacion){
    	Query query = getEntityManager().createQuery("select count(o) FROM Pregunta o WHERE o.id <> :idPreg and o.puntos = :puntos and o.fechaPublicacion <= :fechaFinPublicacion and o.fechaFinPublicacion >= :fechaPublicacion ");
    	query.setParameter("idPreg", idPreg);
    	query.setParameter("puntos", puntos);
    	query.setParameter("fechaPublicacion", fechaPublicacion);
    	query.setParameter("fechaFinPublicacion", fechaFinPublicacion);
    	int total = ((Long)query.getSingleResult()).intValue(); 
    	return (total == 0);
        
    }
    
    
}
