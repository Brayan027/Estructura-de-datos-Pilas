/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Intefaz.vista;
import Modelos.Nodo;
import Modelos.Pila;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author WINDOWS 10
 */
public class controladorVista implements ActionListener {

    private vista vits;
    private Pila model;

    public controladorVista(vista vi, Pila pil) {
        vits = vi;
        model = pil;
        vits.jbActualzia.addActionListener(this);
        vits.jbEliminar.addActionListener(this);
        vits.jbGuadar.addActionListener(this);
        vits.setLocationRelativeTo(null);
        SetImageLabel(vits.jLabel7, "src/IMAGEN/PILA.png");

    }

    private void limpiarCampos() {
        vits.txtApellido.setText("");
        vits.txtEdad.setText("");
        vits.txtNombre.setText("");

    }

    public void SetImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //SE CREAN VARIABLES PARA ALMACENAR LSO DATOS DE LOS CAMPOS DE TEXTO
        String Nombre = "";
        String apellido = "";
        String edad = "";
        //SE RELLENAN LOS DATOS 
        Nombre = vits.txtNombre.getText();
        apellido = vits.txtApellido.getText();
        edad = vits.txtEdad.getText();
        //SE REVISA SI SE PRESIONO EL BOTON DE GUADAR SI ES ASI REVISA SI TODOS LOS CAMPOS ESTAN LLENOS
        if (ae.getSource() == vits.jbGuadar) {
            if ((!"".equals(Nombre)) && (!"".equals(apellido)) && (!"".equals(edad))) {
                model.insertar(Nombre, apellido, edad);
                JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CON EXITO");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "POR FAVOR COMPLETE TODO LOS CAMPOS", "FALTAN DATOS", JOptionPane.ERROR_MESSAGE);

            }

        }

        if (ae.getSource() == vits.jbActualzia) {
            if (!model.PilaVacia()) {
                {
                    String datos = "Nombre:" + " " + model.ObtenerCima().getNombre()
                            + "\n" + " Apellido:" + " " + model.ObtenerCima().getApellido()
                            + "\n" + " " + "Edad:" + "  " + model.ObtenerCima().getEdad();
                    vits.jTextArea1.setText(datos);
                }

                //Para mostrar todo los eleementos 
                {//se crea la variable donde se alamcenan los datos
                    String info = "";
//                       un ciclo while para recores toda la pila hasta llegar al final
                    Nodo aux = model.ObtenerCima();

                    while (aux != null) {
                        //en info se almacena y se le añade la otra

                        info += "Nombre:" + " " + aux.getNombre()
                                + "\n" + " Apellido:" + " " + aux.getApellido()
                                + "\n" + " " + "Edad:" + "  " + aux.getEdad() + "\n";

                        aux = aux.getSiguiente();
                    }

                    vits.jTextArea2.setText(info);
                }

            } else {
                JOptionPane.showMessageDialog(null, "PILA VACIA", "NO HAY DATOS", JOptionPane.ERROR_MESSAGE);

            }
        }

        if (ae.getSource() == vits.jbEliminar) {
            if (!model.PilaVacia()) {
                model.quitar();
                vits.jTextArea1.setText("");
                vits.jTextArea2.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "PILA VACIA", "NO SE PUEDE ELIMINAR", JOptionPane.ERROR_MESSAGE);

            }
        }

    }

}
