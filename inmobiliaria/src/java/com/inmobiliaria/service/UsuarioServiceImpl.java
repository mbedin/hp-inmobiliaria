package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Usuario;


@Transactional
public class UsuarioServiceImpl implements UsuarioService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Usuario o");
        return query.getResultList();
    }

    public void save(Usuario usuario) {
        if (usuario.getId() == 0) {
            // new
            em.persist(usuario);
        } else {
            // update
            em.merge(usuario);
        }
    }

    public void remove(int id) {
    	Usuario usuario = find(id);
        if (usuario != null) {
            em.remove(usuario);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Usuario find(int id) {
        return em.find(Usuario.class, id);
    }

	public Usuario login(String usuario, String password) {
		String strQuery = "SELECT o FROM Usuario o WHERE o.usuario = :usuario AND o.password = :password ";
		Query query = em.createQuery(strQuery);
		query.setParameter("usuario", usuario);
		query.setParameter("password", password);
		List<Usuario> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		}
		
		return list.get(0);
	}
	
}
