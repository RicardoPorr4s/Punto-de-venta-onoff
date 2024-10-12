/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlEmpleados;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author porra
 */
public interface IEmpleadoDAO {
    boolean registrarEmpleado(Empleado p);
    List<Empleado> listaEmpleados();
    void eliminaEmpleado();
    boolean actualizarEmpleado(Empleado p);
    boolean refrescarDatos(ArrayList<String> miArrayList);
    List<Empleado> buscador(String caso, Empleado p);
    
    
}
