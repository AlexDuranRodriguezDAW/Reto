package Vistas.CrudAsistente;

import Controlador.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaModificarAsistente extends JDialog {
    private JPanel VentanaModificarAsistente;
    private JPanel BaseCabecera;
    private JLabel Logo;
    private JLabel Usuario;
    private JPanel BasePiePagina;
    private JPanel BaseBotones;
    private JComboBox cbEquipo;
    private JTextField tfSueldo;
    private JComboBox cbAsistente;
    private JButton bModificar;
    private JButton bSalir;

    public VentanaModificarAsistente() {
        setContentPane(VentanaModificarAsistente);
        setModal(true);
        getRootPane().setDefaultButton(bModificar);
        Usuario.setText(Main.getUsuario());

        try {
            Main.llenarComboBoxAsistente(cbAsistente);
            cbAsistente.setSelectedIndex(-1);
            Main.llenarComboBoxEquipo(cbEquipo);
            cbEquipo.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al llenar las comboBox " + e.getMessage());
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
        VentanaModificarAsistente.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        cbAsistente.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    tfSueldo.setText(String.valueOf(Main.getSueldo(cbAsistente.getSelectedIndex())));
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error al cargar el sueldo " + ex.getMessage());
                }
            }
        });
    }

    private void onOK() {
        try{
            if (tfSueldo.getText().isEmpty() || cbEquipo.getSelectedIndex() == -1 || cbAsistente.getSelectedIndex() == -1){
                throw new Exception("No puede haber campos vacios");
            }
            int n = Main.modificarAsistente(cbEquipo.getSelectedIndex(),cbAsistente.getSelectedIndex(), Double.parseDouble(tfSueldo.getText()));
            JOptionPane.showMessageDialog(null,n + " Asistente ha sido modificado correctamente");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error modificando a un asistente " + e.getMessage());
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


}
