/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.Empleado;
import Conexion.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Motions
 */
public class EmpleadoDAO {
    
    Conexion cone = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
        public List listar() {
        String sql = "SELECT * FROM empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setId_emp(rs.getInt("id_emp"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellidos(rs.getString("apellidos"));
                emp.setUsuario(rs.getInt("usuario"));
                emp.setRut(rs.getInt("rut"));
                emp.setSexo(rs.getString("sexo"));
                lista.add(emp);
            }
        } catch (Exception e) {
        }
        return lista;
    }

        public Empleado buscar(int id_emp) {
        Empleado emp = new Empleado();
        String sql = "SELECT * FROM empleado WHERE id_emp=" + id_emp;
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                emp.setId_emp(rs.getInt("id_emp"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellidos(rs.getString("apellidos"));
                emp.setUsuario(rs.getInt("usuario"));
                emp.setRut(rs.getInt("rut"));
                emp.setSexo(rs.getString("sexo"));
            }
        } catch (Exception e) {
        }
        return emp;
    }
        
        public boolean agregar(Empleado emp) {
        String sql = "INSERT INTO empleado (nombre, apellidos, usuario, rut, sexo) VALUES(?,?,?,?,?)";
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellidos());
            ps.setInt(3, emp.getUsuario());
            ps.setInt(4, emp.getRut());
            ps.setString(5, emp.getSexo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }    
        
        public boolean modificar(Empleado emp) {
        String sql = "UPDATE empleado SET nombre=?, apellidos=?, usuario=?, rut=?, sexo=?" +
                "WHERE id_emp=?";
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellidos());
            ps.setInt(3, emp.getUsuario());
            ps.setInt(4, emp.getRut());
            ps.setString(5, emp.getSexo());
            ps.setInt(6, emp.getId_emp());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    
        public boolean eliminar(int id) {
        String sql = "DELETE FROM empleado WHERE id_emp=" + id;
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }    
        
        

    
    
}
