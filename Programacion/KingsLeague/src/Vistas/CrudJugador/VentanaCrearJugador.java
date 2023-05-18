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

    public VentanaCrearJugador() {
        setContentPane(VentanaCrearJugador);
        setModal(true);
        getRootPane().setDefaultButton(bCrear);

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
                if(rbDraft.isSelected()){
                    try {
                        Main.crearPersonaJugadorDraft(tfDni.getText(),tfNombre.getText(),tfApellido.getText(),tfPosicion.getText(),cbEquipo.getSelectedIndex(),rbDraft.getName(),tfNumDraft.getText());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (rbWildCard.isSelected()) {
                    try {
                        Main.crearPersonaJugadorWildCard(tfDni.getText(),tfNombre.getText(),tfApellido.getText(),tfPosicion.getText(),cbEquipo.getSelectedIndex(),rbWildCard.getName());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


}
