package com.inmobiliaria.action.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.inmobiliaria.model.Paginador;
import com.inmobiliaria.model.Contrato;
import com.inmobiliaria.model.PreguntaAdapter;
import com.inmobiliaria.model.Respuesta;
import com.inmobiliaria.model.Util;
import com.inmobiliaria.service.PreguntaService;
import com.inmobiliaria.service.RespuestaService;
import com.opensymphony.xwork2.Action;

public class PreguntaAction extends BaseAdminAction {
    
	private static final long serialVersionUID = 8091259220973713414L;

	// Services
	
	private PreguntaService preguntaService;
	private RespuestaService respuestaService;

	// Listas
	
	private List<Contrato> preguntas = new ArrayList<Contrato>();

	// Model Principal
	
	private PreguntaAdapter preguntaAdapter = new PreguntaAdapter();

	private Paginador paginador = new Paginador();

	boolean finRespuestas = false;
	
	
	public PreguntaAction(PreguntaService preguntaService, RespuestaService respuestaService) {
    	
		// Seteamos los services
    	
		this.preguntaService = preguntaService;
    	this.respuestaService = respuestaService;
    }

    /*************************************************
     *  Getters y Setters
     *************************************************/

	public void setPreguntaAdapter(PreguntaAdapter preguntaAdapter) {
		this.preguntaAdapter = preguntaAdapter;
	}

	public PreguntaAdapter getPreguntaAdapter() {
		return preguntaAdapter;
	}
	
