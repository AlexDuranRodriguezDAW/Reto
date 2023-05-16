package Vistas.Crud;

import Controlador.ControladorValidaciones;
import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLOutput;

public class VentanaCrearEquipo extends JDialog {
    private JPanel ventanaCrearEquipo;
    private JPanel BaseBotones;
    private JTextField tfNombre;
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JButton bCrear;
    private JButton bSalir;
    private JTextField tfSponsor;
    private JComboBox cbPropietario;
    private JButton buttonOK;
    private JButton buttonCancel;

    public VentanaCrearEquipo() {
        setContentPane(ventanaCrearEquipo);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        try {
            Main.llenarComboBoxPropietarios(cbPropietario);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error llenado comoBox Propietarios");
        }

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
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
        ventanaCrearEquipo.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws Exception {
        ControladorValidaciones.validarDato(tfNombre.getText(), "Nombre equipo", "");
        ControladorValidaciones.validarDato(tfSponsor.getText(), "Nombre del sponsor", "");
    }

    private void onCancel() {
        dispose();
    }
}
