package com.inmobiliaria.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.inmobiliaria.model.Persona;


@Transactional
public class ClienteServiceImpl implements ClienteService {
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Persona> findAll() {
        Query query = getEntityManager().createQuery("select o FROM Cliente o");
        return query.getResultList();
    }

    public void save(Persona cliente) {
        if (cliente.getId() == 0) {
            // new
            em.persist(cliente);
        } else {
            // update
            em.merge(cliente);
        }
    }

    public void remove(int id) {
    	Persona cliente = find(id);
        if (cliente != null) {
            em.remove(cliente);
        }
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Persona find(int id) {
        return em.find(Persona.class, id);
    }

	public Persona login(String usuario, String password) {
		String strQuery = "SELECT o FROM Cliente o WHERE o.usuario = :usuario AND o.password = :password AND o.activo = :activo ";
		Query query = em.createQuery(strQuery);
		query.setParameter("usuario", usuario);
		query.setParameter("password", password);
		query.setParameter("activo", true);
		List<Persona> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
    @SuppressWarnings("unchecked")
    public List<Persona> findClientesConNuevasTarjetas() {
        String strQuery = " SELECT c.Id, c.NombreYApellido,	c.RazonSocial, c.EMail,	c.Usuario, " + 
        		" c.Password, c.TarjetasAnterior, c.TarjetasExtrasAnterior, " +
        		" IF(ISNULL(t.tv), 0, t.tv) Tarjetas, " +  
        		" IF(ISNULL(t.t_extra), 0, t.t_extra) TarjetasExtras, c.Activo, c.AceptoBases, c.JuegaPlayOff  " +
        		"		FROM clientes c " +
        		" LEFT JOIN tarjetas_bio t ON trim(c.usuario) = trim(t.cli_crm) " +
        		"	WHERE c.activo = :activo " +
        		"	ORDER BY c.NombreYApellido ASC ";
        Query query = em.createNativeQuery(strQuery, Persona.class);
        query.setParameter("activo", true);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Persona> findClientesSinTarjetas() {
        String strQuery = " SELECT c.Id, c.NombreYApellido,	c.RazonSocial, c.EMail,	c.Usuario, " +
        	" 	c.Password, c.TarjetasAnterior, c.TarjetasExtrasAnterior, " +
        	" 	count(t.idCliente) Tarjetas, " +
        	" 	count(t.idCliente) TarjetasExtras, " + 
        	" 	c.Activo, c.AceptoBases, c.JuegaPlayOff  " +
        	" FROM clientes c " +
        	" LEFT JOIN tarjetasprode t ON c.id = t.idCliente " +
        	" GROUP BY c.Id, c.NombreYApellido,	c.RazonSocial, c.EMail,	c.Usuario, " + 
        	" 	c.Password, c.TarjetasAnterior, c.TarjetasExtrasAnterior, " +
        	" 	c.Activo, c.AceptoBases " +
        	" HAVING count(t.idCliente) = 0 " +
        	" ORDER BY c.NombreYApellido ASC";
        Query query = em.createNativeQuery(strQuery, Persona.class);
        return query.getResultList();
    }
    
    public int ObtenerPuntosTriviaPorCliente(Persona cliente) {
    	int puntos = 0;
    	Query query = getEntityManager().createQuery("select sum(o.puntos) FROM RespuestaCliente o where o.cliente = :cliente");
    	query.setParameter("cliente", cliente);
    	List list = query.getResultList();
    	if (list != null && list.size() > 0 ) {
    		if (list.get(0) != null) {
    			puntos = ((Long) list.get(0)).intValue();
    		}
    	}
    	
        return puntos;
    }
    
    public Persona findClienteByUsuario(String usuario) {
    	String strQuery = "SELECT o FROM Cliente o WHERE o.usuario = :usuario AND o.activo = :activo ";
		Query query = em.createQuery(strQuery);
		query.setParameter("usuario", usuario);
		query.setParameter("activo", true);
		List<Persona> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		}
		
		return list.get(0);
    }
    
    public List<Persona> findClientesProductor() {
        Query query = getEntityManager().createQuery("select o FROM Cliente o WHERE o.activo = :activo ORDER BY o.nombreYApellido ASC");
        query.setParameter("activo", true);
        return query.getResultList();
    }
    
    public List<Persona> findClientesByAceptoBases(Boolean aceptoBases) {
        Query query = getEntityManager().createQuery("select o FROM Cliente o WHERE o.activo = :activo and o.aceptoBases = :aceptoBases ORDER BY o.nombreYApellido ASC");
        query.setParameter("activo", true);
        query.setParameter("aceptoBases", aceptoBases);
        return query.getResultList();
    }

    public List<Persona> findClientesReporteTarjetas() {
        String strQuery = "SELECT c.Id, c.NombreYApellido, c.RazonSocial, c.EMail, c.Usuario, c.Password, " +
        		" COUNT(t.id) TarjetasAnterior, " +
        		" SUM(IF (t.estaCompleta = 1, 1, 0)) TarjetasExtrasAnterior, " +
        		" 0 Tarjetas, 0 TarjetasExtras,	c.Activo, c.AceptoBases, c.JuegaPlayOff  " +
        		" 	FROM clientes c, tarjetasprode t " +
        		"	WHERE c.Id = t.IdCliente AND c.activo = :activo " +
        		"	GROUP BY c.Id" +
        		"	ORDER BY c.NombreYApellido ASC ";
        Query query = em.createNativeQuery(strQuery, Persona.class);
        query.setParameter("activo", true);
        return query.getResultList();
    }
    
    public List<Persona> findClientesPuntosTrivia() {
        String strQuery = "SELECT c.Id, c.NombreYApellido, c.RazonSocial, c.EMail, c.Usuario, c.Password, " +
        		" SUM(r.puntos) TarjetasAnterior, " +
        		" 0 TarjetasExtrasAnterior, " +
        		" 0 Tarjetas, 0 TarjetasExtras,	c.Activo, c.AceptoBases, c.JuegaPlayOff " +
        		" 	FROM clientes c, respuestasclientes r " +
        		"	WHERE c.Id = r.IdCliente AND c.activo = :activo " +
        		"	GROUP BY c.Id" +
        		"	ORDER BY SUM(r.puntos) DESC ";
        Query query = em.createNativeQuery(strQuery, Persona.class);
        query.setParameter("activo", true);
        return query.getResultList();
    }

	
	public List<Persona> findClientesReporteGeneral() {
		  String strQuery = "SELECT p.id, p.NombreYApellido, p.RazonSocial, p.EMail, p.usuario, p.Password, p.Activo, p.JuegaPlayOff,  " +
  		" sum(AceptoBases) as AceptoBases, " +
  		" sum(Tarjetas) as Tarjetas, " +
  		" sum(TarjetasAnterior) as TarjetasAnterior, " +
  		" sum(TarjetasExtrasAnterior) as TarjetasExtrasAnterior, " +
  		" sum(TarjetasExtras) as TarjetasExtras" +
  		" FROM ( " +
  		" SELECT   c.Id, c.NombreYApellido, c.RazonSocial, c.AceptoBases, c.EMail, c.usuario, c.Password, c.Activo,0 Tarjetas, c.JuegaPlayOff, " +
  		" COUNT(t.id) TarjetasAnterior, " +
  		" (SUM(IF (t.estaCompleta = 1, 1, 0))) TarjetasExtrasAnterior,"+
		" (SUM(IF (t.estaCompleta = 0, 1, 0))) TarjetasExtras" +
		" FROM clientes c, tarjetasprode t" +
	  	" WHERE c.Id = t.IdCliente AND c.activo = :activo " +
	  	" GROUP BY c.Id " +
	  	" UNION ALL"+
	  	" SELECT  c.Id, c.NombreYApellido, c.RazonSocial, 0 AceptoBases,  c.EMail, c.usuario, c.Password, c.Activo, c.JuegaPlayOff, " +
		" SUM(r.puntos) Tarjetas, " +
	  	" 0 TarjetasAnterior, 0 TarjetasExtrasAnterior, 0 TarjetasExtras"+
	  	" FROM clientes c, respuestasclientes r " +
  		" WHERE c.Id = r.IdCliente AND c.activo = :activo " +
  		" GROUP BY c.Id ) AS p"+
		" GROUP BY p.id, p.NombreYApellido, p.RazonSocial, p.EMail, p.usuario, p.Password, p.Activo" ;
		  Query query = em.createNativeQuery(strQuery, Persona.class);
		  query.setParameter("activo", true);
		  return query.getResultList();
	}

		
		public List<Persona> findClientesConNuevasTarjetasOctavos() {
			String strQuery = "SELECT c.Id, c.NombreYApellido,	c.RazonSocial, c.EMail,	c.Usuario, "+
			" c.Password, c.TarjetasAnterior, c.TarjetasExtrasAnterior, "+
			" c.Tarjetas, c.TarjetasExtras, c.Activo, c.AceptoBases, c.JuegaPlayOff  "+
			" FROM clientes c "+
			" WHERE c.Activo = :activo and c.JuegaPlayOff = :juegaPlayOff "+
			" ORDER BY c.Id ";
			Query query = em.createNativeQuery(strQuery, Persona.class);
			query.setParameter("activo", true);
			query.setParameter("juegaPlayOff", true);
			return query.getResultList();
	    
		}

		public List<Persona> findClientesPorPuntos() {
			String strQuery = "SELECT p.id, p.NombreYApellido, p.RazonSocial, p.EMail, p.usuario, "+
			" p.Password, p.Activo, p.AceptoBases, p.JuegaPlayOff, p.Tarjetas, p.TarjetasAnterior, p.TarjetasExtrasAnterior,  "+
			" sum(TarjetasExtras) as TarjetasExtras "+
			" FROM ( "+
			" SELECT   c.id, c.NombreYApellido, c.RazonSocial, c.EMail, c.usuario, c.Password, c.Activo, "+
			" c.AceptoBases, c.JuegaPlayOff, c.Tarjetas, c.TarjetasAnterior, c.TarjetasExtrasAnterior, "+
			" (SUM(pp.Puntos)) TarjetasExtras  "+
			" FROM clientes c, tarjetasprode t, pronosticospartidos pp "+
			" WHERE c.Id = t.IdCliente AND c.activo = :activo AND pp.IdTarjetaProde = t.Id AND c.JuegaPlayOff = :juegaPlayOff AND t.Activa=:activa "+
			" GROUP BY c.Id "+ 
		    " ) AS p "+
		    " GROUP BY p.id, p.NombreYApellido, p.RazonSocial, p.EMail, p.usuario, p.Password, p.Activo "+
			" ORDER BY sum(TarjetasExtras) DESC  ";
			Query query = em.createNativeQuery(strQuery, Persona.class);
			query.setParameter("activo", true);
			query.setParameter("activa", true);
			query.setParameter("juegaPlayOff", true);
			return query.getResultList();
			
		}

		public Persona findPuntosCliente(int idCliente) {
			String strQuery = "SELECT p.id, p.NombreYApellido, p.RazonSocial, p.EMail, p.usuario, "+
			" p.Password, p.Activo, p.AceptoBases, p.JuegaPlayOff, p.Tarjetas, p.TarjetasAnterior, p.TarjetasExtrasAnterior,  "+
			" sum(TarjetasExtras) as TarjetasExtras "+
			" FROM ( "+
			" SELECT   c.id, c.NombreYApellido, c.RazonSocial, c.EMail, c.usuario, c.Password, c.Activo, "+
			" c.AceptoBases, c.JuegaPlayOff, c.Tarjetas, c.TarjetasAnterior, c.TarjetasExtrasAnterior, "+
			" (SUM(pp.Puntos)) TarjetasExtras  "+
			" FROM clientes c, tarjetasprode t, pronosticospartidos pp "+
			" WHERE c.Id = t.IdCliente AND c.activo = :activo AND pp.IdTarjetaProde = t.Id AND c.JuegaPlayOff = :juegaPlayOff AND c.Id = :idCliente "+
			" GROUP BY c.Id "+ 
		    " ) AS p "+
		    " GROUP BY p.id, p.NombreYApellido, p.RazonSocial, p.EMail, p.usuario, p.Password, p.Activo "+
			" ORDER BY sum(TarjetasExtras) DESC  ";
			Query query = em.createNativeQuery(strQuery, Persona.class);
			query.setParameter("activo", true);
			query.setParameter("juegaPlayOff", true);
			query.setParameter("idCliente", idCliente);
			List<Persona> list = query.getResultList();
			if (list.isEmpty()) {
				return null;
			}
			
			return list.get(0);
			
		}

		public List<Persona> findClientesPuntosFinales() {
			String strQuery = "SELECT p.id, p.NombreYApellido, p.RazonSocial, p.EMail, p.usuario, "+
			" p.Password, p.Activo, p.AceptoBases, p.JuegaPlayOff, p.Tarjetas, p.TarjetasAnterior, p.TarjetasExtrasAnterior,  "+
			" sum(TarjetasExtras) as TarjetasExtras "+
			" FROM ( "+
			" SELECT   c.id, c.NombreYApellido, c.RazonSocial, c.EMail, c.usuario, c.Password, c.Activo, "+
			" c.AceptoBases, c.JuegaPlayOff, c.Tarjetas, c.TarjetasAnterior, c.TarjetasExtrasAnterior, "+
			" (SUM(pp.Puntos)) TarjetasExtras  "+
			" FROM clientes c, tarjetasprode t, pronosticospartidos pp "+
			" WHERE c.Id = t.IdCliente AND c.JuegaPlayOff =:juegaPlayOff AND pp.IdTarjetaProde=t.Id AND t.Activa=:activa " +
			" GROUP BY c.Id "+ 
			" UNION ALL  "+
			" SELECT   c.id, c.NombreYApellido, c.RazonSocial, c.EMail, c.usuario, c.Password, c.Activo, "+
			" c.AceptoBases, c.JuegaPlayOff, c.Tarjetas, c.TarjetasAnterior, c.TarjetasExtrasAnterior, "+
			" (SUM(rc.Puntos)) TarjetasExtras  "+
			" FROM clientes c,  respuestasclientes rc  "+
			" WHERE c.Id = rc.IdCliente AND c.JuegaPlayOff =:juegaPlayOff  "+
			" GROUP BY c.Id  "+
			" UNION ALL "+
			" SELECT   c.id, c.NombreYApellido, c.RazonSocial, c.EMail, c.usuario, c.Password, c.Activo, "+
			" c.AceptoBases, c.JuegaPlayOff, c.Tarjetas, c.TarjetasAnterior, c.TarjetasExtrasAnterior, "+
			" (SUM(t.PuntosCampeon)) TarjetasExtras "+
			" FROM clientes c, tarjetasprode t  "+
			" WHERE c.Id = t.IdCliente AND c.JuegaPlayOff =:juegaPlayOff AND t.Activa=:activa  "+
			" GROUP BY c.Id  "+
			" UNION ALL  "+
			" SELECT   c.id, c.NombreYApellido, c.RazonSocial, c.EMail, c.usuario, c.Password, c.Activo, "+
			" c.AceptoBases, c.JuegaPlayOff, c.Tarjetas, c.TarjetasAnterior, c.TarjetasExtrasAnterior, "+
			" (SUM(t.PuntosSubCampeon)) TarjetasExtras  "+
			" FROM clientes c, tarjetasprode t  "+
			" WHERE c.Id = t.IdCliente AND c.JuegaPlayOff =:juegaPlayOff AND t.Activa=:activa  "+
			" GROUP BY c.Id  "+
			" UNION ALL  "+
			" SELECT   c.id, c.NombreYApellido, c.RazonSocial, c.EMail, c.usuario, c.Password, c.Activo, "+
			" c.AceptoBases, c.JuegaPlayOff, c.Tarjetas, c.TarjetasAnterior, c.TarjetasExtrasAnterior, "+
			" (SUM(t.PuntosMejorJugador)) TarjetasExtras  "+
			" FROM clientes c, tarjetasprode t  "+
			" WHERE c.Id = t.IdCliente AND c.JuegaPlayOff =:juegaPlayOff AND t.Activa=:activa  "+
			" GROUP BY c.Id  "+ 
			" UNION ALL "+
			" SELECT   c.id, c.NombreYApellido, c.RazonSocial, c.EMail, c.usuario, c.Password, c.Activo, "+
			" c.AceptoBases, c.JuegaPlayOff, c.Tarjetas, c.TarjetasAnterior, c.TarjetasExtrasAnterior, "+
			" (SUM(t.PuntosGoleador)) TarjetasExtras "+
			" FROM clientes c, tarjetasprode t "+
			" WHERE c.Id = t.IdCliente AND c.JuegaPlayOff =:juegaPlayOff AND t.Activa=:activa "+
			" GROUP BY c.Id "+ 
			" ) AS p "+
			" where p.JuegaPlayOff=:juegaPlayOff "+
			" GROUP BY p.id, p.NombreYApellido, p.Activo  "+
			" ORDER BY sum(TarjetasExtras) DESC	";
			Query query = em.createNativeQuery(strQuery, Persona.class);
			query.setParameter("activa", true);
			query.setParameter("juegaPlayOff", true);
			return query.getResultList();

		}

}
