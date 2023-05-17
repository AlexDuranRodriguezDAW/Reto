package Vistas.CrudEquipo;

import Controlador.Main;
import Modelo.Equipo;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaBorrarEquipo extends JDialog {
    private JPanel ventanaBorrarEquipo;
    private JPanel BaseBotones;
    private JComboBox cbEquipo;
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JButton bBorrar;
    private JButton bSalir;

    ArrayList<Equipo> equipos;


    public VentanaBorrarEquipo() {
        setContentPane(ventanaBorrarEquipo);
        setModal(true);
        getRootPane().setDefaultButton(bBorrar);

        try {
            llenarComboBox();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error llenado comboBox");
        }

        bBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });

        bSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        ventanaBorrarEquipo.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws Exception {
        try {
            Main.borrarEquipo((String) cbEquipo.getSelectedItem());
            JOptionPane.showMessageDialog(null,"El equipo " + cbEquipo.getSelectedItem() + " ha sido borrado correctamenete");
            cbEquipo.setSelectedIndex(-1);
        } catch (Exception e) {
            throw new Exception("Problemas al borrar equipo" + e.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void llenarComboBox() throws Exception {
        equipos = Main.getEquipos();
        for (Equipo equipo:equipos){
            cbEquipo.addItem(equipo.getNombreEquipo());
        }
        cbEquipo.setSelectedIndex(-1);
    }
}
