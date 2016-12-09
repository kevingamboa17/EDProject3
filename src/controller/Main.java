/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.View;
import controller.Controller;

/**
 *
 * @author kevingamboa17
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View view = new View();
        view.setVisible(true);
        view.setTitle("Proyecto 3 ED");
        Controller controller = new Controller(view);
    }
    
}
