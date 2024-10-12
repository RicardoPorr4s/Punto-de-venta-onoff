/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlProveedores;

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
public class ProveedorDAOProxy implements IProveedoresDAO{
    private ProveedorDAO proveedordao;
    private JTable tabla;
    public JFrame j;
    ArrayList<Object[]> pinventario;
    private ArrayList<String> deletedRecords = new ArrayList<>();
    
    public ProveedorDAOProxy()
    {
        if(proveedordao == null){
        proveedordao = new ProveedorDAO();
        }
        
    }

    @Override
    public boolean regitrarProveedor(Proveedor p) {
        int option = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            return proveedordao.regitrarProveedor(p);
        }
        else{return false;}
    }

    @Override
    public List<Proveedor> listaProveedor() {
        return proveedordao.listaProveedor();
       }
    
    
    @Override
    public void eliminaProv() {
        //deletedRecords.add(cveEnt.getText());
       // deletedRecords.add(();
      //  System.out.println("Paso por el proxy");
       // return proveedordao.eliminaProv(id);
       int option = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
       if (option == JOptionPane.YES_OPTION) {
    proveedordao.eliminaProv();        
       }
       else{
           
       }
      
    }
    @Override
    public boolean refrescarDatos(ArrayList<String> miArrayList)
    {
        deletedRecords = miArrayList;
        return   proveedordao.refrescarDatos(miArrayList);
        
    }

    @Override
    public boolean actualizarProveedor(Proveedor p) {
        System.out.print("Paso por el proxy actualizar");
        return proveedordao.actualizarProveedor(p);}

    @Override
    public List<Proveedor> buscador(String caso, Proveedor p) {
        
         return proveedordao.buscador(caso, p);
    }

    
}
