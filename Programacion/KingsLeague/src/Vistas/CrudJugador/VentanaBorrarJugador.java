package Vistas.CrudJugador;

import Controlador.Main;
import Modelo.Jugador;

import javax.swing.*;
import java.awt.event.*;

public class VentanaBorrarJugador extends JDialog {
    private JPanel ventanaBorrarJugador;
    private JPanel BaseBotones;
    private JComboBox cbJugador;
    private JPanel BasePiePagina;
    private JPanel BaseCabecera;
    private JButton bBorrar;
    private JButton bSalir;
    private JLabel lNombreJugador;
    private JLabel Logo;
    private JLabel Usuario;

    public VentanaBorrarJugador() {
        setContentPane(ventanaBorrarJugador);
        setModal(true);
        getRootPane().setDefaultButton(bBorrar);
        Usuario.setText(Main.getUsuario());

        try{
            Main.llenarComboBoxJugador(cbJugador);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al llenar la combo box");
        }

        bBorrar.addActionListener(new ActionListener() {
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
        ventanaBorrarJugador.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        cbJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void onOK() {
        // Borrar el equipo selecccionado
        try{
            int n = Main.borrarJugador(cbJugador.getSelectedIndex());
            JOptionPane.showMessageDialog(null,n + " Jugador se ha borrado");
        }catch (Exception e ){
            JOptionPane.showMessageDialog(null,"Error borrar jugador");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public JPanel getVentanaBorrarJugador() {
        return ventanaBorrarJugador;
    }
}
