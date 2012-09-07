package com.inmobiliaria.action;

import java.util.Map;

import com.inmobiliaria.model.Persona;
import com.inmobiliaria.model.Util;
import com.inmobiliaria.service.ClienteService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BasePublicAction {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2514975465946565810L;
	
	// Services
	private ClienteService clienteService;
	
    // Model Principal
	
	public LoginAction(ClienteService clienteService) {
		
		this.setCliente(new Persona());
		
		// Seteamos los services
    	this.clienteService = clienteService;
        
    }

    /*************************************************
     *  Getters y Setters
     *************************************************/
    

    /*************************************************
     *  Methods
     *************************************************/
    
	public String doInput() {

    	this.setCliente(new Persona());
    	
    	return Action.INPUT;
    	
    }

    
	public void validateDoIngresar(){
    	
		this.setSubmitted(true);
    	
    	if (Util.isStringNullOrEmpty(this.getCliente().getUsuario()) &&
				Util.isStringNullOrEmpty(this.getCliente().getPassword())) {
    		
    		this.addFieldError("cliente.login", getText("login.error.usuarioypassword.missing"));
    		
    		
    	} else if (Util.isStringNullOrEmpty(this.getCliente().getUsuario())) {
 			
 			this.addFieldError("cliente.login", getText("login.error.usuario.missing"));
 			
 		} else if (Util.isStringNullOrEmpty(this.getCliente().getPassword())){
 			
 			this.addFieldError("cliente.login", getText("login.error.password.missing"));
 			
 		}
    	
    }
    
	
	@SuppressWarnings("unchecked")
	public String doIngresar() {

		String password = Util.encriptar(this.getCliente().getPassword());
		
		Persona cliente = clienteService.login(this.getCliente().getUsuario(), password); //this.getCliente().getPassword()
    	
		
		if (cliente == null) {
			this.addFieldError("cliente.login", getText("login.error.loginIncorrecto"));
			return Action.INPUT;
		}
		
		if (!cliente.isActivo()) {
			return ACTION_CLIENTE_ELIMINADO;
			
		}   
			
		this.setCliente(cliente);
			
	    Map session = ActionContext.getContext().getSession();
	    session.put(CLIENTE_LOGUEADO, this.getCliente());
	   
	    return Action.SUCCESS;
		
	}
  
	
    public String doComoJugar() {

    	if (!isSessionActive()) return Action.LOGIN;
    	
    	this.setRetorno(ACTION_PRINCIPAL);

        return Action.INPUT;
        
    }
	
    /*************************************************
     *  Common
     *************************************************/
    
    protected void addCommonResources() {
    	addScript("login.js");
    }
    

}
