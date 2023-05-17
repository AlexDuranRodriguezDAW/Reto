package Vistas;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JButton bClasificacion;
    private JButton bUltimaJornada;
    private JButton bEquipos;
    private JPanel pTabla;

    private JPanel VentanaPrincipal;
    private JButton bAdministrador;
    private JLabel logo;
    private JLabel Usuario;

    public VentanaPrincipal() {
        bEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.crearVentanaVerEquipo();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        bAdministrador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaAdministrador();
            }
        });
    }

    public JPanel getVentanaPrincipal() {
        return VentanaPrincipal;


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
