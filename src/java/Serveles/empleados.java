package Serveles;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.mysql.jdbc.Driver;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "empleados", urlPatterns = {"/empleados"})
public class empleados extends HttpServlet {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            try {

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/jspdata?user=root&password=");
                st = con.createStatement();
                //definir para nuestra busqueda por "NOMBRE" a traves de request
                String query = "SELECT * FROM empledos "; //guardamos en una variable la consulta SELECT
                String where = " WHERE 1=1 "; //muestra todos los enpleados !!Importante separar los espacios
                String nombre = request.getParameter("nombre");//Parametro con la variable nombre
                if (nombre != null) {
                    where = where + "and nombre='" + nombre + "'";//consulta
                }
                query = query + where; //concatenar el QUERY
                rs = st.executeQuery(query);
                while (rs.next()) {
                    out.print("<tr>"
                            + "<th scope=\"row\">" + rs.getString(1) + "</th>"
                            + "<td>" + rs.getString(2) + "</td>"
                            + "<td>" + rs.getString(3) + "</td>"
                            + "<td>" + rs.getString(4) + "</td>"
                            + "<td>"
                            + "<a href=\"editar.jsp?id=" + rs.getString(1) + "&nombre=" + rs.getString(2) + "&direccion=" + rs.getString(3) + "&telefono=" + rs.getString(4) + "\"><button type=\"button\" class=\"btn btn-warning mr-2\"><i class=\"fa fa-pencil\" aria-hidden=\"true\"></i></button></a>"
                            + "<a href=\"borrar.jsp?id=" + rs.getString(1) + "\"><button type=\"button\" class=\"btn btn-danger\"><i class=\"fa fa-trash-o\" aria-hidden=\"true\"></i></button></a>"
                            + "</td>"
                            + "</tr>   "
                    );
                }
            } catch (Exception e) {
                out.print("ERROR EN LA CONEXION"+e);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
