<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>LogIn</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="./css/main.css">
    </head>
    <body class="cover" style="background-image: url(./assets/img/smooth-ivy.jpg);">
        <form action="ControladorLogin" method="POST" autocomplete="off" class="full-box logInForm">
            <p class="text-center text-muted"><i class="zmdi zmdi-account-circle zmdi-hc-5x"></i></p>
            <p class="text-center text-muted text-uppercase">Inicia sesion con tu cuenta</p>
            <div class="form-group label-floating">
                <label class="control-label" for="txtUser">Usuario</label>
                <input class="form-control" id="txtUser" type="text" name="txtUser" required >
                <p class="help-block">Escribe tu Usuario</p>
            </div>
            <div class="form-group label-floating">
                <label class="control-label" for="txtPass">Contraseña</label>
                <input class="form-control" id="txtPass" type="password" name="txtPass" required>
                <p class="help-block">Escribe tu contraseña</p>
            </div>
            <div class="form-group text-center">
                <input type="submit" value="Iniciar sesion" class="btn btn-raised btn-danger">
            </div>
            <c:if test="${err!=null}">
                <div class="alert alert-danger">${err}</div>
            </c:if>
        </form>
        <!--====== Scripts -->
        <script src="./js/jquery-3.1.1.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/material.min.js"></script>
        <script src="./js/ripples.min.js"></script>
        <script src="./js/sweetalert2.min.js"></script>
        <script src="./js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="./js/main.js"></script>
        <script>
            $.material.init();
        </script>
    </body>
</html>