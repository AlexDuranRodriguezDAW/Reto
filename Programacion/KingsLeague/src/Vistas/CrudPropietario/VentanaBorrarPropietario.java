package Vistas.CrudPropietario;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class VentanaBorrarPropietario extends JDialog {
    private JPanel VentanaBorrarDuenio;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbPropietario;
    private JButton bBorrar;
    private JButton bSalir;

    public VentanaBorrarPropietario() {
        setContentPane(VentanaBorrarDuenio);
        setModal(true);
        getRootPane().setDefaultButton(bBorrar);
        Usuario.setText(Main.getUsuario());

        try {
            Main.llenarComboBoxPropietario(cbPropietario);
            cbPropietario.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error llenado comboBox");
        }

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
        VentanaBorrarDuenio.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws Exception {
        // add your code here
        int n = Main.borrarDuenio(cbPropietario.getSelectedIndex());

        if (n != 0) {
            JOptionPane.showMessageDialog(null, "Se a borrado el dueño");
        }


    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


}
