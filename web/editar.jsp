<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AGREGAR EMPLEADO</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- link para iconos
        https://www.bootstrapcdn.com/fontawesome/
        https://fontawesome.com/v4.7.0/icons/
        -->
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
        %>
        <div class="container my-5">
            <h2 class="text-center">Editar Datos de la Base de Datos</h2>
            <div class="row">
                <div class="col-sm">
                    <form action="editar.jsp" method="get">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" id="nombre"  value="<%= nombre%>" name="nombre" placeholder="escribir el nombre del empleado">
                        </div>
                        <div class="form-group">
                            <label for="direccion">Direccion</label>
                            <input type="text" class="form-control" id="direccion" value="<%= direccion%>" name="direccion" placeholder="escribir la direccion">
                        </div>
                        <div class="form-group">
                            <label for="telefono">Telefono</label>
                            <input type="text" class="form-control" id="telefono" value="<%= telefono%>" name="telefono" placeholder="escribir telefono">
                        </div>
                        <a href="indexdata.jsp"><button type="submit" name="enviar" class="btn btn-danger"><i class="fa fa-ban" aria-hidden="true"> Cancelar</i></button></a>
                        <button type="submit" name="enviar" class="btn btn-primary"><i class="fa fa-floppy-o" aria-hidden="true"> Guardar</i></button>
                        <input type="hidden" name="id" value="<%= id%>">

                    </form>
                </div>
            </div>
        </div>
        <%
            if (request.getParameter("enviar") != null) {

                try {
                    Connection con = null;
                    Statement st = null;
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/jspdata?user=root&password=");
                    st = con.createStatement();
                    st.executeUpdate("UPDATE empledos SET nombre='" + nombre + "',direccion='" + direccion + "',telefono='" + telefono +"' WHERE id='"+id+"'");
                    request.getRequestDispatcher("indexdata.jsp").forward(request, response);
                } catch (Exception e) {
                    out.print(e);
                }
            }
        %>
    </body>
</html>
