

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Usuario</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- link para iconos
        https://www.bootstrapcdn.com/fontawesome/
        https://fontawesome.com/v4.7.0/icons/
        -->
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
           
            <div class="row">
                <div class="col-sm">
                    <div class="card" style="width: 22rem;">
                        <div class="card-body">
                            <form>
                                <h3 class="text-center">Iniciar Sesión</h3>
                                <div class="form-group">
                                    <label>Usuario</label>
                                    <input type="text" class="form-control" name="user">
                                </div>
                                <div class="form-group">
                                    <label>Contraseña</label>
                                    <input type="password" class="form-control" name="password">
                                </div>
                                <button type="submit" class="btn btn-success" name="login"><i class="fa fa-sign-in" aria-hidden="true"> INGRESAR</i></button>
                                <button type="submit" class="btn btn-primary" name="regis"><i class="fa fa-user-o" aria-hidden="true"> REGISTRARTE</i></button>
                            </form>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </body>
    <%
        if (request.getParameter("login") != null) {
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            HttpSession sesion = request.getSession();
            if (user.equals("admin") && password.equals("admin")) {
                sesion.setAttribute("logueado", "1");
                sesion.setAttribute("user", user);
                response.sendRedirect("indexdata.jsp");
            } else {
                out.print("Error en user o contraaseña");
            }

        }
    %>
</html>
