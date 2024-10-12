/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlEmpleados;

/**
 *
 * @author porra
 */
public class Empleado {

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public Empleado(String RFC) {
        this.RFC = RFC;
    }

    public Empleado() {
    }

    public Empleado(String amaterno, String direccion, String correo, String RFC, String nombre, String apaterno) {
        this.amaterno = amaterno;
        this.direccion = direccion;
        this.correo = correo;
        this.RFC = RFC;
        this.nombre = nombre;
        this.apaterno = apaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    private String amaterno;
    private String direccion;
    private String correo;
    private String RFC;
    private String nombre;
    private String apaterno;
}
