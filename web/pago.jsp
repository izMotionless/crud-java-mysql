<%-- 
    Document   : pago
    Created on : 29-sep-2022, 17:17:40
    Author     : rodri
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pago</title>
    </head>
    <body>
        <%@include file="sidebar.jsp" %>
        <div style="margin-top: 50px" class="container">

            <div class="row">
                <div class="col-xs-12">
                    <ul class="nav nav-tabs" style="margin-bottom: 15px;">
                        <li class="active"><a href="#list" data-toggle="tab">Detalles del Pago</a></li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade active in" id="list">
                            <div class="table-responsive">
                                <table class="table table-hover text-center">
                                    <thead>
                                        <tr>
                                            <th class="text-center"># Propiedad</th>
                                            <th class="text-center">Cantidad</th>
                                            <th class="text-center">Monto Compra</th>
                                            <th class="text-center">Cliente Comprador</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>${pago.getId_propiedad()}</td>
                                            <td>${pago.getCantidad()}</td>
                                            <td>${pago.getPrecio_compra()}</td>
                                            <td>${pago.getCliente()}</td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <table>
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

</body>
</html>
