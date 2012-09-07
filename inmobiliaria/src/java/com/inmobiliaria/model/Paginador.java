package com.inmobiliaria.model;

public class Paginador {

	public static String ACCION_PAGINA_ANTERIOR = "anterior";
	public static String ACCION_PAGINA_SIGUIENTE = "siguiente";
	public static int TAMANO_PAGINA = 15;
	
	private int numeroPagina = 1;
	private int tamanoPagina = 0;
	private int totalRegistros = 0;
	private String accion = "";

	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public int getTotalRegistros() {
		return totalRegistros;
	}
	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	
	public int getNumeroPagina() {
		return numeroPagina;
	}
	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
	public int getTamanoPagina() {
		return tamanoPagina;
	}
	public void setTamanoPagina(int tamanoPagina) {
		this.tamanoPagina = tamanoPagina;
	}

	public int getTotalPaginas() {
		int totalPaginas = 1;
		if (tamanoPagina > 0) {
			totalPaginas = (totalRegistros / tamanoPagina) + 1;
		}
		return totalPaginas;
	}
	
	public boolean isTieneSiguiente() {
		return (numeroPagina < getTotalPaginas());
	}

	public boolean isTieneAnterior() {
		return (numeroPagina > 1);
	}

	public int getRegistroDesde() {
		return ((numeroPagina - 1) * tamanoPagina) + 1;
	}
	
	public int getRegistroHasta() {
		int registroHasta = ((numeroPagina - 1) * tamanoPagina) + tamanoPagina;
		if (registroHasta > totalRegistros)
			registroHasta = totalRegistros;
		return registroHasta ;
	}
	
}
