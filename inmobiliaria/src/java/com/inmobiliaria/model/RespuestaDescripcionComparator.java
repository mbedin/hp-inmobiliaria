package com.inmobiliaria.model;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class RespuestaDescripcionComparator implements Comparator {

	public int compare(Object o1, Object o2) {
	        Respuesta respuesta1 = (Respuesta)o1;
	        Respuesta respuesta2 = (Respuesta)o2;
	        return respuesta1.getDescripcion().
	                compareTo(respuesta2.getDescripcion());

	    }
	} 