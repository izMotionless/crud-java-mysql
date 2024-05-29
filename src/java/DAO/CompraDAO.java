/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.Detalle;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class CompraDAO {

    Conexion cone = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public boolean agregar(Detalle det) {
        String sql = "INSERT INTO detalle_compra(id_detalle, id_propiedad,cantidad,precio_compra,id_cliente) VALUES (?,?,?,?,?)";
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, det.getId());
            ps.setInt(2, det.getId_propiedad());
            ps.setInt(3, det.getCantidad());
            ps.setDouble(4, det.getPrecio_compra());
            ps.setString(5, det.getCliente());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
