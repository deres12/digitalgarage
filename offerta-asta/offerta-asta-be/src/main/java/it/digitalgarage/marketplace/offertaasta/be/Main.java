package it.digitalgarage.marketplace.offertaasta.be;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {

		Class clazz = Class.forName("it.digitalgarage.marketplace.offertaasta.be.rest.UtenteDTO");

		System.out.println(clazz.getName());
		for (Field f : clazz.getDeclaredFields()) {
			System.out.println(f.getName() + " " + f.getType());
		}

		for (Method m : clazz.getDeclaredMethods()) {
			System.out.println(m.getReturnType() + " " + m.getName() + "(" + Arrays.toString(m.getParameters()) + ")");
		}

		/*
		 * System.out.println("PROVA POSIZIONE...."); RestTemplate restTemplate = new
		 * RestTemplate(); Map<String, String> vars = new HashMap<String, String>();
		 * 
		 * vars.put("address", "1600 Amphitheatre Parkway, Mountain View, CA");
		 * vars.put("sensor", "false"); String result = restTemplate .getForObject(
		 * "http://maps.googleapis.com/maps/api/geocode/xml?address={address}&sensor={sensor}",
		 * 
		 * String.class, vars);
		 * 
		 * System.out.println(result);
		 */

	}

}
