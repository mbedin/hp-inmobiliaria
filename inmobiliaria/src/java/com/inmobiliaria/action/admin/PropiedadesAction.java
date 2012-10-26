package com.inmobiliaria.action.admin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.inmobiliaria.model.Tarjeta;
import com.inmobiliaria.service.LocalidadService;
import com.inmobiliaria.service.PersonaService;
import com.inmobiliaria.service.PropiedadesService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class PropiedadesAction extends BaseAdminAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8091259220973713414L;

	// Services
	private PropiedadesService propiedadServicee;
	private LocalidadService localidadService;
	private PersonaService personaServicee;

	// Model Principal
	private Persona cliente = new Persona();
	private Propiedad propiedad = new Propiedad();
	private InputStream excelStream;
	private PropiedadAdapter propiedadAdapter = new PropiedadAdapter();
	private Paginador paginador = new Paginador();

	// Listas
	private List<Propiedad> propiedades = new ArrayList<Propiedad>();
	private List<Localidad> localidades = new ArrayList<Localidad>();

	public PropiedadesAction(PropiedadesService propiedadesService,
			LocalidadService localidadService, PersonaService personaService) {

		// Seteamos los services
		this.propiedadServicee = propiedadesService;
		this.localidadService = localidadService;
		this.personaServicee = personaService;

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

	public PropiedadAdapter getPropiedadAdapter() {
		return propiedadAdapter;
	}

	public void setPropiedadAdapter(PropiedadAdapter propiedadAdapter) {
		this.propiedadAdapter = propiedadAdapter;
	}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}

	public LocalidadService getLocalidadService() {
		return localidadService;
	}

	public void setLocalidadService(LocalidadService localidadService) {
		this.localidadService = localidadService;
	}

	/*************************************************
	 * Methods
	 *************************************************/
	public String doList() {

		if (!isSessionActive())
			return Action.LOGIN;

		this.setRetorno(ACTION_MENU);

		// Paginar
		if (this.paginador.getTotalRegistros() == 0) {
			this.paginador.setNumeroPagina(1);
			this.paginador.setTamanoPagina(Paginador.TAMANO_PAGINA);
			this.paginador.setTotalRegistros(propiedadServicee
					.countPropiedades());
		} else {
			if (Paginador.ACCION_PAGINA_ANTERIOR.equals(this.paginador
					.getAccion())) {
				this.paginador
						.setNumeroPagina(this.paginador.getNumeroPagina() - 1);
			} else if (Paginador.ACCION_PAGINA_SIGUIENTE.equals(this.paginador
					.getAccion())) {
				this.paginador
						.setNumeroPagina(this.paginador.getNumeroPagina() + 1);
			}
		}
		this.setPropiedades(propiedadServicee.findPropiedades(this.paginador
				.getNumeroPagina(), this.paginador.getTamanoPagina()));
		return Action.INPUT;
	}

	public String doInput() {
		if (!isSessionActive())
			return Action.LOGIN;
		this.setRetorno(ACTION_PROPIEDADES);

		if (this.propiedadAdapter.getPropiedad().getId() > 0) {
			this.propiedadAdapter.setPropiedad(propiedadServicee
					.find(this.propiedadAdapter.getPropiedad().getId()));
		} else {
			this.propiedadAdapter.setPropiedad((new Propiedad()));
		}
		return Action.INPUT;
	}

	public void validateDoSave() {

		this.clearFieldErrors();
		if (this.hasFieldErrors()) {
			ReplaceNullValues(this.propiedadAdapter.getPropiedad());
		}
	}

	public String doSave() {
		if (!isSessionActive())
			return Action.LOGIN;

		Persona pers = this.personaServicee.findByDni(propiedadAdapter
				.getDniPropietario());

		Map session = ActionContext.getContext().getSession();
		this.setSubmitted(true);

		if (pers == null) {
			session.put(NUEVA_PROPIEDAD, propiedad);
			return ACTION_NUEVO_PROPIETARIO;

		} else {
			this.propiedadAdapter.getPropiedad().setPropietario(pers);
			propiedadServicee.save(this.propiedadAdapter.getPropiedad());
			this.setMensaje("propiedad cargado correctamente");
			this.setRetorno(ACTION_PROPIEDADES);

			return Action.SUCCESS;
		}

	}

	public String doInputAlta() {

		if (!isSessionActive())
			return Action.LOGIN;

		this.setRetorno(ACTION_PROPIEDADES);

		this.setLocalidades(localidadService.findAll());

		this.propiedadAdapter.setPropiedad((new Propiedad()));

		return Action.INPUT;
	}

	public void validateDoSaveAlta() {

		this.setSubmitted(true);

		ValidatePropiedad(this.propiedadAdapter);

		if (this.hasFieldErrors()) {

			ReplaceNullValues(this.propiedadAdapter.getPropiedad());

		}
		this.setRetorno(ACTION_PROPIEDADES);
	}

	public String doSaveAlta() {

		if (!isSessionActive())
			return Action.LOGIN;

		this.setMensaje("propiedad cargada correctamente");

		// this.propiedadAdapter.getPropiedad().setGrupo(null);
		// this.propiedadAdapter.getPropiedad().setPermiteCarga(true);
		propiedadServicee.save(this.propiedadAdapter.getPropiedad());

		this.setRetorno(ACTION_PROPIEDADES);

		return Action.SUCCESS;
	}

	public String doExcelTarjetasConPremio() {

		if (!isSessionActive())
			return Action.LOGIN;

		this.setRetorno(ACTION_MENU);

		this.setExcelStream(getExcelTarjetasConPremio());

		return Action.SUCCESS;
	}

	
	public String doSendNotificacion() {
		if (!isSessionActive())
			return Action.LOGIN;
		this.setMensaje("notificaciones enviadas correctamente");
		if (this.propiedadAdapter.getPropiedad().getId() != 0) {
			propiedadAdapter.setPropiedad(propiedadServicee
					.find(this.propiedadAdapter.getPropiedad().getId()));
			// propiedadAdapter.getPropiedad().setPremioEnviado(true);
			propiedadServicee.save(this.propiedadAdapter.getPropiedad());
		}
		this.setRetorno(ACTION_PROPIEDADES);
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

	private void ValidatePropiedad(PropiedadAdapter propiedadAdapter) {

		// valida propiedad ingresada

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

		// if (propiedad.getEquipoLocal() == null)
		// propiedad.setEquipoLocal(new Propiedad());
		//
		// if (propiedad.getEquipoVisitante() == null)
		// propiedad.setEquipoVisitante(new Propiedad());
		//
		// if (propiedad.getFase() == null)
		// propiedad.setFase(new Cita());
		//
		// if (propiedad.getSede() == null)
		// propiedad.setSede(new Sede());
		//
		// if (propiedad.getGrupo() == null)
		// propiedad.setGrupo(new Localidad());
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

	private void InsertarTarjeta(HSSFSheet hoja, Tarjeta tarjeta) {
		int i = 0;
		HSSFRow fila = hoja.createRow(hoja.getLastRowNum() + 1);
		HSSFCell celda = fila.createCell(i++);
		cliente = tarjeta.getCliente();

		celda.setCellValue(tarjeta.getId());

		celda = fila.createCell(i++);
		HSSFRichTextString texto = new HSSFRichTextString(cliente
				.getNombreYApellido());
		celda.setCellValue(texto);

		celda = fila.createCell(i++);
		texto = new HSSFRichTextString(cliente.getEMail());
		celda.setCellValue(texto);

	}

}
