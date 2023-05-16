package Vistas;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdministrador {
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JPanel pPrincipal;
    private JMenuItem bCrearEquipo;
    private JButton button1;

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public VentanaAdministrador() {
        bCrearEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.crearVentanaCrearEquipo();
            }
        });
    }

}
