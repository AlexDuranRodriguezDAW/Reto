package Vistas;

import Controlador.Main;

import javax.swing.*;
import java.sql.SQLException;

public class VentanaVerClasificacion {
    private JPanel VentanaVerClasidficacion;
    private JPanel BaseCabecera;
    private JLabel logo;
    private JPanel BasePiePagina;
    private JTextArea taClasificacion;
    private JButton bAtras;
    private JLabel Usuario;

    public VentanaVerClasificacion() throws Exception {
        Usuario.setText(Main.getUsuario());
        taClasificacion.setText(Main.sacarClasificacion());
    }


}
