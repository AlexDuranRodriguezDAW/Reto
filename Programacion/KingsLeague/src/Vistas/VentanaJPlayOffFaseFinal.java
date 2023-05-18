package Vistas;

import Controlador.Main;

import javax.swing.*;

public class VentanaJPlayOffFaseFinal {
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel VentanaFaseFinal;
    private JPanel BaseBotones;
    private JTextField tfDni;
    private JButton bCrear;

    public VentanaJPlayOffFaseFinal()
    {
        Usuario.setText(Main.getUsuario());

    }

}
