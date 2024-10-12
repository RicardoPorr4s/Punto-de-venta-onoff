/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class Conexion {
     public static final String ul = "jdbc:mysql://127.0.0.1:3306/onoff1?useTimezone=true&serverTimezone=UTC";
    public static final String url = "jdbc:mysql://localhost:3306/onoff?useTimezone=true&serverTimezone=UTC";

    public static final String usuario = "root";
    public static final String contrasena = "Rycardo-Porr4s";
    private static Connection con = null;
    
    private Conexion(String url, String user, String pass) {
    }

    public static Connection getConexion() {
        if (con == null) {
            try {
                //Class.forName("org.apache.derby.jdbc.ClientDriver");
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, usuario, contrasena);
                System.out.println("Conexion realizada a la bd: " + url);

            } catch (ClassNotFoundException e) {
                System.out.println("No");
            } catch (SQLException e) {
                System.out.println("Error");
            }
        }
        return con;
    }
    
    public static ResultSet getTabla(String consulta){
        Connection cn= Conexion.getConexion();
        Statement st;
        ResultSet datos=null;
        
        try{
        st=cn.createStatement();
        datos=st.executeQuery(consulta);
        
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, e);
        }
        return datos;
    }
    public static void main(String args[])
    {
        Conexion.getConexion(); }
}
