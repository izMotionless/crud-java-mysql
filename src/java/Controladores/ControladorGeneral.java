/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.*;
import DAO.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author rodri y romero
 */
@MultipartConfig
public class ControladorGeneral extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO dao = new UsuarioDAO();
        EmpleadoDAO dao2 = new EmpleadoDAO();
        PropiedadDAO dao3 = new PropiedadDAO();
        CompraDAO dao4 = new CompraDAO();
        List<Carrito> listaCarrito = new ArrayList<>();
        int item = 0;
        double descuentofijo = 0.005;
        double totalPagar = 0;
        int subtotal = 0;
        int cantidad = 1;

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Usuarios")) {
            switch (accion) {
                case "ListarComuna":
                    String comunita = request.getParameter("txtComunita");
                    List<Propiedad> listaBusqueda = dao3.listar_comuna(comunita);

                    if (listaBusqueda.size() > 0) {
                        request.setAttribute("comuna", listaBusqueda);
                        request.getRequestDispatcher("buscarProp.jsp").forward(request, response);
                    } else {
                        request.setAttribute("err", "No se encontro nada");
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                    }
                    break;
                case "AgregarCompra":
                    int propiedad = Integer.parseInt(request.getParameter("txtPropiedad"));
                    int cantidadcompra = Integer.parseInt(request.getParameter("txtCantidad"));
                    String clientecompra = request.getParameter("txtCliente");
                    double totalcompra = Double.parseDouble(request.getParameter("txtTotal"));
                    int pagocompra = Integer.parseInt(request.getParameter("txtPago"));
                    Detalle d = new Detalle();
                    d.setCantidad(cantidadcompra);
                    d.setCliente(clientecompra);
                    d.setPrecio_compra(totalcompra);
                    d.setId_propiedad(propiedad);
                    d.setId(pagocompra);
                    if (dao4.agregar(d)) {
                        request.setAttribute("pago", d);
                        request.setAttribute("msj", "Pago Realizado Correctamente");
                        request.getRequestDispatcher("pago.jsp").forward(request, response);

                    } else {
                        request.setAttribute("err", "Pago NO Realizado");
                        request.getRequestDispatcher("pago.jsp").forward(request, response);
                    }
                    break;
                case "EliminarCarrito":
                    request.setAttribute("msj", "Propiedad Removida Correctamente");
                    request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarProp").forward(request, response);
                    break;
                case "AgregarCarrito":
                    int idcar = Integer.parseInt(request.getParameter("id"));
                    Propiedad pcar = new Propiedad();
                    pcar = dao3.buscar(idcar);
                    item = item + 1;
                    Carrito car = new Carrito();
                    car.setItem(item);
                    car.setIdProducto(pcar.getId());
                    car.setNombres(pcar.getComuna());
                    car.setDescripcion(pcar.getCiudad());
                    car.setPrecioCompra(pcar.getPrecio());
                    car.setCantidad(cantidad);
                    subtotal = cantidad * pcar.getPrecio();
                    car.setSubtotal(subtotal);
                    listaCarrito.add(car);
                    totalPagar = subtotal - subtotal * descuentofijo;

                    request.setAttribute("descuento", descuentofijo);
                    request.setAttribute("subtotal", subtotal);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("carrito", listaCarrito);
                    request.getRequestDispatcher("carrito.jsp").forward(request, response);

                    break;
                case "Listar":
                    int i = Integer.parseInt(request.getParameter("id"));
                    List<Usuario> listausu = dao.listarID(i);
                    request.setAttribute("lista", listausu);
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                    break;
                case "Agregar":
                    String user = request.getParameter("txtUser");
                    String pass = request.getParameter("txtPass");
                    int tipo = Integer.parseInt(request.getParameter("txtTipo"));
                    Usuario usuario = new Usuario(user, pass, tipo);
                    if (dao.agregar(usuario)) {

                        request.setAttribute("msj", "Usuario Agregado Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=Listar&id=1").forward(request, response);

                    } else {
                        request.setAttribute("err", "Usuario NO Agregado");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=Listar&id=1").forward(request, response);
                    }
                    break;
                case "Eliminar":
                    int id = Integer.parseInt(request.getParameter("id"));
                    if (dao.eliminar(id)) {

                        request.setAttribute("msj", "Usuario Eliminado Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=Listar&id=1").forward(request, response);

                    } else {
                        request.setAttribute("err", "Usuario NO eliminado");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=Listar&id=1").forward(request, response);
                    }
                    break;
                case "EliminarCliente":
                    int idcli = Integer.parseInt(request.getParameter("id"));
                    if (dao.eliminar(idcli)) {

                        request.setAttribute("msj", "Usuario Eliminado Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarCliente&id=3").forward(request, response);

                    } else {
                        request.setAttribute("err", "Usuario NO eliminado");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarCliente&id=3").forward(request, response);
                    }
                    break;
                case "Modificar":
                    String user1 = request.getParameter("txtUser");
                    String pass1 = request.getParameter("txtPass");
                    int tipo1 = Integer.parseInt(request.getParameter("txtTipo"));
                    int ide = Integer.parseInt(request.getParameter("txtId"));
                    Usuario u = new Usuario(user1, pass1, ide, tipo1);
                    if (dao.modificar(u)) {

                        request.setAttribute("msj", "Usuario Modificado Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=Listar").forward(request, response);
                    } else {
                        request.setAttribute("err", "Usuario NO Modificado");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=Listar").forward(request, response);
                    }
                    break;
                case "Buscar":
                    int id2 = Integer.parseInt(request.getParameter("id"));
                    Usuario usu = dao.buscar(id2);
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=Listar").forward(request, response);
                    break;
                case "ListarEmp":
                    request.setAttribute("lista", dao2.listar());
                    request.getRequestDispatcher("empleado.jsp").forward(request, response);
                    break;

                case "AgregarEmp":
                    String nombre = request.getParameter("txtNombre");
                    String apellidos = request.getParameter("txtApellidos");
                    int usuarioE = Integer.parseInt(request.getParameter("txtUsuario"));
                    int rut = Integer.parseInt(request.getParameter("txtRut"));
                    String sexo = request.getParameter("txtSexo");

                    Empleado emp = new Empleado();

                    emp.setNombre(nombre);
                    emp.setApellidos(apellidos);
                    emp.setUsuario(usuarioE);
                    emp.setRut(rut);
                    emp.setSexo(sexo);

                    if (dao2.agregar(emp)) {

                        request.setAttribute("msj", "Empleado Agregado Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarEmp").forward(request, response);

                    } else {
                        request.setAttribute("err", "Empleado NO Registrado");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarEmp").forward(request, response);
                    }
                    break;

                case "EliminarEmp":
                    int idemp = Integer.parseInt(request.getParameter("id"));
                    if (dao2.eliminar(idemp)) {

                        request.setAttribute("msj", "Empleado Eliminado Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarEmp").forward(request, response);

                    } else {
                        request.setAttribute("err", "Empleado NO eliminado");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarEmp").forward(request, response);
                    }
                    break;

                case "BuscarEmp":
                    int idemp2 = Integer.parseInt(request.getParameter("id"));
                    Empleado e2 = dao2.buscar(idemp2);
                    request.setAttribute("empleado", e2);
                    request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarEmp").forward(request, response);
                    break;

                case "ModificarEmp":
                    int idemp3 = Integer.parseInt(request.getParameter("txtId_emp"));
                    String nombre1 = request.getParameter("txtNombre");
                    String apellidos1 = request.getParameter("txtApellidos");
                    int usuarioE1 = Integer.parseInt(request.getParameter("txtUsuario"));
                    int rut1 = Integer.parseInt(request.getParameter("txtRut"));
                    String sexo1 = request.getParameter("txtSexo");

                    Empleado emp1 = new Empleado(idemp3, nombre1, apellidos1, usuarioE1, rut1, sexo1);

                    if (dao2.modificar(emp1)) {

                        request.setAttribute("msj", "Usuario Modificado Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarEmp").forward(request, response);
                    } else {
                        request.setAttribute("err", "Usuario NO Modificado");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarEmp").forward(request, response);
                    }
                    break;
                case "ListarCliente":
                    int ide1 = Integer.parseInt(request.getParameter("id"));
                    List<Usuario> listacli = dao.listarID(ide1);
                    request.setAttribute("lista", listacli);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    break;
                case "AgregarCliente":
                    String usercli = request.getParameter("txtUser");
                    String passcli = request.getParameter("txtPass");
                    int tipocli = Integer.parseInt(request.getParameter("txtTipo"));
                    Usuario cliente = new Usuario(usercli, passcli, tipocli);
                    if (dao.agregar(cliente)) {

                        request.setAttribute("msj", "Usuario Agregado Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarCliente&id=3").forward(request, response);

                    } else {
                        request.setAttribute("err", "Usuario NO Agregado");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarCliente&id=3").forward(request, response);
                    }
                    break;
                case "ListarProp":
                    List<Propiedad> listaprop = dao3.listar();
                    request.setAttribute("lista", listaprop);
                    request.getRequestDispatcher("propiedades.jsp").forward(request, response);
                    break;
                case "AgregarProp":
                    String ciudad = request.getParameter("txtCiudad");
                    String comuna = request.getParameter("txtComuna");
                    int disponibilidad = Integer.parseInt(request.getParameter("txtDisp"));
                    String fecha = request.getParameter("txtFecha");
                    int precio = Integer.parseInt(request.getParameter("txtPrecio"));
                    Part part = request.getPart("fileImagen");
                    int propietario = Integer.parseInt(request.getParameter("txtUser"));
                    InputStream is = part.getInputStream();
                    Propiedad p = new Propiedad();
                    p.setComuna(comuna);
                    p.setCiudad(ciudad);
                    p.setFec_publi(fecha);
                    p.setDisponibilidad(disponibilidad);
                    p.setPrecio(precio);
                    p.setFoto(is);
                    p.setUsuario(propietario);
                    if (dao3.agregar(p)) {

                        request.setAttribute("msj", "Propiedad Guardada Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarProp").forward(request, response);

                    } else {
                        request.setAttribute("err", "Propiedad NO Guardada");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarProp").forward(request, response);
                    }
                    break;
                case "EliminarProp":
                    int idprop = Integer.parseInt(request.getParameter("id"));
                    if (dao3.eliminar(idprop)) {

                        request.setAttribute("msj", "Propiedad Eliminada Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarProp").forward(request, response);

                    } else {
                        request.setAttribute("err", "Propiedad NO eliminada");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarProp").forward(request, response);
                    }
                    break;
                case "BuscarProp":
                    int idprop2 = Integer.parseInt(request.getParameter("id"));
                    Propiedad prop = dao3.buscar(idprop2);
                    request.setAttribute("propiedad", prop);
                    request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarProp").forward(request, response);
                    break;
                case "ModificarProp":
                    int ideprop = Integer.parseInt(request.getParameter("txtId"));
                    String ciudad1 = request.getParameter("txtCiudad");
                    String comuna1 = request.getParameter("txtComuna");
                    int disponibilidad1 = Integer.parseInt(request.getParameter("txtDisp"));
                    String fecha1 = request.getParameter("txtFecha");
                    int precio1 = Integer.parseInt(request.getParameter("txtPrecio"));
                    Part part1 = request.getPart("fileImagen");
                    int propietario1 = Integer.parseInt(request.getParameter("txtUser"));
                    InputStream is1 = part1.getInputStream();
                    Propiedad p1 = new Propiedad();
                    p1.setComuna(comuna1);
                    p1.setCiudad(ciudad1);
                    p1.setFec_publi(fecha1);
                    p1.setDisponibilidad(disponibilidad1);
                    p1.setPrecio(precio1);
                    p1.setFoto(is1);
                    p1.setUsuario(propietario1);
                    p1.setId(ideprop);
                    if (dao3.modificar(p1)) {

                        request.setAttribute("msj", "Propiedad Modificada Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarProp").forward(request, response);

                    } else {
                        request.setAttribute("err", "Propiedad NO Modificada");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarProp").forward(request, response);
                    }
                    request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarProp").forward(request, response);
                    break;
                case "ListarMisProp":
                    int mip = Integer.parseInt(request.getParameter("id"));
                    List<Propiedad> lista1 = dao3.listarId(mip);
                    request.setAttribute("lista", lista1);
                    request.getRequestDispatcher("mispropiedades.jsp").forward(request, response);
                    break;
                case "EliminarMisProps":
                    int idpropelim = Integer.parseInt(request.getParameter("id"));
                    if (dao3.eliminar(idpropelim)) {

                        request.setAttribute("msj", "Propiedad Eliminada Correctamente");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarProp").forward(request, response);

                    } else {
                        request.setAttribute("err", "Propiedad NO eliminada");
                        request.getRequestDispatcher("ControladorGeneral?menu=Usuarios&accion=ListarProp").forward(request, response);
                    }
                    break;
                default:
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                    break;

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
