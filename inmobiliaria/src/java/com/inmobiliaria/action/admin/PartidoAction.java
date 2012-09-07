package com.inmobiliaria.action.admin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.inmobiliaria.model.Cita;
import com.inmobiliaria.model.Constants;
import com.inmobiliaria.model.Localidad;
import com.inmobiliaria.model.Paginador;
import com.inmobiliaria.model.Partido;
import com.inmobiliaria.model.PartidoAdapter;
import com.inmobiliaria.model.Persona;
import com.inmobiliaria.model.PronosticoPartido;
import com.inmobiliaria.model.Propiedad;
import com.inmobiliaria.model.Sede;
import com.inmobiliaria.model.Tarjeta;
import com.inmobiliaria.model.Util;
import com.inmobiliaria.service.EquipoService;
import com.inmobiliaria.service.FaseService;
import com.inmobiliaria.service.PartidoService;
import com.inmobiliaria.service.PronosticoPartidoService;
import com.inmobiliaria.service.SedeService;
import com.opensymphony.xwork2.Action;

public class PartidoAction extends BaseAdminAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8091259220973713414L;

	// Services
	private PartidoService partidoService;
	private EquipoService equipoService;
	private SedeService sedeService;
	private FaseService faseService;
	private PronosticoPartidoService pronosticoPartidoService;

	// Model Principal
	private Persona cliente = new Persona();
	private Partido partido = new Partido();
	private InputStream excelStream;
	private PartidoAdapter partidoAdapter = new PartidoAdapter();
	private Paginador paginador = new Paginador();

	// Listas
	private List<Partido> partidos = new ArrayList<Partido>();
	private List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
	private List<Propiedad> equipos = new ArrayList<Propiedad>();
	private List<Sede> sedes = new ArrayList<Sede>();
	private List<Cita> fases = new ArrayList<Cita>();
	private List<PronosticoPartido> pronosticosPartidos = new ArrayList<PronosticoPartido>();

	public PartidoAction(PartidoService partidoService,
			EquipoService equipoService, SedeService sedeService,
			FaseService faseService,
			PronosticoPartidoService pronosticoPartidoService) {

		// Seteamos los services
		this.partidoService = partidoService;
		this.equipoService = equipoService;
		this.sedeService = sedeService;
		this.faseService = faseService;
		this.pronosticoPartidoService = pronosticoPartidoService;

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

	public void setPartidoService(PartidoService partidoService) {
		this.partidoService = partidoService;
	}

	public PartidoService getPartidoService() {
		return partidoService;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public PartidoAdapter getPartidoAdapter() {
		return partidoAdapter;
	}

	public void setPartidoAdapter(PartidoAdapter partidoAdapter) {
		this.partidoAdapter = partidoAdapter;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public EquipoService getEquipoService() {
		return equipoService;
	}

	public void setEquipoService(EquipoService equipoService) {
		this.equipoService = equipoService;
	}

	public List<Propiedad> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Propiedad> equipos) {
		this.equipos = equipos;
	}

	public void setSedes(List<Sede> sedes) {
		this.sedes = sedes;
	}

	public List<Sede> getSedes() {
		return sedes;
	}

	public void setFases(List<Cita> fases) {
		this.fases = fases;
	}

	public List<Cita> getFases() {
		return fases;
	}

	public void setSedeService(SedeService sedeService) {
		this.sedeService = sedeService;
	}

	public SedeService getSedeService() {
		return sedeService;
	}

	public void setFaseService(FaseService faseService) {
		this.faseService = faseService;
	}

	public FaseService getFaseService() {
		return faseService;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setPronosticoPartidos(List<PronosticoPartido> pronosticoPartidos) {
		this.pronosticosPartidos = pronosticoPartidos;
	}

	public List<PronosticoPartido> getPronosticoPartidos() {
		return pronosticosPartidos;
	}

	public void setPronosticoPartidoService(
			PronosticoPartidoService pronosticoPartidoService) {
		this.pronosticoPartidoService = pronosticoPartidoService;
	}

	public PronosticoPartidoService getPronosticoPartidoService() {
		return pronosticoPartidoService;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
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
			this.paginador.setTotalRegistros(partidoService.countPartidos());
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
		this.setPartidos(partidoService.findPartidos(this.paginador
				.getNumeroPagina(), this.paginador.getTamanoPagina()));
		return Action.INPUT;
	}

	public String doInput() {
		if (!isSessionActive())
			return Action.LOGIN;
		this.setRetorno(ACTION_PARTIDOS);
		if (this.partidoAdapter.getPartido().getId() > 0) {
			this.partidoAdapter.setPartido(partidoService
					.find(this.partidoAdapter.getPartido().getId()));
		} else {
			this.partidoAdapter.setPartido((new Partido()));
		}
		return Action.INPUT;
	}

	public void validateDoSave() {
		int golesL = this.partidoAdapter.getPartido().getGolesLocal();
		int golesV = this.partidoAdapter.getPartido().getGolesVisitante();
		this.partidoAdapter.setPartido(partidoService.find(this.partidoAdapter
				.getPartido().getId()));
		this.partidoAdapter.getPartido().setGolesLocal(golesL);
		this.partidoAdapter.getPartido().setGolesVisitante(golesV);

		this.setSubmitted(true);
		this.setRetorno(ACTION_PARTIDOS);

		this.clearFieldErrors();
		if (this.hasFieldErrors()) {
			ReplaceNullValues(this.partidoAdapter.getPartido());
		}
	}

	public String doSave() {
		if (!isSessionActive())
			return Action.LOGIN;

		this.setMensaje("resultado cargado correctamente");

		if (this.partidoAdapter.getPartido().getGolesLocal() > this.partidoAdapter
				.getPartido().getGolesVisitante()) {
			this.partidoAdapter.getPartido().setResultado(
					Tarjeta.RESULTADO_LOCAL);
		} else {
			if (this.partidoAdapter.getPartido().getGolesVisitante() > this.partidoAdapter
					.getPartido().getGolesLocal()) {
				this.partidoAdapter.getPartido().setResultado(
						Tarjeta.RESULTADO_VISITANTE);
			} else {
				this.partidoAdapter.getPartido().setResultado(
						Tarjeta.RESULTADO_EMPATE);
			}
		}
		partidoService.save(this.partidoAdapter.getPartido());

		this.partido = this.partidoAdapter.getPartido();

		this.pronosticosPartidos = pronosticoPartidoService
				.findPronosticosPorIdPartido(this.partidoAdapter.getPartido()
						.getId());

		for (Iterator<PronosticoPartido> iterator = pronosticosPartidos
				.iterator(); iterator.hasNext();) {
			PronosticoPartido pp = (PronosticoPartido) iterator.next();

			if (pp.getResultado().equals(this.partido.getResultado())) {
				pp.setPuntos(Constants.PUNTOS_ACIERTO_PARTIDO);
				pronosticoPartidoService.save(pp);
			}

			/**
			 * La suma de puntos por resultado acertado no se encuentra en las
			 * bases del juego. if(
			 * pp.getResultado().equals(this.partido.getResultado()) &&
			 * pp.getGolesLocal()== this.partido.getGolesLocal()&&
			 * pp.getGolesVisitante()== this.partido.getGolesVisitante()) {
			 * pp.setPuntos(Constants.PUNTOS_ACIERTO_PARTIDO +
			 * Constants.PUNTOS_ACIERTO_RESULTADO);
			 * pronosticoPartidoService.save(pp); }
			 **/

		}

		this.setRetorno(ACTION_PARTIDOS);
		return Action.SUCCESS;
	}

	public String doInputAlta() {

		if (!isSessionActive())
			return Action.LOGIN;

		this.setRetorno(ACTION_PARTIDOS);

		this.setEquipos(equipoService.findAll());
		this.setSedes(sedeService.findAll());
		this.setFases(faseService.findAll());

		this.partidoAdapter.setPartido((new Partido()));

		return Action.INPUT;
	}

	public void validateDoSaveAlta() {

		this.setSubmitted(true);

		ValidatePartido(this.partidoAdapter);

		if (this.hasFieldErrors()) {

			ReplaceNullValues(this.partidoAdapter.getPartido());
			this.equipos = equipoService.findAll();
			this.fases = faseService.findAll();
			this.sedes = sedeService.findAll();
		}
		this.setRetorno(ACTION_PARTIDOS);
	}

	public String doSaveAlta() {

		if (!isSessionActive())
			return Action.LOGIN;

		this.setMensaje("partido cargado correctamente");

		this.partidoAdapter.getPartido().setGrupo(null);
		this.partidoAdapter.getPartido().setPermiteCarga(true);
		partidoService.save(this.partidoAdapter.getPartido());

		this.setRetorno(ACTION_PARTIDOS);

		this.setMensaje("partido cargado correctamente");

		return Action.SUCCESS;
	}

	public String doListTarjetasConPremio() {
		if (!isSessionActive())
			return Action.LOGIN;
		this.setRetorno(ACTION_PARTIDOS);
		this.partidoAdapter.setPartido(partidoService.find(this.partidoAdapter
				.getPartido().getId()));
		// total=
		// tarjetaService.countTarjetasConPremio(this.partidoAdapter.getPartido().getId(),
		// this.partidoAdapter.getPartido().getGolesLocal(),
		// this.partidoAdapter.getPartido().getGolesVisitante());
		// if (total > 0) {
		// this.setTarjetas(tarjetaService.findTarjetasConPremioEnPartido(this.partidoAdapter.getPartido().getId()));
		// } else {
		// this.setMensaje("No existen Tarjetas con premio");
		// return Action.SUCCESS;
		// }
		return Action.INPUT;

	}

	public String doExcelTarjetasConPremio() {

		if (!isSessionActive())
			return Action.LOGIN;

		this.setRetorno(ACTION_MENU);

		this.excelStream = getExcelTarjetasConPremio();

		return Action.SUCCESS;
	}

	public String doSendNotificacion() {
		if (!isSessionActive())
			return Action.LOGIN;
		this.setMensaje("notificaciones enviadas correctamente");
		if (this.partidoAdapter.getPartido().getId() != 0) {
			partidoAdapter.setPartido(partidoService.find(this.partidoAdapter
					.getPartido().getId()));
			partidoAdapter.getPartido().setPremioEnviado(true);
			partidoService.save(this.partidoAdapter.getPartido());
		}
		this.setRetorno(ACTION_PARTIDOS);
		return Action.SUCCESS;
	}

	/*************************************************
	 * Common
	 *************************************************/
	protected void addCommonResources() {
		addScript("/admin/partidos.js");

		addScript("/admin/jquery-1.4.2.js");
		addScript("/admin/jquery.ui.core.js");
		addScript("/admin/jquery.ui.datepicker.js");
		addScript("/admin/jquery-ui-1.8.1.custom.js");

		addStylesheet("css/jquery-ui-1.8.1.custom.css");
		addStylesheet("css/jquery.ui.theme.css");
		addStylesheet("css/jquery.ui.datepicker.css");
		addStylesheet("css/jquery.ui.core.css");

	}

	private void ValidatePartido(PartidoAdapter partidoAdapter) {

		// valida equipos ingresados

		if (this.partidoAdapter.getPartido().getEquipoLocal().getId() == this.partidoAdapter
				.getPartido().getEquipoVisitante().getId()) {
			this.addFieldError("partido.equipos",
					getText("admin.partido.equipos.wrong"));
		}

		// Valida fecha y hora ingresada

		Date fechaP = null;
		Time horaP = null;

		if (Util.isDate(this.partidoAdapter.getFechaPartido())) {
			fechaP = Util.getDateFromString(this.partidoAdapter
					.getFechaPartido());
			this.partidoAdapter.getPartido().setFecha(fechaP);
		}

		if (Util.isTime(this.partidoAdapter.getHoraPartido())) {
			horaP = Util
					.getTimeFromString(this.partidoAdapter.getHoraPartido());
			this.partidoAdapter.getPartido().setHora((horaP));
		} else {
			this.addFieldError("partido.horaPartido",
					getText("admin.partido.fechaPartido.missing"));
		}

		Date fechaActual = new Date();

		if (fechaP == null) {
			this.addFieldError("partido.fechaPartido",
					getText("admin.partido.fechaPartido.missing"));
			this.partidoAdapter.getPartido().setFecha(new Date());
		} else if (Util.compareOnlyDates(fechaActual, fechaP) > 0) {
			this.addFieldError("partido.fechaPartido",
					getText("admin.partido.fechaPartido.wrong"));
		}
		if (horaP == null) {
			this.addFieldError("partido.horaPartido",
					getText("admin.partido.horaPartido.missing"));
			this.partidoAdapter.getPartido().setHora(new Time(0));
		}

	}

	private void ReplaceNullValues(Partido partido) {

		if (partido.getEquipoLocal() == null)
			partido.setEquipoLocal(new Propiedad());

		if (partido.getEquipoVisitante() == null)
			partido.setEquipoVisitante(new Propiedad());

		if (partido.getFase() == null)
			partido.setFase(new Cita());

		if (partido.getSede() == null)
			partido.setSede(new Sede());

		if (partido.getGrupo() == null)
			partido.setGrupo(new Localidad());
	}

	private InputStream getExcelTarjetasConPremio() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			// this.tarjetas =
			// tarjetaService.findTarjetasConPremioEnPartido(this.partidoAdapter.getPartido().getId());

			HSSFWorkbook libro = new HSSFWorkbook();
			HSSFSheet hoja = libro.createSheet();

			InsertarEncabezado(hoja);

			for (Iterator<Tarjeta> iterator = this.tarjetas.iterator(); iterator
					.hasNext();) {
				Tarjeta tarjeta = (Tarjeta) iterator.next();
				InsertarTarjeta(hoja, tarjeta);
			}

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
