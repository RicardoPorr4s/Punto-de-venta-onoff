/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author porra
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Mediator interface
interface Mediator {
    void notify(Component sender, String event);
}



// Component interface
interface Component {
    void setMediator(Mediator mediator);
}




