package Vistas.Crud;

import Controlador.ControladorValidaciones;

import javax.swing.*;
import java.awt.event.*;

public class VentanaCrearEquipo extends JDialog {
    private JPanel ventanaCrearEquipo;
    private JPanel BaseBotones;
    private JTextField tfNombre;
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JButton bCrear;
    private JButton bSalir;
    private JTextField tfSponsor;
    private JComboBox comboBox1;
    private JButton buttonOK;
    private JButton buttonCancel;

    public VentanaCrearEquipo() {
        setContentPane(ventanaCrearEquipo);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
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
        try {
            ControladorValidaciones.validarDato(tfNombre.getText(),"Nombre equipo","");
            ControladorValidaciones.validarDato(tfSponsor.getText(),"Nombre del sponsor","");
        }catch (Exception e){
            throw new Exception("Error al crear equipo");
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        VentanaCrearEquipo dialog = new VentanaCrearEquipo();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
    }
}
