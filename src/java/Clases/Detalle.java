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
public class Detalle {
    int id, id_propiedad, cantidad;
    double precio_compra;
    String cliente;

    public Detalle() {
    }

    public Detalle(int id_propiedad, int cantidad, double precio_compra, String cliente) {
        this.id_propiedad = id_propiedad;
        this.cantidad = cantidad;
        this.precio_compra = precio_compra;
        this.cliente = cliente;
    }

    public Detalle(int id) {
        this.id = id;
    }

    public Detalle(int id, int id_propiedad, int cantidad, double precio_compra, String cliente) {
        this.id = id;
        this.id_propiedad = id_propiedad;
        this.cantidad = cantidad;
        this.precio_compra = precio_compra;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_propiedad() {
        return id_propiedad;
    }

    public void setId_propiedad(int id_propiedad) {
        this.id_propiedad = id_propiedad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Detalle{" + "id=" + id + ", id_propiedad=" + id_propiedad + ", cantidad=" + cantidad + ", precio_compra=" + precio_compra + ", cliente=" + cliente + '}';
    }

    
    
}
