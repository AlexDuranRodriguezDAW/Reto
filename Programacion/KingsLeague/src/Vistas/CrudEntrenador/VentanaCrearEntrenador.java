package Vistas.CrudEntrenador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class VentanaCrearEntrenador extends JDialog {
    private JPanel VentanaCrearEntrenador;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbEquipo;
    private JTextField tfApellido;
    private JTextField tfSueldo;
    private JTextField tfNombre;
    private JTextField tfDni;
    private JButton bCrear;
    private JButton bSalir;

    public VentanaCrearEntrenador() {
        setContentPane(VentanaCrearEntrenador);
        setModal(true);
        getRootPane().setDefaultButton(bCrear);
        Usuario.setText(Main.getUsuario());

        try {
            Main.llenarComboBoxEquipo(cbEquipo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al llenar la combo box " + e.getMessage());
        }

        bCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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
        VentanaCrearEntrenador.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        try {
            Main.crearEntrenador(tfNombre.getText(), tfApellido.getText(), tfDni.getText(), cbEquipo.getSelectedIndex(), tfSueldo.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear entrenador " + e.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
