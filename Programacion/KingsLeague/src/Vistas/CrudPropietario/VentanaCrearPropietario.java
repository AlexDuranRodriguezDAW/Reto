package Vistas.CrudPropietario;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class VentanaCrearPropietario extends JDialog {
    private JPanel VentanaCrearDuenio;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbEquipo;
    private JTextField tfApellido;
    private JTextField tfNombre;
    private JTextField tfDni;
    private JButton bCrear;
    private JButton bSalir;

    public VentanaCrearPropietario() {
        setContentPane(VentanaCrearDuenio);
        setModal(true);
        getRootPane().setDefaultButton(bCrear);
        Usuario.setText(Main.getUsuario());

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
        VentanaCrearDuenio.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        try {
            Main.crearDuenio(tfDni.getText(), tfNombre.getText(), tfApellido.getText(), cbEquipo.getSelectedIndex());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el dueño");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


}
