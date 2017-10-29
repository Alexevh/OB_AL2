package Utiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

	public static boolean validarTelefono(String celular) {

		Pattern pat = Pattern.compile("^09\\d\\d\\d\\d\\d\\d\\d");
		Matcher mat = pat.matcher(celular);
		boolean valido = false;

		if (mat.matches()) {
			valido = true;
		}
		return valido;
	}

	public static boolean validarEmail(String email) {
		boolean valido = false;

		Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mat = pat.matcher(email);

		if (mat.matches()) {
			valido = true;
		}
		return valido;
	}

	public static boolean validarCedula(String cedula) {
		boolean valido = false;

		Pattern pat = Pattern.compile("^\\d.\\d\\d\\d.\\d\\d\\d-\\d");
		Matcher mat = pat.matcher(cedula);

		if (mat.matches()) {
			valido = true;
		}
		return valido;
	}

}
