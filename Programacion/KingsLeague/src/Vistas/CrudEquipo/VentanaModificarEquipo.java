package Vistas.CrudEquipo;

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
    private ArrayList<Equipo> equipos;
    ArrayList<Propietario> propietarios;


    public VentanaModificarEquipo() {
        setContentPane(ventanaModificarEquipo);
        setModal(true);
        getRootPane().setDefaultButton(bModificar);

        llenarComboBox();

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
        // add your code here
       if (tfPresupuesto.getText().equals(String.valueOf(equipos.get(cbNombre.getSelectedIndex()).getPresupuesto()))){

            Main.modificarEquipoPresupuesto(tfPresupuesto.getText(),cbNombre.getSelectedIndex());

        } else if (tfSponsor.getText().equalsIgnoreCase(equipos.get(cbNombre.getSelectedIndex()).getSponsor()) ) {

            Main.modificarEquipoSponsor(tfSponsor.getText(),cbNombre.getSelectedIndex());

        }else{

            Main.modificarEquipoPresupuesto(tfPresupuesto.getText(),cbNombre.getSelectedIndex());
            Main.modificarEquipoSponsor(tfSponsor.getText(),cbNombre.getSelectedIndex());

        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void llenarComboBox() {
        try {
            equipos = Main.getEquipos();
            propietarios = Main.getPropietarios();
            for (Equipo equipo : equipos) {
                cbNombre.addItem(equipo.getNombreEquipo());
            }
           /* for (Propietario propietario : propietarios) {
                cbPropietario.addItem(propietario.getNombre() + " " + propietario.getApellidos());
            }*/
            cbNombre.setSelectedIndex(-1);
           // cbPropietario.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al llenado de las comoboBox");
        }
    }


    //Funcion para sacar los datos del equipo seleccionado
    private void setDatos() {
        //tfPresupuesto.setText(String.valueOf(equipos.get(cbNombre.getSelectedIndex()).getPresupuesto()));
        tfSponsor.setText(equipos.get(cbNombre.getSelectedIndex()).getSponsor());
    }
}
