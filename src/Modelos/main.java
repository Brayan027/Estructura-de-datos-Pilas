/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Controladores.controladorVista;
import Intefaz.vista;

/**
 *
 * @author WINDOWS 10
 */
public class main {

    public static void main(String[] args) {
        Intefaz.vista vist = new vista();
        Modelos.Pila pil = new Pila();
        Controladores.controladorVista control = new controladorVista(vist, pil);
        vist.setVisible(true);
    }
}
