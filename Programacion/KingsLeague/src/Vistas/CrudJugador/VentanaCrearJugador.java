package Vistas.CrudJugador;

import Controlador.Main;

import javax.swing.*;
import java.awt.event.*;

public class VentanaCrearJugador extends JDialog {
    private JPanel VentanaCrearJugador;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbEquipo;
    private JTextField tfPosicion;
    private JRadioButton rbDraft;
    private JButton bCrear;
    private JButton bSalir;
    private JRadioButton rbWildCard;
    private JTextField tfNumDraft;
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfClausula;
    private JComboBox cbSueldo;

    public VentanaCrearJugador() {
        setContentPane(VentanaCrearJugador);
        setModal(true);
        getRootPane().setDefaultButton(bCrear);
        Usuario.setText(Main.getUsuario());


        try {
            Main.llenarComboBoxEquipo(cbEquipo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al llenar la combo box de equipo " + e.getMessage());
        }

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
        VentanaCrearJugador.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        bCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tfDni.getText().isEmpty() || tfNombre.getText().isEmpty() || tfApellido.getText().isEmpty() || cbEquipo.getSelectedIndex() == -1 || tfPosicion.getText().isEmpty() || tfClausula.getText().isEmpty()) {
                        throw new Exception("No pueden haber campos vacios");
                    }

                    double sueldo = Double.parseDouble(cbSueldo.getSelectedItem().toString());

                    if (rbDraft.isSelected()) {
                        if (tfNumDraft.getText().isEmpty()) {
                            throw new Exception("El campo numero de draft no puede estar vacio");
                        }
                        Main.crearPersonaJugador(tfDni.getText(), tfNombre.getText(), tfApellido.getText(), tfPosicion.getText(), cbEquipo.getSelectedIndex(), "draft", tfNumDraft.getText(), sueldo, Double.parseDouble(tfClausula.getText()));
                    } else {
                        if (rbWildCard.isSelected()) {
                            Main.crearPersonaJugador(tfDni.getText(), tfNombre.getText(), tfApellido.getText(), tfPosicion.getText(), cbEquipo.getSelectedIndex(), "wildcard", null, sueldo, Double.parseDouble(tfClausula.getText()));
                        } else {
                            throw new Exception("No se ha seleccionado si es wildcard o draft");
                        }
                    }


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error creado de jugador " + ex.getMessage());
                }
            }
        });
        rbDraft.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                tfNumDraft.setEnabled(true);
            }
        });
        rbWildCard.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                tfNumDraft.setEnabled(false);
            }
        });
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public JPanel getVentanaCrearJugador() {
        return VentanaCrearJugador;
    }
}
