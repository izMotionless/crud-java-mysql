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
                    <h1 class="text-titles"><i class="zmdi zmdi-account zmdi-hc-fw"></i> Usuarios <small>Cliente</small></h1>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-12">
                        <ul class="nav nav-tabs" style="margin-bottom: 15px;">
                            <li class="active"><a href="#new" data-toggle="tab">New</a></li>
                            <li><a href="#list" data-toggle="tab">List</a></li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane fade active in" id="new">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-xs-12 col-md-10 col-md-offset-1">
                                            <form action="ControladorGeneral?menu=Usuarios" method="POST">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Usuario</label>
                                                    <input value="${usuario.getUser()}" class="form-control" type="text" name="txtUser" required>
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Contraseña</label>
                                                    <input value="${usuario.getPass()}" class="form-control" type="password" name="txtPass"required>
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Tipo Usuario</label>
                                                    <input value="3" class="form-control" type="number" name="txtTipo"required>
                                                </div>
                                                <p class="text-center">
                                                    <input value="${usuario.getId()}" type="hidden"id="txtId" name="txtId"required>
                                                    <button type="submit" name="accion" id="accion" value="AgregarCliente" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Guardar</button>
                                                    <button type="submit" name="accion" id="accion" value="ModificarCliente" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Modificar</button>
                                                </p>
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
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="list">
                                <div class="table-responsive">
                                    <table class="table table-hover text-center">
                                        <thead>
                                            <tr>
                                                <th class="text-center">#</th>
                                                <th class="text-center">Usuario</th>
                                                <th class="text-center">Contraseña</th>
                                                <th class="text-center">Tipo Usuario</th>
                                                <th class="text-center">Opciones</th>
                                            </tr>
                                        </thead>
                                        <c:forEach var="aux" items="${lista}">
                                            <tbody>
                                                <tr>
                                                    <td>${aux.getId()}</td>
                                                    <td>${aux.getUser()}</td>
                                                    <td>${aux.getPass()}</td>
                                                    <td>${aux.getTipo()}</td>
                                                    <td><a href="ControladorGeneral?menu=Usuarios&accion=BuscarCliente&id=${aux.getId()}" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i></a></td>
                                                    <td><a href="ControladorGeneral?menu=Usuarios&accion=EliminarCliente&id=${aux.getId()}" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>
                    </div>
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