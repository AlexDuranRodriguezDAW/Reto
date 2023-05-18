package Vistas;

import Controlador.ControladorVentanas;

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
    private JRadioButton rbEntrenador;
    private JRadioButton rbAsistente;
    private JButton bCrear;
    private JLabel Logoadmin;
    private JButton bModificar;
    private JButton bBorrar;
    private JLabel Usuario;
    private JLabel Logo;
    private JButton bSalir;

    public JPanel getpPrincipal() {
        return VentanaAdministrador;
    }

    public VentanaAdministrador() {
        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbEquipo.isSelected()){
                   // Main.crearVentanaCrearEquipo();
                    ControladorVentanas.crearVentanaCrearEquipo();
                } else if (rbAsistente.isSelected()) {
                    ControladorVentanas.crearVentanaCrearAsistente();
                }else if (rbEntrenador.isSelected()){
                    ControladorVentanas.crearVentanaCrearEntrenador();
                } else if (rbJugador.isSelected()) {

                }

            }
        });
        bBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbEquipo.isSelected()){
                    ControladorVentanas.crearVentanaBorrarEquipo();
                } else if (rbAsistente.isSelected()) {
                    ControladorVentanas.crearVentanaBorrarAsitente();
                }else if (rbEntrenador.isSelected()){
                    try {
                        ControladorVentanas.crearVentanBorrarEntrenador();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (rbJugador.isSelected()) {

                }
            }
        });
        bModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbEquipo.isSelected()){
                    ControladorVentanas.crearVentanaModificarEquipo();
                } else if (rbAsistente.isSelected()) {
                    ControladorVentanas.crearVentanaModificarAsistente();
                }else if (rbEntrenador.isSelected()){

                } else if (rbJugador.isSelected()) {

                }
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorVentanas.ventanaAdministrador.dispose();
            }
        });
    }

}
