<%-- 
    Document   : sidebar
    Created on : 23-sep-2022, 19:31:53
    Author     : rodri
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sidebar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="./css/main.css">
    </head>
    <body>
        <section class="full-box cover dashboard-sideBar">
            <div class="full-box dashboard-sideBar-bg btn-menu-dashboard"></div>
            <div class="full-box dashboard-sideBar-ct">
                <!--SideBar Title -->
                <div class="full-box" alt="UserIcon">

                    <a href="home.jsp">
                        <img src="assets/img/logo.png"> <i class="zmdi zmdi-close btn-menu-dashboard visible-xs"></i>
                    </a>

                </div>
                <!-- SideBar User info -->
                <div class="full-box dashboard-sideBar-UserInfo">
                    <figure class="full-box">
                        <img src="assets/img/avatar_1.jpg" alt="UserIcon">
                        <figcaption style="margin-top: 10px" class="text-center text-titles">Bienvenido ${usuario.getUser()}</figcaption>
                    </figure>
                    <ul class="full-box list-unstyled text-center">
                        <li>
                            <a href="#!">
                                <i class="zmdi zmdi-settings"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#!" class="btn-exit-system">
                                <i class="zmdi zmdi-power"></i>
                            </a>
                        </li>
                    </ul>
                    <form action="ControladorGeneral?menu=Usuarios&accion=ListarComuna" method="POST">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-sm-12">
                                    <input value="" type="text" class="form-control" id="txtComunita" placeholder="Buscar..." name="txtComunita"required>
                                </div>
                                <div class="text-center">
                                    <button type="submit" name="accion" id="accion" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-search"></i></button>
                                </div>
                                <table >
                                    <td>
                                        <c:if test="${msj!=null}">
                                            <div class="alert alert-success">${msj}</div>
                                        </c:if>
                                        <c:if test="${err!=null}">
                                            <div class="alert alert-danger">${err}</div>
                                        </c:if>
                                    </td>
                                </table>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- SideBar Menu -->
                <ul class="list-unstyled full-box dashboard-sideBar-Menu">
                    <c:if test="${usuario.getTipo()==1}">
                        <li>

                            <a href="home.jsp">
                                <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Dashboard
                            </a>
                        </li>
                        <li>
                            <a href="#!" class="btn-sideBar-SubMenu">
                                <i class="zmdi zmdi-case zmdi-hc-fw"></i>Administracion <i class="zmdi zmdi-caret-down pull-right"></i>
                            </a>
                            <ul class="list-unstyled full-box">
                                <li>
                                    <a href="ControladorGeneral?menu=Usuarios&accion=ListarProp"><i class="glyphicon glyphicon-home"></i> Propiedades</a>
                                </li>
                                <li>
                                    <a href="ControladorGeneral?menu=Usuarios&accion=ListarMisProp&id=${usuario.getId()}"><i class="glyphicon glyphicon-home"></i> Mis Propiedades</a>
                                </li>  
                            </ul>
                        </li>
                        <li>
                            <a href="#!" class="btn-sideBar-SubMenu">
                                <i class="glyphicon glyphicon-user"></i> Usuarios <i class="zmdi zmdi-caret-down pull-right"></i>
                            </a>
                            <ul class="list-unstyled full-box">
                                <li>
                                    <a href="ControladorGeneral?menu=Usuarios&accion=Listar&id=1"><i class="zmdi zmdi-account zmdi-hc-fw"></i> Admin</a>
                                </li>
                                <li>
                                    <a href="ControladorGeneral?menu=Usuarios&accion=ListarEmp"><i class="zmdi zmdi-male-alt zmdi-hc-fw"></i> Empleado</a>
                                </li>
                                <li>
                                    <a href="ControladorGeneral?menu=Usuarios&accion=ListarCliente&id=3"><i class="zmdi zmdi-face zmdi-hc-fw"></i> Cliente</a>
                                </li>
                            </ul>
                        </li>
                    </c:if>

                    <c:if test="${usuario.getTipo()==2}">
                        <li>
                            <a href="home.jsp">
                                <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Dashboard
                            </a>
                        </li>
                        <li>
                            <a href="#!" class="btn-sideBar-SubMenu">
                                <i class="zmdi zmdi-case zmdi-hc-fw"></i> Administracion <i class="zmdi zmdi-caret-down pull-right"></i>
                            </a>
                            <ul class="list-unstyled full-box">
                                <li>
                                    <a href="ControladorGeneral?menu=Usuarios&accion=ListarProp"><i class="glyphicon glyphicon-home"></i> Propiedades</a>
                                </li>
                                <li>
                                    <a href="ControladorGeneral?menu=Usuarios&accion=ListarMisProp&id=${usuario.getId()}"><i class="glyphicon glyphicon-home"></i> Mis Propiedades</a>
                                </li>  
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${usuario.getTipo()==3}">
                        <li>
                            <a href="home.jsp">
                                <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Dashboard
                            </a>
                        </li>
                        <li>
                            <a href="#!" class="btn-sideBar-SubMenu">
                                <i class="zmdi zmdi-case zmdi-hc-fw"></i> Administracion <i class="zmdi zmdi-caret-down pull-right"></i>
                            </a>
                            <ul class="list-unstyled full-box">
                                <li>
                                    <a href="ControladorGeneral?menu=Usuarios&accion=ListarProp"><i class="glyphicon glyphicon-home"></i> Propiedades</a>
                                </li>
                                <li>
                                    <a href="ControladorGeneral?menu=Usuarios&accion=ListarMisProp&id=${usuario.getId()}"><i class="glyphicon glyphicon-home"></i> Mis Propiedades</a>
                                </li>  
                            </ul>
                        </li>
                    </c:if>
                </ul>
            </div>
        </section>
        <!--====== Scripts -->
        <script src="./js/jquery-3.1.1.min.js"></script>
        <script src="./js/sweetalert2.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/material.min.js"></script>
        <script src="./js/ripples.min.js"></script>
        <script src="./js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="./js/main.js"></script>
        <script>
            $.material.init();
        </script>
    </body>
</html>
