package com.inmobiliaria.action.admin;

import java.util.Map;

import com.inmobiliaria.action.BaseAction;
import com.inmobiliaria.model.Usuario;

public class BaseAdminAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7357069042876547037L;

	protected String ACTION_MENU = "menuAdmin";
	protected String ACTION_PROPIEDADES = "propiedades";
	protected String ACTION_NUEVO_PROPIETARIO = "nuevoPropietario";
	
	
	// Constantes para variables de session.
	protected String USUARIO_LOGUEADO = "usuario_logueado";
	protected String NUEVA_PROPIEDAD = "nueva_propiedad";

	protected int PAGINADOR_TAMANO_PAGINA = 10;
	
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public void setSession(Map map) {

    	this.session = map;

    	this.addCommonResources();

   		this.addStylesheet("css/admin.css");
   		
   		this.addScript("/admin/admin.js");

   		if (isSessionActive()) {
   			this.usuario = (Usuario)session.get(USUARIO_LOGUEADO);
   		}
    }

    protected boolean isSessionActive() {
    	// Si existe, obtener cliente logueado
    	//Map session = ActionContext.getContext().getSession();
    	if (session.get(USUARIO_LOGUEADO)==null) {
    		return false;
    	}
    	return true;
    }
}
