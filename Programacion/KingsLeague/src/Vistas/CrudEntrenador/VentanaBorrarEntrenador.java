package Vistas.CrudEntrenador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaBorrarEntrenador extends JDialog {
    private JPanel VentanaBorrarEntrenador;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbEntrenador;
    private JButton bBorrar;
    private JButton bSalir;

    public VentanaBorrarEntrenador() {
        setContentPane(VentanaBorrarEntrenador);
        setModal(true);
        getRootPane().setDefaultButton(bBorrar);
        Usuario.setText(Main.getUsuario());

        try {
            Main.llenarComboBoxEntrenador(cbEntrenador);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error llenar combobox");
        }

        bBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
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
        VentanaBorrarEntrenador.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws Exception {
        try {
            Main.borrarEntrenador(cbEntrenador.getSelectedIndex());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al borrar entrenador");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
