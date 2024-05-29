/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.InputStream;
import javax.servlet.http.Part;
import oracle.sql.BLOB;

/**
 *
 * @author Motions
 */
public class Empleado {
    int id_emp;
    String  nombre;
    String apellidos;
    int usuario;
    int rut;
    String sexo;

    public Empleado() {
    }

    public Empleado(int id_emp) {
        this.id_emp = id_emp;
    }

    public Empleado(String nombre, String apellidos, int usuario, int rut, String sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.rut = rut;
        this.sexo = sexo;
    }

    public Empleado(int id_emp, String nombre, String apellidos, int usuario, int rut, String sexo) {
        this.id_emp = id_emp;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.rut = rut;
        this.sexo = sexo;
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id_emp=" + id_emp + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario + ", rut=" + rut + ", sexo=" + sexo + '}';
    }
    
    
    
           
    
    
}
