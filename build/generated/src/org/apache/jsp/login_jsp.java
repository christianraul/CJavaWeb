package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.Encriptar;
import java.sql.*;
import com.mysql.jdbc.Driver;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login Usuario</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- link para iconos\n");
      out.write("        https://www.bootstrapcdn.com/fontawesome/\n");
      out.write("        https://fontawesome.com/v4.7.0/icons/\n");
      out.write("        -->\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm\">\n");
      out.write("                    <div class=\"card\" style=\"width: 22rem;\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <form method=\"post\" action=\"login.jsp\">\n");
      out.write("                                <h3 class=\"text-center\">Iniciar Sesión</h3>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Usuario</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" name=\"user\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Contraseña</label>\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" name=\"password\">\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-success\" name=\"login\"><i class=\"fa fa-sign-in\" aria-hidden=\"true\"> INGRESAR</i></button>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary\" name=\"regis\"><i class=\"fa fa-user-o\" aria-hidden=\"true\"> REGISTRARTE</i></button>\n");
      out.write("                            </form>\n");
      out.write("                            ");

                                /*conexion a la base de datos*/
                                Connection con = null;
                                Statement st = null;
                                ResultSet rs = null;
                                Encriptar enc=new Encriptar();

                                /*para validar el ingreso*/
                                if (request.getParameter("login") != null) {
                                    String user = request.getParameter("user");
                                    String password = request.getParameter("password");
                                    HttpSession sesion = request.getSession();
                                    try {
                                        Class.forName("com.mysql.jdbc.Driver");
                                        con = DriverManager.getConnection("jdbc:mysql://localhost/jspdata?user=root&password=");
                                        st = con.createStatement();
                                        rs = st.executeQuery("SELECT * FROM user WHERE USER='" + user + "'and password='" + enc.getMD5(password) + "'");
                                        while (rs.next()) {
                                            sesion.setAttribute("logueado", "1");
                                            sesion.setAttribute("user", rs.getString("user"));
                                            sesion.setAttribute("id", rs.getString("id"));
                                            response.sendRedirect("indexdata.jsp");
                                        }
                                        out.print(" <div class=\"alert alert-danger\" role=\"alert\"> usuario no valido </div>");
                                        
                                    } catch (Exception e) {
                                    }
                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    ");

        /*
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
         */
    
      out.write("\n");
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
