package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Persona;

@Transactional
public class PersonaServiceImpl implements PersonaService {
	private EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	private EntityManager getEntityManager() {
		return em;
	}

	public List<Persona> findAll() {
		Query query = getEntityManager()
				.createQuery("select p FROM Persona p ");
		return query.getResultList();
	}

	public void save(Persona persona) {
		if (persona.getId() == 0) {
			// new
			em.persist(persona);
		} else {
			// update
			em.merge(persona);
		}
	}

	public void remove(int id) {
		Persona persona = find(id);
		if (persona != null) {
			em.remove(persona);
		}
	}

	public Persona find(int id) {
		return em.find(Persona.class, id);
	}

	// Devuelve la cantidad total de Propiedads
	public int countPersonas() {
		Query query = getEntityManager().createQuery(
				"select count(o) FROM Persona o ");
		int total = ((Long) query.getSingleResult()).intValue();
		return total;
	}

	// Devuelve los Propiedads de una pagina
	public List<Persona> findPersonas(int numeroPagina, int tamanoPagina) {
		Query query = getEntityManager().createQuery(
				"select o FROM Persona o ORDER BY o.id asc ");

		if (tamanoPagina > 0) {
			query.setFirstResult((numeroPagina - 1) * tamanoPagina);
			query.setMaxResults(tamanoPagina);
		}
		return query.getResultList();

	}

	public Persona findByDni(String dniPropietario) {
		String strQuery = "SELECT o FROM Persona o WHERE o.dni = :dni AND o.activo = :activo ";
		Query query = em.createQuery(strQuery);
		query.setParameter("dni", dniPropietario);
		query.setParameter("activo", true);
		List<Persona> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

}
