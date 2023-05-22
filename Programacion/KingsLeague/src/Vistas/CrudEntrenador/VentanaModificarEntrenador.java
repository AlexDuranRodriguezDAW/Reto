package Vistas.CrudEntrenador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class VentanaModificarEntrenador extends JDialog {
    private JPanel VentanaModificarEntrenador;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbEquipo;
    private JTextField tfSueldo;
    private JComboBox cbEntrenador;
    private JButton bModificar;
    private JButton bSalir;


    public VentanaModificarEntrenador() {
        setContentPane(VentanaModificarEntrenador);
        setModal(true);
        getRootPane().setDefaultButton(bModificar);
        Usuario.setText(Main.getUsuario());

        try {
            Main.llenarComboBoxEntrenador(cbEntrenador);
            cbEntrenador.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error llenado comboBox" + e.getMessage());
        }

        try {
            Main.llenarComboBoxEquipo(cbEquipo);
            cbEquipo.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error llenado comboBox");
        }

        bModificar.addActionListener(new ActionListener() {
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
        VentanaModificarEntrenador.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    private void onOK() throws Exception {
        // add your code here
        Main.modificarEntrenador(cbEntrenador.getSelectedIndex(),cbEquipo.getSelectedIndex(),tfSueldo.getText());
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
