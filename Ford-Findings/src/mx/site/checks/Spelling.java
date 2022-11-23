package mx.site.checks;

import java.util.HashMap;

public class Spelling {

	public static String checkNames(String names) {

		HashMap<String, String> correct_names = new HashMap<String, String>();

		String fullName = "";

		correct_names.put("AILIN", "Ailín");
		correct_names.put("AMERICA", "América");
		correct_names.put("ANAHI", "Anahí");
		correct_names.put("ANDRES", "Andrés");
		correct_names.put("ANGEL", "Ángel");
		correct_names.put("ANGELES", "Ángeles");
		correct_names.put("AXAYACATL", "Axayácatl");
		correct_names.put("BELEN", "Belén");
		correct_names.put("CESAR", "César");
		correct_names.put("DONAJI", "Donají");
		correct_names.put("EFRAIN", "Efraín");
		correct_names.put("ESTEFANIA", "Estefanía");
		correct_names.put("ESTEFANIE", "Estefanía");
		correct_names.put("FATIMA", "Fátima");
		correct_names.put("HECTOR", "Héctor");
		correct_names.put("IVAN", "Iván");
		correct_names.put("JAZMIN", "Jazmín");
		correct_names.put("JESUS", "Jesús");
		correct_names.put("JOSE", "José");
		correct_names.put("JOSUE", "Josué");
		correct_names.put("MARIA", "María");
		correct_names.put("NOE", "Noé");
		correct_names.put("ROCIO", "Rocío");
		correct_names.put("SARAI", "Saraí");
		correct_names.put("VICTOR", "Víctor");
		correct_names.put("YASMIN", "Yasmín");
		correct_names.put("YAZMIN", "Yazmín");

		for (String name : names.split(" ")) {
			String token = correct_names.get(name);
			if (token != null) {
				fullName += token;
			} else {								
				fullName += Spelling.properFormat(name);
			}

			fullName += " ";
		}

		return fullName;
	}
	
	private static String properFormat(String name) {
		return name.substring(0, 1).toUpperCase() + name.toLowerCase().substring(1);
		 
	}

}
