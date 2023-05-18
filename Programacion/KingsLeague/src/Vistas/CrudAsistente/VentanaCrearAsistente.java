package Vistas.CrudAsistente;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCrearAsistente extends JDialog {
    private JPanel VentanaCrearAsistente;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbEquipo;
    private JTextField tfApellido;
    private JTextField tfSueldo;
    private JTextField tfNombre;
    private JTextField tfDni;
    private JButton bCrear;
    private JButton bSalir;

    public VentanaCrearAsistente() {
        setContentPane(VentanaCrearAsistente);
        setModal(true);
        getRootPane().setDefaultButton(bCrear);

        try {
            Main.llenarComboBoxEquipo(cbEquipo);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al llenar la combo box de equipo " + e.getMessage());
        }

        bCrear.addActionListener(new ActionListener() {
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
        VentanaCrearAsistente.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        try{
            if (tfNombre.getText().isEmpty() || tfApellido.getText().isEmpty() || tfDni.getText().isEmpty() || tfSueldo.getText().isEmpty() || cbEquipo.getSelectedIndex() == -1){
                throw new Exception("No puede haber campos vacios");
            }
            int n = Main.crearAsistente(tfDni.getText(),tfNombre.getText(),tfApellido.getText());
            Main.asignarAsistenteEquipo(tfDni.getText(),cbEquipo.getSelectedIndex(), Double.parseDouble(tfSueldo.getText()));
            JOptionPane.showMessageDialog(null,n + " Asistente ha sido creado");
            vaciarCampos();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void vaciarCampos(){
        tfDni.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        cbEquipo.setSelectedIndex(-1);
        tfSueldo.setText("");
    }

}
