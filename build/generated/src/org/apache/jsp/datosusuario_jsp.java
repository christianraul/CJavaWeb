package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.mysql.jdbc.Driver;

public final class datosusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("        <!-- link para iconos\n");
      out.write("        https://www.bootstrapcdn.com/fontawesome/\n");
      out.write("        https://fontawesome.com/v4.7.0/icons/\n");
      out.write("        -->\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("logueado") == null || sesion.getAttribute("leogueado").equals("0")) {
                response.sendRedirect("login.jsp");
            }
            Connection con = null;
            Statement st = null;

        
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <form method=\"post\" action=\"datosusuario.jsp\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label >Usuario</label>\n");
      out.write("                                <input type=\"text\" id=\"user\" class=\"form-control\" value=\"");
      out.print( sesion.getAttribute("user"));
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label >Password</label>\n");
      out.write("                                <input type=\"password\" id=\"password1\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label >Repetir su password</label>\n");
      out.write("                                <input type=\"password\" id=\"password2\" class=\"form-control\">\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"submit\" name=\"guardar\" class=\"btn btn-primary\">Guardar</button>\n");
      out.write("                            <a href=\"indexdata.jsp\" class=\"btn btn-danger\">Cancelar</a>\n");
      out.write("                        </form> \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    ");

        if(request.getParameter("guardar")!=null){
            String user =request.getParameter("user");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            
            if(password1.equals(password2)){
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        con=DriverManager.getConnection("jdbc:mysql://localhost/jspdata?user=root&password=");
                        st=con.createStatement();
                        st.executeUpdate("UPDATE user SET user='" + user + "',password='" + password1 +"' WHERE id='"+sesion.getAttribute("id")+"'");
                        sesion.setAttribute("user", user);
                        response.sendRedirect("indexdata.jsp");
                    } catch (Exception e) {
                        out.print("Error en la conexion"+e);
                    }
            } else{
                out.print("Password no conciden");
            }
        }
    
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
