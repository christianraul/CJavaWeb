<%-- 
    Document   : index
    Created on : 01/05/2020, 09:57:11 AM
    Author     : Raul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web con Java</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
        <div class="container my-5">
            <h2 class="text-center">Formulario Básico</h2>
            <div class="row">
                <div class="col-sm">
                    <!-- metodo -->
                    <form action="index.jsp" method="post">
                        <div class="form-group">
                            <label >Nombre</label>
                            <input type="text" class="form-control" name="nombre" placeholder="Nombre">
                        </div>
                        <div class="form-group">
                            <label >Edad</label>
                            <input type="text" class="form-control" name="edad" placeholder="edad">
                        </div>
                        <button type="submit" class="btn btn-primary">GUARDAR</button>
                    </form>
                </div>

            </div>
            <div class="row">
                <div class="col-sm my-3">
                    <div class="alert alert-success text-center" role="alert">
                        <%
                            String nombre = request.getParameter("nombre");
                            String edad = request.getParameter("edad");
                            if (nombre != null && edad != null) {

                                int edadnum=Integer.parseInt(edad);
                                String Edadmensaje="";
                                if(edadnum>=1 && edadnum<=18){
                                    Edadmensaje="Eres menor de edad";
                                }
                                if(edadnum>=18 && edadnum<=30){
                                    Edadmensaje="Eres juventd adulto";
                                }
                                String saludo = "Hola" + " " + nombre + " " + "tienes" + "  " + edad+" "+Edadmensaje;
                                out.print(saludo);
                            } else {
                                out.print("");
                            }

                        %>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
