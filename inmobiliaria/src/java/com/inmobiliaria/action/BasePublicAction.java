package com.inmobiliaria.action;

import java.util.Map;

import com.inmobiliaria.model.Persona;
import com.inmobiliaria.model.Usuario;
import com.opensymphony.xwork2.ActionContext;

public class BasePublicAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5687908226844002131L;


	// Constantes para variables de session.
	protected String CLIENTE_LOGUEADO = "cliente_logueado";


	// Constante para nombres Action 
	protected String ACTION_PRINCIPAL = "principal";
	protected String ACTION_TARJETAS_POR_JUGAR = "tarjetasPorJugar";
	protected String ACTION_TARJETAS_JUGADAS = "tarjetasJugadas";
	protected String ACTION_TRIVIA = "puntosBonus";
	protected String ACTION_TRIVIA_JUGADA = "triviaJugada";
	protected String ACTION_TRIVIA_SIN_PREGUNTA = "sinPregunta";
	protected String ACTION_RESPUESTA_INCORRECTA = "respuestaIncorrecta";
	protected String ACTION_CLIENTE_ELIMINADO = "clienteEliminado";
	
	protected String SUFIJO_PRODUCTOR = "Ptr";
	
	// Properties
	private Persona cliente = new Persona();
	
    
    public Persona getCliente() {
        return cliente;
    }
    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }
    
	// Methods
    public void setSession(Map map) {

    	this.session = map;

    	this.addCommonResources();

   		this.addStylesheet("css/style.css");
   		
   		this.addScript("public.js");

   		if (isSessionActive()) {
   			this.cliente = (Persona)session.get(CLIENTE_LOGUEADO);
   		}
    }

    protected boolean isSessionActive() {
    	// Si existe, obtener cliente logueado
    	Map session = ActionContext.getContext().getSession();
    	if (session.get(CLIENTE_LOGUEADO)==null) {
    		return false;
    	}
    	return true;
    }
    
    
}
