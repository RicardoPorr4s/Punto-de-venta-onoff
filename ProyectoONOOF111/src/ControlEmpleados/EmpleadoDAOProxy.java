/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlEmpleados;

import ControlEmpleados.Empleado;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author porra
 */
public class EmpleadoDAOProxy implements IEmpleadoDAO{
    private EmpleadoDAO empleadodao;
    private ArrayList<String> deletedRecords = new ArrayList<>();
    
    public EmpleadoDAOProxy()
    {
        if(empleadodao == null){
        empleadodao = new EmpleadoDAO();
        }
        
    }

    @Override
        public boolean registrarEmpleado(Empleado p) {
        int option = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            return empleadodao.registrarEmpleado(p);
        }
        else{return false;}
    }

    @Override
    public List<Empleado> listaEmpleados() {
        return empleadodao.listaEmpleados();
       }
    
    
    @Override
    public void eliminaEmpleado() {
       int option = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
       if (option == JOptionPane.YES_OPTION) {
    empleadodao.eliminaEmpleado();        
       }
       else{
           JOptionPane.showMessageDialog(null, "Operacion cancelada");
           
       }
      
    }
    @Override
    public boolean refrescarDatos(ArrayList<String> miArrayList)
    {
        deletedRecords = miArrayList;
        return   empleadodao.refrescarDatos(miArrayList);
        
    }

    @Override
    public boolean actualizarEmpleado(Empleado p) {
        System.out.print("Paso por el proxy actualizar");
        return empleadodao.actualizarEmpleado(p);}

    @Override
    public List<Empleado> buscador(String caso, Empleado p) {
        
         return empleadodao.buscador(caso, p);
    }

    
}
