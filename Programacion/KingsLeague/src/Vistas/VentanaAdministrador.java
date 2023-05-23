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
    private JRadioButton rbPropietario;
    private JButton bCrearUsuario;

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
                } else if (rbPropietario.isSelected()) {
                    ControladorVentanas.crearVentanaCrearPropietario();
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
                    ControladorVentanas.crearVentanBorrarEntrenador();
                } else if (rbJugador.isSelected()) {
                    ControladorVentanas.crearVentanaBorrarJugador();
                } else if (rbPropietario.isSelected()) {
                    ControladorVentanas.crearVentanaBorrarPropietario();
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
                    ControladorVentanas.crearVentanaModificarEntrenador();
                } else if (rbJugador.isSelected()) {
                    ControladorVentanas.crearVentanaModificarJuador();
                } else if (rbPropietario.isSelected()) {
                    ControladorVentanas.crearVentanaModificarPropietario();
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
                    JOptionPane.showMessageDialog(null, "Liga regular creado con exito.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al crear la liga regular");
                }
            }
        });
        bGenerarPlayOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.emparejarPlayOff();
                    JOptionPane.showMessageDialog(null, "PlayOff creado con exito.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al crear los playoffs");
                }
            }
        });
        bCrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorVentanas.crearVentanaCrearUsuario();
            }
        });
    }

}
