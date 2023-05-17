package Vistas.CrudJugador;

import javax.swing.*;
import java.awt.event.*;

public class VentanaModificarJugador extends JDialog {
    private JPanel VentanaModificarJugador;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbEquipo;
    private JComboBox cbJugador;
    private JTextField tfPosicion;
    private JTextField tfSueldo;
    private JTextField tfClausula;
    private JButton bModificar;
    private JButton bSalir;

    public VentanaModificarJugador() {
        setContentPane(VentanaModificarJugador);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
        VentanaModificarJugador.registerKeyboardAction(new ActionListener() {
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
        VentanaModificarJugador dialog = new VentanaModificarJugador();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
