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
// Concrete Mediator
class ConcreteMediator implements Mediator {
    private Button button1;
    private Button button2;
    private TextBox textBox;

    public void setButton1(Button button1) {
        this.button1 = button1;
    }

    public void setButton2(Button button2) {
        this.button2 = button2;
    }

    public void setTextBox(TextBox textBox) {
        this.textBox = textBox;
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender == button1) {
            textBox.setText("Botón 1 clickeado");
        } else if (sender == button2) {
            textBox.setText("Botón 2 clickeado");
        }
    }
}