package Vistas;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaVerEquipo {
    private JPanel ventanaVerEquipo;
    private JPanel ventanaPrincipal;
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JButton bUltimaJornada;
    private JComboBox cbEquipo;
    private JLabel lEquipo;

    public JPanel getVentanaVerEquipo() {
        return ventanaVerEquipo;
    }

    public VentanaVerEquipo() {
        try {
            llenarCB();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error llenado ComboBox");
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        cbEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String datosEquipo = Main.buscarPorNombre(cbEquipo.getSelectedIndex());
                    JOptionPane.showMessageDialog(null, datosEquipo);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public void llenarCB() throws Exception {
        ArrayList<String> lista = Main.sacarEquipos();
        for (int i = 0; i < lista.size(); i++) {
            cbEquipo.addItem(lista.get(i));
        }
    }


}
