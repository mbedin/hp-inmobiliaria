package com.inmobiliaria.action.admin;

import com.inmobiliaria.model.Usuario;
import com.inmobiliaria.service.UsuarioService;
import com.opensymphony.xwork2.Action;

public class MenuAction extends BaseAdminAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8091259220973713414L;

	// Services
	private UsuarioService usuarioService;
	
    // Model Principal
    
	public MenuAction(UsuarioService usuarioService) {
    	
		// Seteamos los services
    	this.setUsuarioService(usuarioService);
        
    }

    /*************************************************
     *  Getters y Setters
     *************************************************/
	
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	
	
    /*************************************************
     *  Methods
     *************************************************/
    public String doInput() {
    	
    	if (!isSessionActive()) return Action.LOGIN;
    	
    	this.setUsuario((Usuario) session.get(USUARIO_LOGUEADO));
        
        return Action.INPUT;
    }


    /*************************************************
     *  Common
     *************************************************/
    protected void addCommonResources() {
    	addScript("/admin/menu.js");
    }


    

}
