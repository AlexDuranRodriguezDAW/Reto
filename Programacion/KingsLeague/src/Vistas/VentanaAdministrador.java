package Vistas;

import Controlador.ControladorVentanas;
import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
    private JButton bFinalPlayOff;
    private JButton bGenerarPlayOff;
    private JButton bGenerarLiga;

    public JPanel getpPrincipal() {
        return VentanaAdministrador;
    }

    public VentanaAdministrador() {
        Usuario.setText(Main.getUsuario());

        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbEquipo.isSelected()) {
                    ControladorVentanas.crearVentanaCrearEquipo();
                } else if (rbAsistente.isSelected()) {
                    ControladorVentanas.crearVentanaCrearAsistente();
                } else if (rbEntrenador.isSelected()) {
                    ControladorVentanas.crearVentanaCrearEntrenador();
                } else if (rbJugador.isSelected()) {
                    ControladorVentanas.crearVentanaCrearJugador();
                }

            }
        });
        bBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbEquipo.isSelected()) {
                    ControladorVentanas.crearVentanaBorrarEquipo();
                } else if (rbAsistente.isSelected()) {
                    ControladorVentanas.crearVentanaBorrarAsitente();
                } else if (rbEntrenador.isSelected()) {
                    try {
                        ControladorVentanas.crearVentanBorrarEntrenador();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (rbJugador.isSelected()) {
                    ControladorVentanas.crearVentanaBorrarJugador();
                }
            }
        });
        bModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbEquipo.isSelected()) {
                    ControladorVentanas.crearVentanaModificarEquipo();
                } else if (rbAsistente.isSelected()) {
                    ControladorVentanas.crearVentanaModificarAsistente();
                } else if (rbEntrenador.isSelected()) {

                } else if (rbJugador.isSelected()) {
                    try {
                        ControladorVentanas.crearVentanaModificarJuador();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorVentanas.ventanaAdministrador.dispose();
            }
        });
        bGenerarLiga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.emparejarLigaRegular();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        bGenerarPlayOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.emparejarPlayOff();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

}
