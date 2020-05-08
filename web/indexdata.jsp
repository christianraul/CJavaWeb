


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conexion|database</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- link para iconos
        https://www.bootstrapcdn.com/fontawesome/
        https://fontawesome.com/v4.7.0/icons/
        -->
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("logueado") == null || sesion.getAttribute("logueado").equals("0")) {
                response.sendRedirect("login.jsp");
            }

        %>

        <div class="container-fluid">
            <nav class="navbar navbar-light bg-ligth">
                <a class="navbar-brand">Empleados</a>
                <form class="form-inline" action="logout.jsp">
                    <a href="datosusuario.jsp"><i class="fa fa-user-circle" aria-hidden="true"></i> <%= sesion.getAttribute("user")%></a>
                    <button class="btn btn-outline-danger my-2 my-sm-0 ml-2" type="submit">Log out</button>
                </form>
            </nav>
        </div>
        <div class="container mt-3">   
            <h2 class="text-center">Conexión con la Base de Datos</h2>
            <div class="row">
                <div class="col-sm">
                    <form action="indexdata.jsp" method="get">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col" colspan="4" class="text-center"><h4>Empleados</h4></th>

                                    <th scope="col">
                                        <a href="agregar.jsp" <button type="button" class="btn btn-primary"><i class="fa fa-user-plus" aria-hidden="true"></i></button></a>

                                    </th>

                                </tr>
                                <tr>
                                    <th scope="col" class="text-center"></th>
                                    <th scope="col" class="text-center">
                                        <input type="text" name="nombre" class="form-control" placeholder="buscar por nombre" />
                                    </th>
                                    <td scope="col" class="text-center">
                                        <input type="submit" value="Buscar" name="buscar" class="form-control btn btn-primary" />
                                    </td>
                                    <th>
                                </tr>
                                <tr>
                                    <th scope="col">id</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Direccion</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!--Llamar al servels empleados-->
                                <jsp:include page="empleados"/>

                            </tbody>
                        </table>
                    </form>
                </div>

            </div>


        </div>
    </body>
</html>
