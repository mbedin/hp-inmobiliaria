package com.inmobiliaria.action.admin;

import com.inmobiliaria.model.Localidad;
import com.inmobiliaria.model.Paginador;
import com.inmobiliaria.model.Persona;
import com.inmobiliaria.model.Propiedad;
import com.inmobiliaria.model.PropietarioAdapter;
import com.inmobiliaria.service.PersonaService;
import com.inmobiliaria.service.PropiedadesService;
import com.opensymphony.xwork2.Action;

public class PropietarioAction extends BaseAdminAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8091259220973713414L;

	// Services
	private PersonaService personaService;
	private PropiedadesService propiedadService;

	// Model Principal
	private Persona propietario = new Persona();
	private Propiedad propiedad = new Propiedad();
	private PropietarioAdapter propietarioAdapter = new PropietarioAdapter();
	private Paginador paginador = new Paginador();

	// Listas

	public PropietarioAction(PersonaService personaService,
			PropiedadesService propiedadesService) {

		// Seteamos los services
		this.personaService = personaService;
		this.propiedadService = propiedadesService;

	}

	/*************************************************
	 * Getters y Setters
	 *************************************************/

	public Paginador getPaginador() {
		return paginador;
	}

	public void setPaginador(Paginador paginador) {
		this.paginador = paginador;
	}

	public PropietarioAdapter getPropietarioAdapter() {
		return propietarioAdapter;
	}

	public void setPropietarioAdapter(PropietarioAdapter propietarioAdapter) {
		this.propietarioAdapter = propietarioAdapter;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public PersonaService getPersonaService() {
		return personaService;
	}

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}

	public PropiedadesService getPropiedadService() {
		return propiedadService;
	}

	public void setPropiedadService(PropiedadesService propiedadService) {
		this.propiedadService = propiedadService;
	}

	/*************************************************
	 * Methods
	 *************************************************/

	public String doInput() {
		if (!isSessionActive())
			return Action.LOGIN;
		this.setRetorno(ACTION_PROPIETARIOS);

		this.propiedad = (Propiedad) session.get(NUEVA_PROPIEDAD);

		if (this.propiedad != null) {
			// viene desde abm propiedades
			this.propietarioAdapter.setPropiedad(this.propiedad);

		} else {
			// viene desde abm propietario
			this.propietarioAdapter.setPropiedad((new Propiedad()));
		}

		return Action.INPUT;

	}

	public void validateDoSave() {
		// validaciones para campos del abm propietario
		this.setSubmitted(true);
		this.setRetorno(ACTION_PROPIEDADES);

		validatePropietario(this.propietarioAdapter);

		this.clearFieldErrors();
		if (this.hasFieldErrors()) {
			ReplaceNullValues(this.propietarioAdapter.getPropiedad());
		}
	}

	public String doSave() {
		if (!isSessionActive())
			return Action.LOGIN;

		if (this.propietarioAdapter.getPropiedad() != null) {
			fillPropietarioInfo(this.propietarioAdapter);
		} else {

		}

		this.setMensaje("propiedad cargado correctamente");

		this.setRetorno(ACTION_PROPIEDADES);
		return Action.SUCCESS;
	}

	public String doInputAlta() {

		// viene desde menu principal
		if (!isSessionActive())
			return Action.LOGIN;

		this.setRetorno(ACTION_MENU);

		return Action.INPUT;

	}

	public void validateDoSaveAlta() {

		this.setSubmitted(true);

		validatePropietario(propietarioAdapter);

		if (this.hasFieldErrors()) {
			ReplaceNullValues(this.propietarioAdapter.getPropiedad());

		}

		this.setRetorno(ACTION_PROPIETARIOS);

	}

	public String doSaveAlta() {

		if (!isSessionActive())
			return Action.LOGIN;

		personaService.save(propietario);

		this.setRetorno(ACTION_PROPIEDADES);

		this.setMensaje("propietario cargado correctamente");

		return Action.SUCCESS;
	
	}

	/*************************************************
	 * Common
	 *************************************************/
	protected void addCommonResources() {
		addScript("/admin/propiedad.js");

		addScript("/admin/jquery-1.4.2.js");
		addScript("/admin/jquery.ui.core.js");
		addScript("/admin/jquery.ui.datepicker.js");
		addScript("/admin/jquery-ui-1.8.1.custom.js");

		addStylesheet("css/jquery-ui-1.8.1.custom.css");
		addStylesheet("css/jquery.ui.theme.css");
		addStylesheet("css/jquery.ui.datepicker.css");
		addStylesheet("css/jquery.ui.core.css");

	}

	private void fillPropietarioInfo(PropietarioAdapter propietarioAdapter) {

	}

	private void validatePropietario(PropietarioAdapter propietarioAdapter) {

	}

	// private void ValidatePartido(PropiedadAdapter propiedadAdapter) {

	// valida equipos ingresados

	// if (this.propiedadAdapter.getPropiedad().getEquipoLocal().getId() ==
	// this.propiedadAdapter
	// .getPropiedad().getEquipoVisitante().getId()) {
	// this.addFieldError("partido.equipos",
	// getText("admin.partido.equipos.wrong"));
	// }

	// Valida fecha y hora ingresada

	// Date fechaP = null;
	// Time horaP = null;

	// if (Util.isDate(this.propiedadAdapter.getFechaPartido())) {
	// fechaP = Util.getDateFromString(this.propiedadAdapter
	// .getFechaPartido());
	// this.propiedadAdapter.getPropiedad().setFecha(fechaP);
	// }
	//
	// if (Util.isTime(this.propiedadAdapter.getHoraPartido())) {
	// horaP = Util.getTimeFromString(this.propiedadAdapter
	// .getHoraPartido());
	// this.propiedadAdapter.getPropiedad().setHora((horaP));
	// } else {
	// this.addFieldError("partido.horaPartido",
	// getText("admin.partido.fechaPartido.missing"));
	// }
	//
	// Date fechaActual = new Date();
	//
	// if (fechaP == null) {
	// this.addFieldError("partido.fechaPartido",
	// getText("admin.partido.fechaPartido.missing"));
	// this.propiedadAdapter.getPropiedad().setFecha(new Date());
	// } else if (Util.compareOnlyDates(fechaActual, fechaP) > 0) {
	// this.addFieldError("partido.fechaPartido",
	// getText("admin.partido.fechaPartido.wrong"));
	// }
	// if (horaP == null) {
	// this.addFieldError("partido.horaPartido",
	// getText("admin.partido.horaPartido.missing"));
	// this.propiedadAdapter.getPropiedad().setHora(new Time(0));
	// }

	// }

	private void ReplaceNullValues(Propiedad propiedad) {

		if (propiedad.getLocalidad() == null)
			propiedad.setLocalidad(new Localidad());

		if (propiedad.getPropietario() == null)
			propiedad.setPropietario(new Persona());

	}

}
