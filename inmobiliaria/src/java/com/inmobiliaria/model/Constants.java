package com.inmobiliaria.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Constants {

	static Map<Integer, String> dni;

	static {

		Map<Integer, String> dniTypesMap = new HashMap<Integer, String>();
		dniTypesMap.put(1, "DNI");
		dniTypesMap.put(2, "LC");

		dni = Collections.unmodifiableMap(dniTypesMap);

	}

	public static Map<Integer, String> getDni() {
		return dni;
	}

	public static void setDni(Map<Integer, String> dni) {
		Constants.dni = dni;
	}

}