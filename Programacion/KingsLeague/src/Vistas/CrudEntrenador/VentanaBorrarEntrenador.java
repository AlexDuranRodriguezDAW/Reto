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

    public VentanaBorrarEntrenador() throws Exception {
        setContentPane(VentanaBorrarEntrenador);
        setModal(true);
        getRootPane().setDefaultButton(bBorrar);
        llenarCB();
        Usuario.setText(Main.getUsuario());

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
        // add your code here
        Main.borrarEntrenador(cbEntrenador.getSelectedIndex());
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }



    public void llenarCB() throws Exception {
        ArrayList<String> listaEntrenadores = Main.sacarEntrenadores();

        for (int i = 0; i < listaEntrenadores.size(); i++) {
            cbEntrenador.addItem(listaEntrenadores.get(i));
        }
    }
}
