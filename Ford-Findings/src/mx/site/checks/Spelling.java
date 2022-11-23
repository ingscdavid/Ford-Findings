package mx.site.checks;

import java.util.HashMap;

public class Spelling {

	public static String checkNames(String names) {

		HashMap<String, String> correct_names = new HashMap<String, String>();

		String fullName = "";

		correct_names.put("AILIN", "Ail�n");
		correct_names.put("AMERICA", "Am�rica");
		correct_names.put("ANAHI", "Anah�");
		correct_names.put("ANDRES", "Andr�s");
		correct_names.put("ANGEL", "�ngel");
		correct_names.put("ANGELES", "�ngeles");
		correct_names.put("AXAYACATL", "Axay�catl");
		correct_names.put("BELEN", "Bel�n");
		correct_names.put("CESAR", "C�sar");
		correct_names.put("DONAJI", "Donaj�");
		correct_names.put("EFRAIN", "Efra�n");
		correct_names.put("ESTEFANIA", "Estefan�a");
		correct_names.put("ESTEFANIE", "Estefan�a");
		correct_names.put("FATIMA", "F�tima");
		correct_names.put("HECTOR", "H�ctor");
		correct_names.put("IVAN", "Iv�n");
		correct_names.put("JAZMIN", "Jazm�n");
		correct_names.put("JESUS", "Jes�s");
		correct_names.put("JOSE", "Jos�");
		correct_names.put("JOSUE", "Josu�");
		correct_names.put("MARIA", "Mar�a");
		correct_names.put("NOE", "No�");
		correct_names.put("ROCIO", "Roc�o");
		correct_names.put("SARAI", "Sara�");
		correct_names.put("VICTOR", "V�ctor");
		correct_names.put("YASMIN", "Yasm�n");
		correct_names.put("YAZMIN", "Yazm�n");

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
