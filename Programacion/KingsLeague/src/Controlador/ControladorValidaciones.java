package Controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase se encarga de validar todos los campos de las ventanas, se crea una clase para esta funcion para evitar repetir codigo en todas las ventanas.
 * @author Grupo 3
 * @version 1.0
 * @since 23/05/2023
 */

public class ControladorValidaciones {
    public static void validarDato(String variable, String dato, String exp) throws Exception {
        Pattern pat = Pattern.compile(exp);
        Matcher match = pat.matcher(variable);
        if (!match.matches()) {
            throw new Exception(dato + " no tiene el formato adecuado");
        }
    }
}
