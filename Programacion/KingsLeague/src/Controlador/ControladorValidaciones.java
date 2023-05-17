package Controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorValidaciones {
    public static void validarDato(String variable, String dato, String exp) throws Exception {
        Pattern pat = Pattern.compile(exp);
        Matcher match = pat.matcher(variable);
        if (!match.matches()) {
            throw new Exception(dato + " no tiene el formato adecuado");
        }
    }
}
