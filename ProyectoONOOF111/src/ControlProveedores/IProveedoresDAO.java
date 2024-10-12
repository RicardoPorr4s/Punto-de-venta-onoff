/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlProveedores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author porra
 */
public interface IProveedoresDAO {
    boolean regitrarProveedor(Proveedor p);
    List<Proveedor> listaProveedor();
    void eliminaProv();
    boolean actualizarProveedor(Proveedor p);
    boolean refrescarDatos(ArrayList<String> miArrayList);
    List<Proveedor> buscador(String caso, Proveedor p);
    
    
}
