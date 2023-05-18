package Vistas.CrudDuenio;

import javax.swing.*;
import java.awt.event.*;

public class VentanaModificarDuenio extends JDialog {
    private JPanel VentanaModificarDuenio;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbAsistente;
    private JButton bModificar;
    private JButton bSalir;
    private JTextField tfDni;

    public VentanaModificarDuenio() {
        setContentPane(VentanaModificarDuenio);
        setModal(true);
        getRootPane().setDefaultButton(bModificar);

        bModificar.addActionListener(new ActionListener() {
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
        VentanaModificarDuenio.registerKeyboardAction(new ActionListener() {
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
        VentanaModificarDuenio dialog = new VentanaModificarDuenio();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
