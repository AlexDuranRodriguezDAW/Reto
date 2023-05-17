package Vistas.CrudJugador;

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
    private JButton buttonOK;
    private JButton buttonCancel;

    public VentanaCrearJugador() {
        setContentPane(VentanaCrearJugador);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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
        VentanaCrearJugador.registerKeyboardAction(new ActionListener() {
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
