package com.inmobiliaria.action;

import java.io.File;
import java.text.MessageFormat;

import com.inmobiliaria.model.Persona;
import com.inmobiliaria.model.PasswordAdapter;
import com.inmobiliaria.model.PasswordGenerator;
import com.inmobiliaria.model.Util;
import com.inmobiliaria.service.ClienteService;
import com.inmobiliaria.service.MailService;
import com.opensymphony.xwork2.Action;

public class PasswordAction extends BasePublicAction {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2514975465946565810L;
	
	// Services
	private ClienteService clienteService;
	private MailService mailService;
	
    // Model Principal
	private PasswordAdapter passwordAdapter = new PasswordAdapter();

	public PasswordAction(ClienteService clienteService, MailService mailService) {
		
		this.setCliente(new Persona());
		
		// Seteamos los services
    	this.clienteService = clienteService;
    	this.mailService = mailService;
        
    }

    /*************************************************
     *  Getters y Setters
     *************************************************/
	
	public PasswordAdapter getPasswordAdapter() {
		return passwordAdapter;
	}

	
	public void setPasswordAdapter(PasswordAdapter passwordAdapter) {
		this.passwordAdapter = passwordAdapter;
	}


    /*************************************************
     *  Methods
     *************************************************/
    
	public String doInput() {

    	this.setRetorno(ACTION_PRINCIPAL);

		this.passwordAdapter = new PasswordAdapter();
		
        return Action.INPUT;
        
    }

    public void validateDoCambiarPassword(){
    	
    	this.setRetorno(ACTION_PRINCIPAL);

    	this.setSubmitted(true);

		if (Util.isStringNullOrEmpty(this.getPasswordAdapter().getCliente().getUsuario()) ||
				Util.isStringNullOrEmpty(this.getPasswordAdapter().getCliente().getPassword()) ||
				Util.isStringNullOrEmpty(this.getPasswordAdapter().getPassword()) ||
				Util.isStringNullOrEmpty(this.getPasswordAdapter().getRepeticion()) ) {
 			this.addFieldError("cambioPassword.error", getText("cambioPassword.error.missing"));
		}
		
		if (!Util.isStringNullOrEmpty(this.getPasswordAdapter().getPassword()) && 
				!Util.isStringNullOrEmpty(this.getPasswordAdapter().getRepeticion()) ) {
			if (!this.getPasswordAdapter().getPassword().equals(this.getPasswordAdapter().getRepeticion())) {
				this.addFieldError("cambioPassword.error", getText("cambioPassword.error.missing"));
			}
		}

    }
    
	public String doCambiarPassword() {
		this.setRetorno(ACTION_PRINCIPAL);
		
		String password = Util.encriptar(this.passwordAdapter.getCliente().getPassword());  
		Persona cliente = clienteService.login(this.passwordAdapter.getCliente().getUsuario(), password);
		
		if (cliente == null) {
			this.addFieldError("cambioPassword.error", getText("cambioPassword.error.missing"));
			return Action.INPUT;
		}
		
		password = this.passwordAdapter.getPassword();  
		password = Util.encriptar(password);
		
		cliente.setPassword(password);
		this.clienteService.save(cliente);
		
		this.setMensaje(getText("cambioPassword.ok"));
		this.setRetorno(ACTION_PRINCIPAL);
		
		return Action.SUCCESS;

    }
  
	public String doReseteo() {

		this.setRetorno(Action.LOGIN);

		this.passwordAdapter = new PasswordAdapter();
		
		return Action.INPUT;
        
	}
	 
	public void validateDoResetearPassword(){
		
		this.setSubmitted(true);
		this.setRetorno(Action.LOGIN);
		
		if (Util.isStringNullOrEmpty(this.passwordAdapter.getCliente().getUsuario()) ) {
			this.addFieldError("reseteoPassword.error", getText("reseteoPassword.error.missing"));
		}

    }
	    
	
	public String doResetearPassword() {
		
		this.setRetorno(Action.LOGIN);
		
		Persona cliente = clienteService.findClienteByUsuario(this.passwordAdapter.getCliente().getUsuario());
		
		if (cliente == null) {
			this.addFieldError("reseteoPassword.error", getText("reseteoPassword.error.missing"));
			return Action.INPUT;
		}
		String password = PasswordGenerator.getPassword(PasswordGenerator.MAYUSCULAS + PasswordGenerator.NUMEROS, 6);  
		cliente.setPassword(Util.encriptar(password));
		
		this.clienteService.save(cliente);
		
		try {
			String texto = MessageFormat.format(getText("reseteoPassword.mensaje"), new Object[] { cliente.getNombreYApellido(), password });
			mailService.sendNewPassword(cliente.getEMail(), getText("reseteoPassword.asunto"), texto, new File (this.context.getRealPath("/img/bg_mail.jpg")));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		this.setMensaje(getText("reseteoPassword.ok"));
		this.setRetorno(Action.LOGIN);

		return Action.SUCCESS;

    }
	 
	
    /*************************************************
     *  Common
     *************************************************/
    protected void addCommonResources() {
    	addScript("password.js");
    }
    

}
