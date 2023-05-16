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

    private JPanel ventanaPrincipal;
    private JButton bAdministrador;

    public VentanaPrincipal() {
        bEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.crearVentanaVerEquipo();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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
        return ventanaPrincipal;



}}