	public void setPreguntas(List<Contrato> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Contrato> getPreguntas() {
		return preguntas;
	}
	
	public Paginador getPaginador() {
		return paginador;
	}

	public void setPaginador(Paginador paginador) {
		this.paginador = paginador;
	}


    /*************************************************
     *  Methods
     *************************************************/
    public String doList() {
    	if (!isSessionActive()) return Action.LOGIN;
        this.setRetorno(ACTION_MENU);
    	// Paginar
    	if (this.paginador.getTotalRegistros() == 0) {
    		this.paginador.setNumeroPagina(1);
    		this.paginador.setTamanoPagina(PAGINADOR_TAMANO_PAGINA);
    		this.paginador.setTotalRegistros(preguntaService.countPreguntas());
    	} else {
    		if (Paginador.ACCION_PAGINA_ANTERIOR.equals(this.paginador.getAccion())) {
    			this.paginador.setNumeroPagina(this.paginador.getNumeroPagina()-1);
    		} else if (Paginador.ACCION_PAGINA_SIGUIENTE.equals(this.paginador.getAccion())) {
    			this.paginador.setNumeroPagina(this.paginador.getNumeroPagina()+1);
    		}
    	}
    	this.preguntas = preguntaService.findPreguntas(this.paginador.getNumeroPagina(), this.paginador.getTamanoPagina());
    	return Action.INPUT;
    }

    
    public String doInput() {
    	if (!isSessionActive()) return Action.LOGIN;
    	this.setRetorno(ACTION_PREGUNTAS);
    	if (this.preguntaAdapter.getPregunta().getId() > 0){
    		this.preguntaAdapter.setPregunta( preguntaService.find(this.preguntaAdapter.getPregunta().getId()));
//    		for (Iterator<Respuesta> iterator = this.preguntaAdapter.getPregunta().getRespuestas().iterator(); iterator.hasNext();) {
//    			Respuesta r = (Respuesta)iterator.next();
//    			buscaRespuestas(r);
//    		}
    		// Seteo fechas
//    		this.preguntaAdapter.setFechaPublicacion(Util.getStringFromDate(this.preguntaAdapter.getPregunta().getFechaPublicacion()));
//    		this.preguntaAdapter.setFechaFinPublicacion(Util.getStringFromDate(this.preguntaAdapter.getPregunta().getFechaFinPublicacion()));
    	} else {	
    		this.preguntaAdapter.setPregunta(new Contrato());
    	}
    	return Action.INPUT;
    }
    
	public void validateDoSave() {
		this.setSubmitted(true);
    	this.setRetorno(ACTION_PREGUNTAS);
    	ValidatePregunta(this.preguntaAdapter);
	}
	
	public String doSave() {
    	if (!isSessionActive()) return Action.LOGIN;
    	
    	Respuesta respCorrecta= new Respuesta();
    	Respuesta respIncorr1= new Respuesta();
    	Respuesta respIncorr2 = new Respuesta();
    	
    	if (!isSessionActive()) return Action.LOGIN;

    	if (this.preguntaAdapter.getPregunta().getId() > 0) {
    		Contrato preg=preguntaService.find(preguntaAdapter.getPregunta().getId());
//    		List<Respuesta> respuestas = preg.getRespuestas();
//    		for (Iterator<Respuesta> iterator = respuestas.iterator(); iterator.hasNext();) {
//				Respuesta r = (Respuesta)iterator.next();
//				respuestaService.remove(r.getId());
//			}
    		this.setMensaje("Pregunta actualizada correctamente.");
    	} else {
    		this.setMensaje("Pregunta insertada correctamente");
    	}
    	preguntaService.save(this.preguntaAdapter.getPregunta());
    	
    	//graba las respuestas
    	respCorrecta.setDescripcion(this.preguntaAdapter.getRespCorrecta());
        respCorrecta.setPregunta(this.preguntaAdapter.getPregunta());
        respCorrecta.setEsCorrecta(true);
        
        respIncorr1.setDescripcion(this.preguntaAdapter.getRespuestaIncorrecta1());
        respIncorr1.setPregunta(this.preguntaAdapter.getPregunta());
        respIncorr1.setEsCorrecta(false);
       
        respIncorr2.setDescripcion(this.preguntaAdapter.getRespuestaIncorrecta2());
        respIncorr2.setPregunta(this.preguntaAdapter.getPregunta());
        respIncorr2.setEsCorrecta(false);
        
    	respuestaService.save(respCorrecta);
    	respuestaService.save(respIncorr1);
    	respuestaService.save(respIncorr2);
    
    	this.setRetorno(ACTION_PREGUNTAS);
    	
    	return Action.SUCCESS;
	}

    public void validateDoDelete() {
    	this.setSubmitted(true);
    	this.setRetorno(ACTION_PREGUNTAS);
    	boolean preguntaUsada;
    	
    	preguntaUsada=preguntaService.isPreguntaUsada(this.preguntaAdapter.getPregunta().getId());
    	if(preguntaUsada){
    		this.addFieldError("pregunta.eliminar", getText("admin.preguntas.eliminar.imposibleEliminar"));
    		doList();
    	}
    }
    
    public String doDelete() {
    	if (!isSessionActive()) return Action.LOGIN;
    	Contrato preg= preguntaService.find(this.preguntaAdapter.getPregunta().getId());
//    	List<Respuesta> respuestas = preg.getRespuestas();
//		
//		for (Iterator<Respuesta> iterator = respuestas.iterator(); iterator.hasNext();) {
//			Respuesta r = (Respuesta)iterator.next();
//			respuestaService.remove(r.getId());
//		}
    	preguntaService.remove(preg.getId());
    	this.setMensaje("Pregunta eliminada correctamente.");
    	doList();
    	this.setRetorno(ACTION_PREGUNTAS);
    	return Action.SUCCESS;
    }
    
    
    /*************************************************
     *  Common
     *************************************************/
    protected void addCommonResources() {
    	addScript("/admin/preguntas.js");
       	
    	addScript("/admin/jquery-1.4.2.js");
    	addScript("/admin/jquery.ui.core.js");
    	addScript("/admin/jquery.ui.datepicker.js");
    	addScript("/admin/jquery-ui-1.8.1.custom.js");

    	addStylesheet("css/jquery-ui-1.8.1.custom.css");
    	addStylesheet("css/jquery.ui.theme.css");
    	addStylesheet("css/jquery.ui.datepicker.css");
    	addStylesheet("css/jquery.ui.core.css");

    }
    
    private void buscaRespuestas(Respuesta r) {
		if (r.getEsCorrecta()) {
			this.preguntaAdapter.setRespCorrecta(respuestaService.find(r.getId()).getDescripcion());
		} else {
			if (finRespuestas == false) {
				this.preguntaAdapter.setRespuestaIncorrecta1(respuestaService.find(r.getId()).getDescripcion());
				finRespuestas = true;
			} else {
				if (finRespuestas == true) {
					this.preguntaAdapter.setRespuestaIncorrecta2(respuestaService.find(r.getId()).getDescripcion());
					finRespuestas = false;
				}
			}
		}
	}
    private void ValidatePregunta(PreguntaAdapter preguntaAdapter) {
		boolean pregInvalida;
//		int puntos = this.preguntaAdapter.getPregunta().getPuntos();
//		
//		if (Util.isStringNullOrEmpty(preguntaAdapter.getPregunta().getDescripcion())) {
//    		this.addFieldError("pregunta.descripcion", getText("admin.pregunta.descripcion.missing"));
//    	}
    	if(Util.isStringNullOrEmpty(preguntaAdapter.getRespCorrecta())) {
    		this.addFieldError("pregunta.respCorrecta", getText("admin.pregunta.respCorrecta.missing"));
    	}
    	if(Util.isStringNullOrEmpty(preguntaAdapter.getRespuestaIncorrecta1())
    			&& Util.isStringNullOrEmpty(preguntaAdapter.getRespuestaIncorrecta2())){
    			this.addFieldError("pregunta.respIncorrectas", getText("admin.pregunta.respIncorrectas.missing"));
    	}
    	
    	// Valida fechas ingresado
		Date fechaPub = null;
		Date fechaFinPub = null;
		
//		if (Util.isDate(this.preguntaAdapter.getFechaPublicacion())) {
//			fechaPub = Util.getDateFromString(this.preguntaAdapter.getFechaPublicacion());
//			this.preguntaAdapter.getPregunta().setFechaPublicacion(fechaPub);
//			this.preguntaAdapter.setFechaPublicacion(Util.getStringFromDate(fechaPub));
//			
//		} 
//		if (Util.isDate(this.preguntaAdapter.getFechaFinPublicacion())) {
//			fechaFinPub = Util.getDateFromString(this.preguntaAdapter.getFechaFinPublicacion());
//			this.preguntaAdapter.getPregunta().setFechaFinPublicacion(fechaFinPub);
//			this.preguntaAdapter.setFechaFinPublicacion(Util.getStringFromDate(fechaFinPub));
//		}
//		
//		System.out.println("GHG:" + fechaPub);
//		System.out.println("GHG:" + fechaFinPub);
//    	
//    	Date fechaActual = new Date();
//    	
//    	if (fechaPub == null) {
//    		this.addFieldError("pregunta.fechaPublicacion", getText("admin.pregunta.fechaPublicacion.missing"));
//    		this.preguntaAdapter.getPregunta().setFechaPublicacion(new Date());
//    	} else if(Util.compareOnlyDates(fechaActual, fechaPub) > 0) {
//        	this.addFieldError("pregunta.fechaPublicacion", getText("admin.pregunta.fechaPublicacion.wrong"));
//    	}
//    	if (fechaFinPub == null) {
//    		this.addFieldError("pregunta.fechaFinPublicacion", getText("admin.pregunta.fechaFinPublicacion.missing"));
//    		this.preguntaAdapter.getPregunta().setFechaFinPublicacion(new Date());
//    	} else if(Util.compareOnlyDates(fechaActual, fechaFinPub) > 0) {
//    		this.addFieldError("pregunta.fechaFinPublicacion", getText("admin.pregunta.fechaFinPublicacion.wrong"));
//    	}
//
//    	if (fechaPub != null && fechaFinPub != null && (Util.compareOnlyDates(fechaPub, fechaFinPub) > 0) ) {
//    		this.addFieldError("pregunta.fechaFinPublicacion", getText("admin.pregunta.rangoFechas.wrong"));
//    	}
//    	
//    	if (fechaPub != null && fechaFinPub != null) {
//	    	if (this.preguntaAdapter.getPregunta().getId()!=0) {
//	    		// update
//	    		pregInvalida = this.preguntaService.validaRangoFechasModificacion(this.preguntaAdapter.getPregunta().getId(), puntos, fechaPub, fechaFinPub);
//	    	} else {
//	    		//new
//	    		pregInvalida = this.preguntaService.validaRangoFechas(puntos, fechaPub, fechaFinPub);
//	        }
//			if (pregInvalida == false)
//				this.addFieldError("pregunta.rangoFechas", getText("admin.pregunta.rangoFechas.fechaInvalida"));
//    	}
    	
    }


    
}
