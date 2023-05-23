package Vistas;

import Controlador.ControladorVentanas;
import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearUsuarios {
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JRadioButton rbAdministrador;
    private JRadioButton rbUsuario;
    private JTextField tfUsuario;
    private JButton bCrear;
    private JButton bSalir;
    private JPasswordField pfPassRepetida;
    private JPasswordField pfPass;
    private JPanel pCrearUsuario;

    public VentanaCrearUsuarios() {
        Usuario.setText(Main.getUsuario());

        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tfUsuario.getText().isEmpty() || pfPass.getText().isEmpty() || pfPassRepetida.getText().isEmpty()) {
                        throw new Exception("No puede haber campos vacios");
                    }
                    if (!pfPass.getText().equals(pfPassRepetida.getText())) {
                        throw new Exception("Las contraseñas deben ser iguales");
                    }
                    boolean admin = false;
                    if (rbAdministrador.isSelected()) {
                        admin = true;
                    }
                    int resultado = Main.crearUsuario(tfUsuario.getText(), pfPass.getText(), admin);
                    if (resultado == -1) {
                        JOptionPane.showMessageDialog(null, "El usuario creado ya existe");
                    } else {
                        JOptionPane.showMessageDialog(null, resultado + " usuario ha sido creado");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al crear usuario " + ex.getMessage());
                }
            }
        });
        bSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControladorVentanas.ventanaCrearUsuario.dispose();
            }
        });
    }

    public JPanel getpCrearUsuario() {
        return pCrearUsuario;
    }
}
