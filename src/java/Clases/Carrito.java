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
public class Carrito {
    int item, idProducto, cantidad, precioCompra, subtotal;
    String nombres, descripcion;

    public Carrito() {
    }

    public Carrito(int item, int idProducto, int cantidad, int precioCompra, int subtotal, String nombres, String descripcion) {
        this.item = item;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.subtotal = subtotal;
        this.nombres = nombres;
        this.descripcion = descripcion;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Carrito{" + "item=" + item + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", precioCompra=" + precioCompra + ", subtotal=" + subtotal + ", nombres=" + nombres + ", descripcion=" + descripcion + '}';
    }
    
    
}
