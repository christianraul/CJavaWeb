package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.mysql.jdbc.Driver;

public final class indexdata_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Conexion|database</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- link para iconos\n");
      out.write("        https://www.bootstrapcdn.com/fontawesome/\n");
      out.write("        https://fontawesome.com/v4.7.0/icons/\n");
      out.write("        -->\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("logueado") == null || sesion.getAttribute("logueado").equals("0")) {
                response.sendRedirect("login.jsp");
            }
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
        
      out.write("\n");
      out.write("        \n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <nav class=\"navbar navbar-light bg-ligth\">\n");
      out.write("                <a class=\"navbar-brand\">Empleados</a>\n");
      out.write("                <form class=\"form-inline\" action=\"logout.jsp\">\n");
      out.write("                    <a><i class=\"fa fa-user-circle\" aria-hidden=\"true\"> Admin</i>");
 sesion.getAttribute("user"); 
      out.write("</a>\n");
      out.write("                    <button class=\"btn btn-outline-danger my-2 my-sm-0 ml-2\" type=\"submit\">Log out</button>\n");
      out.write("                </form>\n");
      out.write("            </nav>\n");
      out.write("            </div>\n");
      out.write("        <div class=\"container mt-3\">   \n");
      out.write("            <h2 class=\"text-center\">Conexión con la Base de Datos</h2>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"col\" colspan=\"4\" class=\"text-center\"><h4>Empleados</h4></th>\n");
      out.write("                                <th scope=\"col\">\n");
      out.write("                                    <a href=\"agregar.jsp\" <button type=\"button\" class=\"btn btn-primary\"><i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i></button></a>\n");
      out.write("\n");
      out.write("                                </th>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"col\">id</th>\n");
      out.write("                                <th scope=\"col\">Nombre</th>\n");
      out.write("                                <th scope=\"col\">Direccion</th>\n");
      out.write("                                <th scope=\"col\">Telefono</th>\n");
      out.write("                                <th scope=\"col\">Acciones</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");

                                try {

                                    Class.forName("com.mysql.jdbc.Driver");
                                    con = DriverManager.getConnection("jdbc:mysql://localhost/jspdata?user=root&password=");
                                    st = con.createStatement();
                                    rs = st.executeQuery("SELECT * FROM empledos");
                                    while (rs.next()) {
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <th scope=\"row\">");
      out.print( rs.getString(1));
      out.write("</th>\n");
      out.write("                                <td>");
      out.print( rs.getString(2));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( rs.getString(3));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print( rs.getString(4));
      out.write("</td>\n");
      out.write("                                <td>\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                    <a href=\"editar.jsp?id=");
      out.print( rs.getString(1));
      out.write("&nombre=");
      out.print( rs.getString(2));
      out.write("&direccion=");
      out.print( rs.getString(3));
      out.write("&telefono=");
      out.print( rs.getString(4));
      out.write("\"><button type=\"button\" class=\"btn btn-warning mr-2\"><i class=\"fa fa-pencil\" aria-hidden=\"true\"></i></button></a>\n");
      out.write("\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                    <a href=\"borrar.jsp?id=");
      out.print( rs.getString(1));
      out.write("\"><button type=\"button\" class=\"btn btn-danger\"><i class=\"fa fa-trash-o\" aria-hidden=\"true\"></i></button></a>\n");
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                            </tr>      \n");
      out.write("                            ");

                                    }
                                } catch (Exception e) {
                                    out.print("ERROR EN LA CONEXION");
                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
