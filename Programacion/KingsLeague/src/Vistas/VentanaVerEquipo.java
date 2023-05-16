package Vistas;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaVerEquipo {
    private JPanel VentanaVerEquipo;
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JButton bSalir;
    private JComboBox cbEquipo;
    private JTextArea taListaEquipos;
    private JPanel BaseEleccion;
    private JLabel Usuario;
    private JLabel Logo;

    public JPanel getVentanaVerEquipo() {
        return VentanaVerEquipo;
    }

    public VentanaVerEquipo() {
        try {
            llenarCB();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error llenado ComboBox");
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
