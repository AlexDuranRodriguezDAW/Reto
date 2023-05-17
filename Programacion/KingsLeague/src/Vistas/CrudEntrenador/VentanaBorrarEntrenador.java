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
    private JButton buttonOK;
    private JButton buttonCancel;

    public VentanaBorrarEntrenador() throws Exception {
        setContentPane(VentanaBorrarEntrenador);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        llenarCB();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {

        System.exit(0);
    }

    public void llenarCB() throws Exception {
        ArrayList<String> listaEntrenadores = Main.sacarEntrenadores();

        for (int i = 0; i < listaEntrenadores.size(); i++) {
            cbEntrenador.addItem(listaEntrenadores.get(i));
        }
    }
}
