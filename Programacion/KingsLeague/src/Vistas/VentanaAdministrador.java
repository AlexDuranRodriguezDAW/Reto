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
    private JRadioButton rbEntrenador;
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
        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbEquipo.isSelected()){
                    Main.crearVentanaCrearEquipo();
                } else if (rbAsistente.isSelected()) {

                }else if (rbEntrenador.isSelected()){

                } else if (rbJugador.isSelected()) {

                }

            }
        });
        bBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbEquipo.isSelected()){
                    Main.crearVentanaBorrarEquipo();
                } else if (rbAsistente.isSelected()) {

                }else if (rbEntrenador.isSelected()){

                } else if (rbJugador.isSelected()) {

                }
            }
        });
        bModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbEquipo.isSelected()){
                    Main.crearVentanaModificarEquipo();
                } else if (rbAsistente.isSelected()) {

                }else if (rbEntrenador.isSelected()){

                } else if (rbJugador.isSelected()) {

                }
            }
        });
    }

}
