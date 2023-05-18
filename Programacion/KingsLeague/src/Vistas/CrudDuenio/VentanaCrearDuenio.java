package Vistas.CrudDuenio;

import javax.swing.*;
import java.awt.event.*;

public class VentanaCrearDuenio extends JDialog {
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

    public VentanaCrearDuenio() {
        setContentPane(VentanaCrearDuenio);
        setModal(true);
        getRootPane().setDefaultButton(bCrear);

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
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VentanaCrearDuenio dialog = new VentanaCrearDuenio();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
