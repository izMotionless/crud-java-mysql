/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author rodri
 */
public class Usuario {
    private String user, pass;
    private int id, tipo;

    public Usuario() {
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String user, String pass, int tipo) {
        this.user = user;
        this.pass = pass;
        this.tipo = tipo;
    }

    public Usuario(String user, String pass, int id, int tipo) {
        this.user = user;
        this.pass = pass;
        this.id = id;
        this.tipo = tipo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "user=" + user + ", pass=" + pass + ", id=" + id + ", tipo=" + tipo + '}';
    }
    
    
}
