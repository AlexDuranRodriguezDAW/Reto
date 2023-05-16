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
        }

        cbEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.buscarPorNombre(cbEquipo.getSelectedItem());
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
