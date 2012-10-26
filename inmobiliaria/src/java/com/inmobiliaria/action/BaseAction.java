package com.inmobiliaria.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.LocaleProvider;





public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletContextAware, LocaleProvider {

	private static final long serialVersionUID = -8128290267123694961L;
	private ArrayList <String> stylesheets = new ArrayList<String>();
	private ArrayList<String> scripts = new ArrayList<String>();
	protected Map session;
	protected HttpServletRequest request;
	protected String SESSION_ID = "";
	protected String BASE_URL = "/prodeMundial";
	protected ServletContext context;
	protected String ROOT_PATH = "";
	protected Locale userLocale;
	
	
	
	// Properties
	private Boolean submitted = false;
	protected String jsonData = "";
	private String retorno = "";
	private String mensaje = "";
	
	
    public BaseAction() {
    	
    	
    	
    	
    	
    }

    
	/*************************************************
     *  Getters y Setters
     *************************************************/
    
	public boolean isSubmitted() {
		return submitted;
	}
	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

	public ArrayList<String> getScripts() {
		return scripts;
	}
	public void setScripts(ArrayList<String> scripts) {
		this.scripts = scripts;
	}
	
	public ArrayList<String> getStylesheets() {
		return stylesheets;
	}
	public void setStylesheets(ArrayList<String> stylesheets) {
		this.stylesheets = stylesheets;
	}
	
	public Date getCurrentDate() {
		Calendar today = Calendar.getInstance();
        return new Date(today.getTimeInMillis());
    }
	
	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public Locale getUserLocale() {
		return getLocale();
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	/*************************************************
     *  Common
     *************************************************/
    protected final void addStylesheet(final String stylesheet) {
    	stylesheets.add(stylesheet);
    }

    protected void addScript(String script, Integer index ) {
    	scripts.add(index, getScriptPath(script) );
    }
    
    protected String getScriptPath( String script ) {
    	// -- En caso que se quiera cargar un JS externo (Google Maps por ejemplo)...
    	if ( !script.startsWith("http://") ) {
    		// TODO script = getContextPath() + "/js/" + script;
    		script = "js/" + script;
    	}
    	return script;
   	}

    protected String getContextPath() {
    	return BASE_URL;
    }
    
   
    protected void addScript(String script) {
    	scripts.add( getScriptPath(script) );
    }
    
    public void setServletContext(ServletContext arg0) {
    	context = arg0;
    	ROOT_PATH = context.getRealPath("/");
    }

    public void setServletRequest(HttpServletRequest arg0) {

    	request = arg0;
    	SESSION_ID = request.getSession().getId();

    	// -- URL base de la aplicacin.
    	String requestURL = request.getContextPath();
    	BASE_URL = requestURL;


   	}
    
    public void setSession(Map map) {

    	this.session = map;

    	this.addCommonResources();

   		this.addStylesheet("css/style.css");

    }
    
    protected void addCommonResources() {

    }

	protected void addLanguageResources() {

	}

	
}
