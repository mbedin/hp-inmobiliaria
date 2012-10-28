package com.inmobiliaria.action.admin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.inmobiliaria.model.Localidad;
import com.inmobiliaria.model.Paginador;
import com.inmobiliaria.model.Persona;
import com.inmobiliaria.model.Propiedad;
import com.inmobiliaria.model.PropiedadAdapter;
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
		this.setPropiedadService(propiedadesService);

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
		this.setRetorno(ACTION_PROPIEDADES);

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

	private void fillPropietarioInfo(PropietarioAdapter propietarioAdapter2) {

	}

	public String doInputAlta() {

		if (!isSessionActive())
			return Action.LOGIN;

		this.setRetorno(ACTION_PROPIEDADES);

		// this.setLocalidades(localidadService.findAll());

		// this.propiedadAdapter.setPropiedad((new Propiedad()));

		return Action.INPUT;
	}

	public void validateDoSaveAlta() {

		this.setSubmitted(true);

		// ValidatePartido(this.propiedadAdapter);

		if (this.hasFieldErrors()) {

			// ReplaceNullValues(this.propiedadAdapter.getPropiedad());

		}
		this.setRetorno(ACTION_PROPIEDADES);
	}

	public String doSaveAlta() {

		if (!isSessionActive())
			return Action.LOGIN;

		this.setMensaje("partido cargado correctamente");

		// this.propiedadAdapter.getPropiedad().setGrupo(null);
		// this.propiedadAdapter.getPropiedad().setPermiteCarga(true);

		// propiedadServicee.save(this.propiedadAdapter.getPropiedad());

		this.setRetorno(ACTION_PROPIEDADES);

		this.setMensaje("partido cargado correctamente");

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

	private void ValidatePartido(PropiedadAdapter propiedadAdapter) {

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

	}

	private void ReplaceNullValues(Propiedad propiedad) {

		if (propiedad.getLocalidad() == null)
			propiedad.setLocalidad(new Localidad());

		if (propiedad.getPropietario() == null)
			propiedad.setPropietario(new Persona());

	}

	private InputStream getExcelTarjetasConPremio() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			// this.tarjetas =
			// tarjetaService.findTarjetasConPremioEnPartido(this.propiedadAdapter.getPropiedad().getId());

			HSSFWorkbook libro = new HSSFWorkbook();
			HSSFSheet hoja = libro.createSheet();

			InsertarEncabezado(hoja);

			// for (Iterator<Tarjeta> iterator = this.tarjetas.iterator();
			// iterator
			// .hasNext();) {
			// Tarjeta tarjeta = (Tarjeta) iterator.next();
			// InsertarTarjeta(hoja, tarjeta);
			// }

			libro.write(bos);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ByteArrayInputStream(bos.toByteArray());

	}

	private void InsertarEncabezado(HSSFSheet hoja) {

		int i = 0;
		HSSFRow fila = hoja.createRow(0);
		HSSFCell celda = fila.createCell(i++);
		HSSFRichTextString texto = new HSSFRichTextString(
				getText("admin.tarjeta.id"));
		celda.setCellValue(texto);

		celda = fila.createCell(i++);
		texto = new HSSFRichTextString(getText("admin.cliente.nombre"));
		celda.setCellValue(texto);

		celda = fila.createCell(i++);
		texto = new HSSFRichTextString(getText("admin.cliente.mail"));
		celda.setCellValue(texto);

	}

}
