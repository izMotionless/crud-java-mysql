package Clases;

import java.io.InputStream;
import javax.servlet.http.Part;
import oracle.sql.BLOB;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Motions
 */
public class Propiedad {
    int id;
    int precio;
    int disponibilidad;
    int usuario;
    String ciudad;
    String comuna;
    String fec_publi;
    InputStream foto;

    public Propiedad() {
    }

    public Propiedad(int id) {
        this.id = id;
    }

    public Propiedad(int precio, int disponibilidad, int usuario, String ciudad, String comuna, String fec_publi, InputStream foto) {
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.usuario = usuario;
        this.ciudad = ciudad;
        this.comuna = comuna;
        this.fec_publi = fec_publi;
        this.foto = foto;
    }

    public Propiedad(int id, int precio, int disponibilidad, int usuario, String ciudad, String comuna, String fec_publi, InputStream foto) {
        this.id = id;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.usuario = usuario;
        this.ciudad = ciudad;
        this.comuna = comuna;
        this.fec_publi = fec_publi;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getFec_publi() {
        return fec_publi;
    }

    public void setFec_publi(String fec_publi) {
        this.fec_publi = fec_publi;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Propiedad{" + "id=" + id + ", precio=" + precio + ", disponibilidad=" + disponibilidad + ", usuario=" + usuario + ", ciudad=" + ciudad + ", comuna=" + comuna + ", fec_publi=" + fec_publi + ", foto=" + foto + '}';
    }
    
    
    
      

}
