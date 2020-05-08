<%@page import="util.Encriptar" %>
<%@page import="java.sql.*"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

            Connection con = null;
            Statement st = null;
            Encriptar enc = new Encriptar();
        %>
        <div class="container">
            <div class="row">
                <div class="card">
                    <div class="card-body">
                        <form method="post" action="datosusuario.jsp">
                            <div class="form-group">
                                <label >Usuario</label>
                                <input type="text" name="user" class="form-control" value="<%= sesion.getAttribute("user")%>">
                            </div>
                            <div class="form-group">
                                <label >Password</label>
                                <input type="password" name="password1" class="form-control">
                            </div>
                            <div class="form-group">
                                <label >Repetir su password</label>
                                <input type="password" name="password2" class="form-control">
                            </div>
                            <button type="submit" name="guardar" class="btn btn-primary">Guardar</button>
                            <a href="indexdata.jsp" class="btn btn-danger">Cancelar</a>
                        </form> 
                    </div>
                </div>
            </div>
        </div>
    </body>
    <%
        if (request.getParameter("guardar") != null) {
            String user = request.getParameter("user");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");

            if (password1.equals(password2)) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/jspdata?user=root&password=");
                    st = con.createStatement();
                    st.executeUpdate("UPDATE user SET user='" + user + "',password='" + enc.getMD5(password1) + "' WHERE id='" + sesion.getAttribute("id") + "'");
                    sesion.setAttribute("user", user);
                    response.sendRedirect("indexdata.jsp");
                } catch (Exception e) {
                    out.print("Error en la conexion" + e);
                }
            } else {
                out.print("Password no conciden");
            }
        }
    %>
</html>
<!--http://www.md5.cz/-->
<!-Vamos agregar contraseña encriptada con MD5-->
