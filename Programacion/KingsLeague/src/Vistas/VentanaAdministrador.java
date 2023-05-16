package Vistas;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdministrador {
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JPanel VentanaAdministrador;
    private JMenuItem bCrearEquipo;
    private JMenuItem bBorrarEquipo;
    private JMenuItem bModificarEquipo;
    private JPanel BaseEleccion;
    private JRadioButton rbEquipo;
    private JRadioButton rbJugador;
    private JRadioButton rbDuenio;
    private JRadioButton rbAsistente;
    private JButton bCrear;
    private JLabel Logoadmin;
    private JButton bModificar;
    private JButton bBorrar;
    private JLabel Usuario;
    private JLabel Logo;

    public JPanel getpPrincipal() {
        return VentanaAdministrador;
    }

    public VentanaAdministrador() {
        bCrearEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaCrearEquipo();
            }
        });
        bBorrarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaBorrarEquipo();
            }
        });
        bModificarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaModificarEquipo();
            }
        });
    }

}
