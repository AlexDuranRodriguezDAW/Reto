package Controlador;

import Modelo.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Login l1 = new Login("1", Login.tipo.admin,"Alex","12345");
        TLogin.insertar(l1);
        Staff s1 = new Staff("12345679A","Garcia","Juan");
        Jugador j1 = new Jugador("87654321A","Perez","Alvaro","Portero", Jugador.TipoJugador.draft,"900");
        TJugador.crearJugador(j1);
        //TStaff.crearPersonaStaff(s1);
        //TPersona.borrarPersonaStaff(s1);
    }
}
