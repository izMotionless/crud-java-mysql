/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.Propiedad;
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
public class PropiedadDAO {

    Conexion cone = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        String sql = "SELECT * FROM propiedad";
        List<Propiedad> lista = new ArrayList<>();
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Propiedad prop = new Propiedad();
                prop.setId(rs.getInt("id_propiedad"));
                prop.setCiudad(rs.getString("ciudad"));
                prop.setComuna(rs.getString("comuna"));
                prop.setDisponibilidad(rs.getInt("disponibilidad"));
                prop.setFec_publi(rs.getString("fec_publicacion"));
                prop.setPrecio(rs.getInt("precio"));
                prop.setFoto(rs.getBinaryStream("foto"));
                prop.setUsuario(rs.getInt("id_user"));
                lista.add(prop);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List listarId(int id) {
        String sql = "SELECT * FROM propiedad WHERE id_user=" + id;
        List<Propiedad> lista = new ArrayList<>();
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Propiedad prop = new Propiedad();
                prop.setId(rs.getInt("id_propiedad"));
                prop.setCiudad(rs.getString("ciudad"));
                prop.setComuna(rs.getString("comuna"));
                prop.setDisponibilidad(rs.getInt("disponibilidad"));
                prop.setFec_publi(rs.getString("fec_publicacion"));
                prop.setPrecio(rs.getInt("precio"));
                prop.setFoto(rs.getBinaryStream("foto"));
                prop.setUsuario(rs.getInt("id_user"));
                lista.add(prop);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public Propiedad buscar(int id) {
        Propiedad prop = new Propiedad();
        String sql = "SELECT * FROM propiedad WHERE id_propiedad=" + id;
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prop.setId(rs.getInt("id_propiedad"));
                prop.setComuna(rs.getString("comuna"));
                prop.setCiudad(rs.getString("ciudad"));
                prop.setFec_publi(rs.getString("fec_publicacion"));
                prop.setDisponibilidad(rs.getInt("disponibilidad"));
                prop.setPrecio(rs.getInt("precio"));
                prop.setFoto(rs.getBinaryStream("foto"));
                prop.setUsuario(rs.getInt("id_user"));
            }
        } catch (Exception e) {
        }
        return prop;
    }

    public List listar_comuna(String busqueda) {
        String sql = "SELECT * FROM propiedad WHERE comuna = ? OR ciudad = ? OR fec_publicacion = ?";

        List<Propiedad> lista = new ArrayList<>();
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);

            ps.setString(1, busqueda);
            ps.setString(2, busqueda);
            ps.setString(3, busqueda);
            rs = ps.executeQuery();

            while (rs.next()) {
                Propiedad prop = new Propiedad();
                prop.setId(rs.getInt("id_propiedad"));
                prop.setCiudad(rs.getString("ciudad"));
                prop.setComuna(rs.getString("comuna"));
                prop.setDisponibilidad(rs.getInt("disponibilidad"));
                prop.setFec_publi(rs.getString("fec_publicacion"));
                prop.setPrecio(rs.getInt("precio"));
                prop.setFoto(rs.getBinaryStream("foto"));
                prop.setUsuario(rs.getInt("id_user"));
                lista.add(prop);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public boolean agregar(Propiedad prop) {
        String sql = "INSERT INTO propiedad (comuna, ciudad, fec_publicacion, disponibilidad, precio, foto, id_user) VALUES(?,?,?,?,?,?,?)";
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);

            ps.setString(1, prop.getComuna());
            ps.setString(2, prop.getCiudad());
            ps.setString(3, prop.getFec_publi());
            ps.setInt(4, prop.getDisponibilidad());
            ps.setInt(5, prop.getPrecio());
            ps.setBlob(6, prop.getFoto());
            ps.setInt(7, prop.getUsuario());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean modificar(Propiedad prop) {
        String sql = "UPDATE propiedad SET ciudad=?, comuna=?, disponibilidad=?, fec_publicacion=?"
                + ", precio=?,foto=?, id_user=? WHERE id_propiedad=?";
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, prop.getCiudad());
            ps.setString(2, prop.getComuna());
            ps.setInt(3, prop.getDisponibilidad());
            ps.setString(4, prop.getFec_publi());
            ps.setInt(5, prop.getPrecio());
            ps.setBinaryStream(6, prop.getFoto());
            ps.setInt(7, prop.getUsuario());
            ps.setInt(8, prop.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM propiedad WHERE id_propiedad=" + id;
        try {
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public void listarImg(int id, HttpServletResponse response) {
        String sql = "SELECT * FROM propiedad WHERE id_propiedad=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");
        try {
            outputStream = response.getOutputStream();
            conn = cone.Conexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                inputStream = rs.getBinaryStream("foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
        }
    }
}
