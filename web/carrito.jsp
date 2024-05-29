<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Admin</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="./css/main.css">
    </head>
    <body>
        <!-- SideBar -->
        <%@include file="sidebar.jsp" %>
        <!-- Content page-->
        <section class="full-box dashboard-contentPage">
            <!-- Content page -->
            <div class="container-fluid">
                <div class="page-header">
                    <h1 class="text-titles"><i class="zmdi zmdi-money"></i> Pago <small></small></h1>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-8">
                        <div class="tab-pane active">
                            <div class="table-responsive">
                                <table class="table table-hover text-center">
                                    <thead>
                                        <tr>
                                            <th class="text-center">#</th>
                                            <th class="text-center">Comuna</th>
                                            <th class="text-center">Ciudad</th>
                                            <th class="text-center">Precio</th>
                                            <th class="text-center">Cantidad</th>
                                            <th class="text-center">Subtotal</th>
                                            <th class="text-center">Opciones</th>
                                        </tr>
                                    </thead>
                                    <c:forEach var="car" items="${carrito}">
                                        <tbody>
                                            <tr>
                                                <td>${car.getItem()}</td>
                                                <td>${car.getNombres()}</td>
                                                <td>${car.getDescripcion()}</td>
                                                <td>${car.getPrecioCompra()}</td>
                                                <td>${car.getCantidad()}</td>
                                                <td>${car.getSubtotal()}</td>
                                                <td><img src="ControladorIMG?id=${car.getIdProducto()}" width="100" height="100"> </td>
                                                <td>
                                                    <a href="ControladorGeneral?menu=Usuarios&accion=EliminarCarrito" id="btnDelete" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>

                    </div>
                    <center>


                        <div class="col-sm-4" >
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="text-center">Generar Compra</h3>
                                </div>
                                <div class="card-body">
                                    <c:forEach var="car1" items="${carrito}">
                                        <label>Subtotal</label>
                                        <input style="text-align: center" type="text" value="${subtotal}" readonly="" class="form-control">
                                        <label>Descuento</label>
                                        <input style="text-align: center"type="text" value="0.50%" readonly="" class="form-control">
                                        <label>Total a Pagar</label>
                                        <input style="text-align: center"type="text" value="${totalPagar}" readonly="" class="form-control">
                                        <form action="ControladorGeneral?menu=Usuarios" method="POST">
                                            <input type="hidden" value="${car1.getIdProducto()}" name="txtPropiedad">
                                            <input type="hidden" value="${car1.getCantidad()}" name="txtCantidad">
                                            <input type="hidden" value="${totalPagar}" name="txtTotal">
                                            <input type="hidden" value="${usuario.getUser()}" name="txtCliente">
                                            <input type="hidden" value="0" name="txtPago">
                                            <button type="submit" name="accion" id="accion" value="AgregarCompra" class="btn btn-info btn-raised btn-sm">Generar Compra</button>
                                        </form>

                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </center>
                </div>
            </div>
        </section>

        <!-- Notifications area -->
        <section class="full-box Notifications-area">
            <div class="full-box Notifications-bg btn-Notifications-area"></div>
            <div class="full-box Notifications-body">
                <div class="Notifications-body-title text-titles text-center">
                    Notifications <i class="zmdi zmdi-close btn-Notifications-area"></i>
                </div>
                <div class="list-group">
                    <div class="list-group-item">
                        <div class="row-action-primary">
                            <i class="zmdi zmdi-alert-triangle"></i>
                        </div>
                        <div class="row-content">
                            <div class="least-content">17m</div>
                            <h4 class="list-group-item-heading">Tile with a label</h4>
                            <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus.</p>
                        </div>
                    </div>
                    <div class="list-group-separator"></div>
                    <div class="list-group-item">
                        <div class="row-action-primary">
                            <i class="zmdi zmdi-alert-octagon"></i>
                        </div>
                        <div class="row-content">
                            <div class="least-content">15m</div>
                            <h4 class="list-group-item-heading">Tile with a label</h4>
                            <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus.</p>
                        </div>
                    </div>
                    <div class="list-group-separator"></div>
                    <div class="list-group-item">
                        <div class="row-action-primary">
                            <i class="zmdi zmdi-help"></i>
                        </div>
                        <div class="row-content">
                            <div class="least-content">10m</div>
                            <h4 class="list-group-item-heading">Tile with a label</h4>
                            <p class="list-group-item-text">Maecenas sed diam eget risus varius blandit.</p>
                        </div>
                    </div>
                    <div class="list-group-separator"></div>
                    <div class="list-group-item">
                        <div class="row-action-primary">
                            <i class="zmdi zmdi-info"></i>
                        </div>
                        <div class="row-content">
                            <div class="least-content">8m</div>
                            <h4 class="list-group-item-heading">Tile with a label</h4>
                            <p class="list-group-item-text">Maecenas sed diam eget risus varius blandit.</p>
                        </div>
                    </div>
                </div>

            </div>
        </section>

        <!-- Dialog help -->
        <div class="modal fade" tabindex="-1" role="dialog" id="Dialog-Help">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Help</h4>
                    </div>
                    <div class="modal-body">
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt beatae esse velit ipsa sunt incidunt aut voluptas, nihil reiciendis maiores eaque hic vitae saepe voluptatibus. Ratione veritatis a unde autem!
                        </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary btn-raised" data-dismiss="modal"><i class="zmdi zmdi-thumb-up"></i> Ok</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>