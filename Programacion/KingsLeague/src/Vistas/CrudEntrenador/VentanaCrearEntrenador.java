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
        //Main.crearEntrenador(tfNombre.getText(), tfApellido.getText(), tfDni.getText() );
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
