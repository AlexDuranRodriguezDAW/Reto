package Vistas;

import Controlador.Main;

import javax.swing.*;

public class VentanaVerClasificacion {
    private JPanel VentanaVerClasidficacion;
    private JPanel BaseCabecera;
    private JLabel logo;
    private JPanel BasePiePagina;
    private JTextArea taClasificacion;
    private JButton bAtras;
    private JLabel Usuario;

    public VentanaVerClasificacion()
    {
        Usuario.setText(Main.getUsuario());

    }

}
