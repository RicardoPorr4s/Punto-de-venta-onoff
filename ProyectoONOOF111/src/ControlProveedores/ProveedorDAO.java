/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlProveedores;

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
public class ProveedorDAO implements IProveedoresDAO {

    Connection conexion = null;
    PreparedStatement ps;
    ResultSet rs;
    private List<Proveedor> lista = new ArrayList();

    public ProveedorDAO() {
        conexion = Conexion.getConexion();
    }

    @Override
    public boolean regitrarProveedor(Proveedor p) {

        String con = "insert into proveedor(nombre,direccion,numero_tele,correo)values(?,?,?,?)";
        String consulta = "INSERT INTO proveedor(nombre,direccion,numero_tele,correo) VALUES(?,?,?,?)";
        try {
            conexion = Conexion.getConexion();

            ps = conexion.prepareStatement(consulta);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getCorreo());
            ps.execute();
            System.out.print("insertado corectamebnte");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<Proveedor> listaProveedor() {
        System.out.println("Mostrando datos en la tabla: ");
        lista = new ArrayList();
        String query = "SELECT * FROM proveedor";
        try {
            //  conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setId(rs.getInt("id_proveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("numero_tele"));
                p.setCorreo(rs.getString("correo"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.print(e);
        }
        return lista;
    }

    @Override
    public void eliminaProv() {
        System.out.println("Registro eliminado: ");
        JOptionPane.showMessageDialog(null, "Proveedor eliminado");
        //lista.add(e)
        /* String query = "delete FROM proveedor where id_proveedor=?";
        try {
            ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }*/
    }

    @Override
    public boolean actualizarProveedor(Proveedor p) {
        String query = "UPDATE proveedor SET nombre=?,direccion=?,numero_tele=?, correo=? WHERE id_proveedor=?";
        try {
            ps = conexion.prepareStatement(query);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getCorreo());
            ps.setInt(5, p.getId());
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

                String query = "delete FROM proveedor where id_proveedor=?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(miArrayList.get(i).toString()));
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
public List<Proveedor> buscador(String donde, Proveedor p) {
    List<Proveedor> resultados = new ArrayList<>();

    try {
        switch (donde) {
            case "id":
                ps = conexion.prepareStatement("SELECT * FROM proveedor WHERE id_proveedor = ?");
                ps.setInt(1, p.getId());
                rs = ps.executeQuery();

                // Procesar los resultados y agregar a la lista
                while (rs.next()) {
                    Proveedor proveedor = new Proveedor(
                            rs.getInt("id_proveedor"),
                            rs.getString("nombre"),
                            rs.getString("direccion"),
                            rs.getString("numero_tele"),
                            rs.getString("correo")
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
