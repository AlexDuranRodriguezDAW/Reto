package Vistas;

import Controlador.Main;
import Modelo.Jornada;

import javax.swing.*;
import java.sql.SQLException;

public class VentanaVerClasificacion {
    private JPanel VentanaVerClasidficacion;
    private JPanel BaseCabecera;
    private JLabel logo;
    private JPanel BasePiePagina;
    private JTextArea taClasificacion;
    private JButton bAtras;
    private JLabel Usuario;

    public VentanaVerClasificacion(){
        try{
            taClasificacion.setText(Main.sacarClasificacion());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error sacar clasificacion");
        }
        Usuario.setText(Main.getUsuario());
    }

    public JPanel getVentanaVerClasidficacion() {
        return VentanaVerClasidficacion;
    }
}
