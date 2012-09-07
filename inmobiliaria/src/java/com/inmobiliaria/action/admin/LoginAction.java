package com.inmobiliaria.action.admin;

import java.util.Map;

import com.inmobiliaria.model.Usuario;
import com.inmobiliaria.model.Util;
import com.inmobiliaria.service.UsuarioService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAdminAction {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2514975465946565810L;
	
	// Services
	private UsuarioService usuarioService;
	
    // Model Principal
    

	public LoginAction(UsuarioService usuarioService) {
		
		this.setUsuario(new Usuario());
		
		// Seteamos los services
    	this.usuarioService = usuarioService;
        
    }

    /*************************************************
     *  Getters y Setters
     *************************************************/
    

    /*************************************************
     *  Methods
     *************************************************/
    public String doInput() {
    	
        return Action.INPUT;
    }

    public void validateDoIngresar(){
    	this.setSubmitted(true);

		if (Util.isStringNullOrEmpty(this.getUsuario().getUsuario()) &&
				Util.isStringNullOrEmpty(this.getUsuario().getPassword())	){
 			this.addFieldError("usuario.login", getText("admin.login.error.usuarioypassword.missing"));
 		} else if (Util.isStringNullOrEmpty(this.getUsuario().getUsuario()) ) {
 			this.addFieldError("usuario.login", getText("admin.login.error.usuario.missing"));
 		} else if (Util.isStringNullOrEmpty(this.getUsuario().getPassword())){
 			this.addFieldError("usuario.login", getText("admin.login.error.password.missing"));
 		}
	
		
    }
    
	@SuppressWarnings("unchecked")
	public String doIngresar() {

		Usuario usuario = usuarioService.login(this.getUsuario().getUsuario(), this.getUsuario().getPassword());
    	
		if (usuario == null) {
			this.addFieldError("usuario.login", getText("admin.login.error.loginIncorrecto"));
			return Action.INPUT;
			
		}

		this.setUsuario(usuario);
		
		
		
    	Map session = ActionContext.getContext().getSession();
    	session.put(USUARIO_LOGUEADO, this.getUsuario());
    	
    	return Action.SUCCESS;
    }
  

    /*************************************************
     *  Common
     *************************************************/
    protected void addCommonResources() {
    	addScript("/admin/login.js");
    }
    

}
