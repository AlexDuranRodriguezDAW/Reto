package Vistas.CrudAsistente;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaBorrarAsistente extends JDialog {
    private JPanel VentanaBorrarAsistente;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbAsistente;
    private JButton bBorrar;
    private JButton bSalir;

    public VentanaBorrarAsistente() {
        setContentPane(VentanaBorrarAsistente);
        setModal(true);
        getRootPane().setDefaultButton(bBorrar);

        try {
            Main.llenarComboBoxAsistente(cbAsistente);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error llenado comboBox " + e.getMessage());
        }

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
        VentanaBorrarAsistente.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        try {
            int n = Main.borrarAsistente(cbAsistente.getSelectedIndex());
            JOptionPane.showMessageDialog(null,n + " Asistente ha sido borrado");
            cbAsistente.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error borrar asistente " + e.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
