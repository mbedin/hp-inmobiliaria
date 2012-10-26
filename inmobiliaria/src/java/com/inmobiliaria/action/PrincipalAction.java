package com.inmobiliaria.action;

import com.inmobiliaria.model.Persona;
import com.inmobiliaria.service.ClienteService;
import com.opensymphony.xwork2.Action;

public class PrincipalAction extends BasePublicAction {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2514975465946565810L;
	
	// Services
	private ClienteService clienteService;
	
	// Model Principal
	private Persona cliente = new Persona();
	
    
	
	public PrincipalAction(ClienteService clienteService) {
    	
		// Seteamos los services
    	this.clienteService = clienteService;
    
        
    }

    /*************************************************
     *  Getters y Setters
     *************************************************/
	
	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}
	
		
    /*************************************************
     *  Methods
     *************************************************/
    
	public String doInput() {
    	
    	if (!isSessionActive()) return Action.LOGIN;
    	
    	cliente = (Persona)session.get(CLIENTE_LOGUEADO);
    	
    	cliente = clienteService.findPuntosCliente(cliente.getId());
    	
    	return Action.INPUT;
    }


    /*************************************************
     *  Common
     *************************************************/
    protected void addCommonResources() {
    	//addScript("login.js");
    }

    
}
