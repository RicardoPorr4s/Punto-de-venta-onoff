/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlProveedores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

import java.sql.Connection;
import javax.swing.JOptionPane;
import Controlador.Conexion;
import ControlProveedores.Proveedor;
        
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author porra
 */
public class ProveedorDatos {
    Connection conexion = null;
    PreparedStatement ps;
    ResultSet rs;
    public boolean regitrarProveedor(Proveedor p)
    {
        String con="insert into proveedor(nombre,direccion,numero_tele,correo)values(?,?,?,?)";
        String consulta="INSERT INTO proveedor(nombre,direccion,numero_tele,correo) VALUES(?,?,?,?)";
            try
            {
                conexion = Conexion.getConexion();
                
            ps=conexion.prepareStatement(consulta);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getCorreo());
            ps.execute();
            System.out.print("insertado corectamebnte");
            return true;
            }
            catch(SQLException e){
            System.out.println(e);return false;}
           
    }
    public List listaProveedor()
    {
        List<Proveedor> lista= new ArrayList();
        String query="SELECT * FROM proveedor";
        try{
            conexion = Conexion.getConexion();
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                Proveedor p = new Proveedor();
                p.setId(rs.getInt("id_proveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("numero_tele"));
                p.setCorreo(rs.getString("correo"));
                lista.add(p);
            }
        }catch(SQLException e){System.out.print(e);}
        return lista;
    }
   
    public boolean eliminaProv(int id)
    {
       String query="delete FROM proveedor where id_proveedor=?";
       try
       {
           conexion = Conexion.getConexion();
           ps=conexion.prepareStatement(query);
           ps.setInt(1, id);
           ps.execute();
           return true;
       }
       catch(SQLException e){System.out.println(e.toString());return false;}
      
        
    }
    public boolean actualizarProveedor(Proveedor p)
    {
        String query="UPDATE proveedor SET nombre=?,direccion=?,numero_tele=?, correo=? WHERE id_proveedor=?";
        try
        {
            conexion = Conexion.getConexion();
            ps=conexion.prepareStatement(query);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getCorreo());
            ps.setInt(5, p.getId());
            ps.execute();
            return true;
            
        }catch(SQLException e){System.out.print(e);return false;}
    }
       
         
}
