package Vistas.CrudJugador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class VentanaModificarJugador extends JDialog {
    private JPanel VentanaModificarJugador;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbEquipo;
    private JComboBox cbJugador;
    private JTextField tfClausula;
    private JButton bModificar;
    private JButton bSalir;
    private JComboBox cbSueldo;

    public VentanaModificarJugador() {
        setContentPane(VentanaModificarJugador);
        setModal(true);
        getRootPane().setDefaultButton(bModificar);
        Usuario.setText(Main.getUsuario());

        try {
            llenarCB();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error llenado comboBox " + e.getMessage());
        }

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
        VentanaModificarJugador.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        try {
            if (cbJugador.getSelectedIndex() == -1 || cbEquipo.getSelectedIndex() == -1 || cbSueldo.getSelectedIndex() == -1 || tfClausula.getText().isEmpty()) {
                throw new Exception("No puede haber campos vacios");
            }
            Main.modificarJugador(cbEquipo.getSelectedIndex(), cbJugador.getSelectedIndex(), tfClausula.getText(), String.valueOf(cbSueldo.getSelectedItem()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error modificar jugador " + e.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    public void llenarCB() throws Exception {
        Main.llenarComboBoxEquipo(cbEquipo);
        Main.llenarComboBoxJugador(cbJugador);
    }

}
