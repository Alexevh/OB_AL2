package Utiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

	
	public boolean validarTelefono(String telefono) {

        Pattern pat = Pattern.compile("^09\\d\\d\\d\\d\\d\\d\\d");
        Matcher mat = pat.matcher(telefono);
        boolean valido = false;
        
        if (mat.matches()) {
            valido = true;
        } 

        return valido;
        
    }
    
    
    public boolean validarCoreo(String correo)
    {
        boolean valido = false;
        
         Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
         Matcher mat = pat.matcher(correo);
        
        
        if (mat.matches()) {
            valido = true;
        } 
        
         return valido;
    }
    
      public boolean validarCedula(String cedula)
    {
        boolean valido = false;
        
         Pattern pat = Pattern.compile("^\\d.\\d\\d\\d.\\d\\d\\d-\\d");
         Matcher mat = pat.matcher(cedula);
        
        
        if (mat.matches()) {
            valido = true;
        } 
        
         return valido;
    }
	
}
