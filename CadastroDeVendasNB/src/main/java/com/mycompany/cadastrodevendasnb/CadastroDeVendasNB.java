/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastrodevendasnb;

/**
 *
 * @author marco
 */

import entities.Cliente;
import javax.swing.SwingUtilities;
import screens.Home;

public class CadastroDeVendasNB {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Home telaPrincipal = new Home();
                telaPrincipal.setVisible(true);
            }
        });
    }
}