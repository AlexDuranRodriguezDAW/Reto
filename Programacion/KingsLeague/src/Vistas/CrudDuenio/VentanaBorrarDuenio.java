package Vistas.CrudDuenio;

import javax.swing.*;
import java.awt.event.*;

public class VentanaBorrarDuenio extends JDialog {
    private JPanel VentanaBorrarDuenio;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbAsistente;
    private JButton bBorrar;
    private JButton bSalir;

    public VentanaBorrarDuenio() {
        setContentPane(VentanaBorrarDuenio);
        setModal(true);
        getRootPane().setDefaultButton(bBorrar);

        bBorrar.addActionListener(new ActionListener() {
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
        VentanaBorrarDuenio.registerKeyboardAction(new ActionListener() {
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
        VentanaBorrarDuenio dialog = new VentanaBorrarDuenio();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
