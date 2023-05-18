package Vistas;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVerEquipo {
    private JPanel ventanaVerEquipo;
    private JComboBox cbEquipo;
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JButton bAtras;
    private JLabel lEquipo;

    public JPanel getVentanaVerEquipo() {
        return ventanaVerEquipo;
    }

    public VentanaVerEquipo() {
        try {
            Main.llenarComboBoxEquipo(cbEquipo);
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
        bAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
