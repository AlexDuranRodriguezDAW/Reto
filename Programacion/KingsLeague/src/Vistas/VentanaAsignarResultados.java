package Vistas;

import Controlador.Main;
import Modelo.Jornada;

import javax.swing.*;
import java.awt.event.*;

public class VentanaAsignarResultados extends JDialog {
    private JPanel pAsignarResultados;
    private JButton bAsignarResultados;
    private JButton bSalir;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JComboBox cbJornada;

    public VentanaAsignarResultados() {
        setContentPane(pAsignarResultados);
        setModal(true);
        getRootPane().setDefaultButton(bAsignarResultados);

        Usuario.setText(Main.getUsuario());

        try {
            Main.llenarComboBoxIdJornada(cbJornada);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error llenado combobox id " + e.getMessage());
        }

        bAsignarResultados.addActionListener(new ActionListener() {
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
        pAsignarResultados.registerKeyboardAction(new ActionListener() {
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

}
