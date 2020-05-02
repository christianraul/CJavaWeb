

<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.Driver"%>
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
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
        %>
        <div class="container my-5">
            <h2 class="text-center">Conexión con la Base de Datos</h2>
            <div class="row">
                <div class="col-sm">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col" colspan="4" class="text-center"><h4>Empleados</h4></th>
                                <th scope="col">
                                    <a href="agregar.jsp" <button type="button" class="btn btn-primary"><i class="fa fa-user-plus" aria-hidden="true"></i></button></a>

                                </th>

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
                            <%
                                try {

                                    Class.forName("com.mysql.jdbc.Driver");
                                    con = DriverManager.getConnection("jdbc:mysql://localhost/jspdata?user=root&password=");
                                    st = con.createStatement();
                                    rs = st.executeQuery("SELECT * FROM empledos");
                                    while (rs.next()) {
                            %>
                            <tr>
                                <th scope="row"><%= rs.getString(1)%></th>
                                <td><%= rs.getString(2)%></td>
                                <td><%= rs.getString(3)%></td>
                                <td><%= rs.getString(4)%></td>
                                <td>
                                    <%-- icono de editar--%>
                                    <a href="editar.jsp?id=<%= rs.getString(1)%>&nombre=<%= rs.getString(2)%>&direccion=<%= rs.getString(3)%>&telefono=<%= rs.getString(4)%>"><button type="button" class="btn btn-warning mr-2"><i class="fa fa-pencil" aria-hidden="true"></i></button></a>

                                    <%-- icono de eliminar--%>
                                    <a href="borrar.jsp?id=<%= rs.getString(1)%>"><button type="button" class="btn btn-danger"><i class="fa fa-trash-o" aria-hidden="true"></i></button></a>

                                </td>
                            </tr>      
                            <%
                                    }
                                } catch (Exception e) {
                                    out.print("ERROR EN LA CONEXION");
                                }
                            %>


                        </tbody>
                    </table>
                </div>

            </div>


        </div>
    </body>
</html>
