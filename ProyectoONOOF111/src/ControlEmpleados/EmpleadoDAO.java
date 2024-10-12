/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlEmpleados;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class EmpleadoDAO implements IEmpleadoDAO {

    Connection conexion = null;
    PreparedStatement ps;
    ResultSet rs;
    private List<Empleado> lista = new ArrayList();

    public EmpleadoDAO() {
        conexion = Conexion.getConexion();
    }

    @Override
    public boolean registrarEmpleado(Empleado p) {

        String consulta = "insert into empleados(RFC,nombre,apellido_paterno,apellido_materno,direccion,correo_electronico)values(?,?,?,?,?,?)";
        try {
            conexion = Conexion.getConexion();

            ps = conexion.prepareStatement(consulta);
             ps.setString(1, p.getRFC());
             ps.setString(2, p.getNombre());
            ps.setString(3, p.getApaterno());
            ps.setString(4, p.getAmaterno());
            ps.setString(5, p.getDireccion());
            ps.setString(6, p.getCorreo());
            ps.execute();
            System.out.print("insertado corectamebnte");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<Empleado> listaEmpleados() {
        System.out.println("Mostrando datos en la tabla: ");
        lista = new ArrayList();
        String query = "SELECT * FROM empleados";
        try {
            //  conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado p = new Empleado();
                p.setRFC(rs.getString("RFC"));
                p.setNombre(rs.getString("nombre"));
                p.setApaterno(rs.getString("apellido_paterno"));
                p.setAmaterno(rs.getString("apellido_materno"));
                p.setDireccion(rs.getString("direccion"));
                p.setCorreo(rs.getString("correo_electronico"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
        return lista;
    }

    @Override
    public void eliminaEmpleado() {
        System.out.println("Empleado eliminado: ");
        JOptionPane.showMessageDialog(null, "Empleado eliminado");
    }

    @Override
    public boolean actualizarEmpleado(Empleado p) {
        
        String query ="update empleados set nombre=?,apellido_paterno=?,apellido_materno=?,direccion=?,correo_electronico=? where RFC=?";
        try {
            ps = conexion.prepareStatement(query);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApaterno());
            ps.setString(3, p.getAmaterno());
            ps.setString(4, p.getDireccion());
            ps.setString(5, p.getCorreo());
            ps.setString(6, p.getRFC());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.print("No se puedo actualizar" + e);
            return false;
        }
    }

    @Override
    public boolean refrescarDatos(ArrayList<String> miArrayList) {
        System.out.println("Datos actualizados en la base de datos");
        

        try {
            for (int i = 0; i < miArrayList.size(); i++) {
                System.out.print("id "+miArrayList.get(i).toString());
                //PreparedStatement pps = cn.prepareStatement("delete from entidades where CVE_ENT="+miArrayList.get(i).toString());

                String query = "delete from empleados where RFC=?";
                ps = conexion.prepareStatement(query);
                ps.setString(1,miArrayList.get(i).toString());
               // ps.setInt(1, Integer.parseInt(miArrayList.get(i).toString()));
                ps.execute();
                System.out.println("Registro eliminado----->ya en original: " + miArrayList.get(i));
                JOptionPane.showMessageDialog(null, "Base de datos recargada");
                 }return true;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }

    }

   
@Override
public List<Empleado> buscador(String donde, Empleado p) {
    List<Empleado> resultados = new ArrayList<>();

    try {
        switch (donde) {
            case "id":
                ps = conexion.prepareStatement("SELECT * FROM empleados WHERE RFC = ?");
                ps.setString(1, p.getRFC());
                //ps.setInt(1, p.getId());
                rs = ps.executeQuery();

                while (rs.next()) {
                    Empleado proveedor = new Empleado(
                            rs.getString("RFC"),
                            rs.getString("nombre"),
                            rs.getString("apellido_paterno"),
                            rs.getString("apellido_materno"),
                            rs.getString("direccion"),
                            rs.getString("correo_electronico")
                    );
                    resultados.add(proveedor);
                }
                break;

        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return resultados;
}

}
