package Vistas.CrudPropietario;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class VentanaModificarPropietario extends JDialog {
    private JPanel VentanaModificarDuenio;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbPropietario;
    private JButton bModificar;
    private JButton bSalir;
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfApellido;

    public VentanaModificarPropietario() {
        setContentPane(VentanaModificarDuenio);
        setModal(true);
        getRootPane().setDefaultButton(bModificar);
        Usuario.setText(Main.getUsuario());

        try {
            Main.llenarComboBoxPropietario(cbPropietario);
            cbPropietario.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error llenado comboBox");
        }

        bModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (SQLException ex) {
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
        VentanaModificarDuenio.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws SQLException {
        // add your code here
        Main.modificarPropietario(tfDni.getText(), tfNombre.getText(),tfApellido.getText());
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
