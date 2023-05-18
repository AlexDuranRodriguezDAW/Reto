package Vistas.CrudEquipo;

import Controlador.ControladorValidaciones;
import Controlador.Main;
import Modelo.Propietario;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

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

    public VentanaCrearEquipo() {
        setContentPane(ventanaCrearEquipo);
        setModal(true);
        getRootPane().setDefaultButton(bCrear);

        try {
            Main.llenarComboBoxPropietario(cbPropietario);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error llenado comboBox");
        }

        bCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
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
        ventanaCrearEquipo.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws Exception {
        try {
            if (tfNombre.getText().isEmpty() || tfSponsor.getText().isEmpty()){
                throw new Exception("No pueden haber campos vacios");
            }
            ControladorValidaciones.validarDato(tfNombre.getText(), "Nombre equipo", "^[A-Z][a-z]*( [A-Z]?[a-z]*)*\\S$");
            ControladorValidaciones.validarDato(tfSponsor.getText(), "Nombre del sponsor", "^[A-Z][a-z]*( [A-Z]?[a-z]*)*\\S$");
            int n = Main.crearEquipo(tfNombre.getText(), tfSponsor.getText(), cbPropietario.getSelectedIndex());
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "El equipo ha sido creado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "El equipo no ha podido ser creado");
            }
            tfNombre.setText("");
            tfSponsor.setText("");
            cbPropietario.setSelectedIndex(-1);
        } catch (Exception e) {
            throw new Exception("Error al crear el equipo" + e.getMessage());
        }
    }

    private void onCancel() {
        dispose();
    }
}
