/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.Usuario;
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
public class UsuarioDAO {

    Conexion cone = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public int login(Usuario usu) {
        String sql = "SELECT * FROM usuario WHERE user=? AND pass=?";
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usu.getUser());
            ps.setString(2, usu.getPass());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                usu.setId(rs.getInt("id"));
                usu.setUser(rs.getString("user"));
                usu.setPass(rs.getString("pass"));
                usu.setTipo(rs.getInt("tipo"));
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public List listar() {
        String sql = "SELECT * FROM usuario";
        List<Usuario> lista = new ArrayList<>();
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setUser(rs.getString("user"));
                usu.setPass(rs.getString("pass"));
                usu.setTipo(rs.getInt("tipo"));
                lista.add(usu);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List listarID(int id) {
        String sql = "SELECT * FROM usuario WHERE tipo=" + id;
        List<Usuario> lista = new ArrayList<>();
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setUser(rs.getString("user"));
                usu.setPass(rs.getString("pass"));
                usu.setTipo(rs.getInt("tipo"));
                lista.add(usu);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public Usuario buscar(int id) {
        Usuario usu = new Usuario();
        String sql = "SELECT * FROM usuario WHERE id=" + id;
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usu.setId(rs.getInt("id"));
                usu.setUser(rs.getString("user"));
                usu.setPass(rs.getString("pass"));
                usu.setTipo(rs.getInt("tipo"));
            }
        } catch (Exception e) {
        }
        return usu;
    }

    public boolean agregar(Usuario usu) {
        String sql = "INSERT INTO usuario(user,pass,tipo) VALUES (?,?,?)";
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usu.getUser());
            ps.setString(2, usu.getPass());
            ps.setInt(3, usu.getTipo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean modificar(Usuario usu) {
        String sql = "UPDATE usuario SET user=?, pass=?, tipo=? WHERE id=?";
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usu.getUser());
            ps.setString(2, usu.getPass());
            ps.setInt(3, usu.getTipo());
            ps.setInt(4, usu.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id=" + id;
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
