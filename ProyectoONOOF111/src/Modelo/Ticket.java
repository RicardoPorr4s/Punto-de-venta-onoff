/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jairo Martinez
 */
public class Ticket {
    //private int numeroTicket;
    private String fecha;
    // Otros atributos
    
    // Constructor
    public Ticket(int numeroTicket, String fecha) {
        //this.numeroTicket = numeroTicket;
        this.fecha = fecha;
        // Inicializar otros atributos
    }
    
    // Métodos getter y setter

    /*public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }*/

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
