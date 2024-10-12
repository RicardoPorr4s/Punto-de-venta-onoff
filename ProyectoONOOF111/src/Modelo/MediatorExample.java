/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 */ 
// Client Code

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MediatorExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mediator Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        ConcreteMediator mediator = new ConcreteMediator();

        Button button1 = new Button("Botón 1");
        Button button2 = new Button("Botón 2");
        TextBox textBox = new TextBox();

        button1.setMediator(mediator);
        button2.setMediator(mediator);
        textBox.setMediator(mediator);

        mediator.setButton1(button1);
        mediator.setButton2(button2);
        mediator.setTextBox(textBox);

        JPanel panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
        panel.add(textBox);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
