package Vistas.CrudEquipo;

import Controlador.ControladorValidaciones;
import Controlador.Main;
import Modelo.Equipo;
import Modelo.Propietario;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaModificarEquipo extends JDialog {
    private JPanel ventanaModificarEquipo;
    private JPanel BaseBotones;
    private JTextField tfSponsor;
    private JComboBox cbPropietario;
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JButton bModificar;
    private JButton bSalir;
    private JComboBox cbNombre;
    private JTextField tfPresupuesto;
    private JLabel Logo;
    private JLabel Usuario;


    public VentanaModificarEquipo() {
        setContentPane(ventanaModificarEquipo);
        setModal(true);
        getRootPane().setDefaultButton(bModificar);
        Usuario.setText(Main.getUsuario());

        try {
            Main.llenarComboBoxEquipo(cbNombre);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al llenar las comboBox " + e.getMessage());
        }

        bModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
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
        ventanaModificarEquipo.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        cbNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                setDatos();
            }
        });
    }

    private void onOK() throws Exception {
        //ControladorValidaciones.validarDato(tfSponsor.getText(), "Nombre del sponsor", "^[A-Z][a-z]*( [A-z]*)*\\S$");
        int n = Main.modificarEquipo(String.valueOf(cbNombre.getSelectedItem()),tfSponsor.getText(),Double.parseDouble(tfPresupuesto.getText()));
        if (n == 1 ){
            JOptionPane.showMessageDialog(null,"El equipo ha sido modificado correctamente");
        }else {
            JOptionPane.showMessageDialog(null,"Error al modificar el equipo");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    //Funcion para sacar los datos del equipo seleccionado
    private void setDatos() {
        int n = (int) Main.getPresupuestoEquipo(cbNombre.getSelectedIndex());
        tfPresupuesto.setText(String.valueOf(n));
        tfSponsor.setText(Main.getSponsorEquipo(cbNombre.getSelectedIndex()));
    }
}
