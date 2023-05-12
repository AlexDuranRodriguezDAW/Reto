package Vistas;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class VentanaInicioSesion {
    private JPanel VentanaInicioSesion;
    private JTextField tfUsuario;
    private JPasswordField pfContrasena;
    private JLabel LogoKingsLeague;
    private JPanel BaseBotones;
    private JButton bSalir;
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JButton bIniciarSesion;

    public VentanaInicioSesion() {
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.validarPassword(tfUsuario.getText(), pfContrasena.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Error usuario no valido");
                }
            }
        });
        pfContrasena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bIniciarSesion.doClick();
            }
        });
    }

    public JPanel getVentanaInicioSesion() {
        return VentanaInicioSesion;
    }
}
