package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class product_005fpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Product entry</title>\n");
      out.write("    </head>\n");
      out.write("     <body style=\"background-color:black;\">\n");
      out.write("         \n");
      out.write("         <form name=\"form1\" method=\"post\" onsubmit= \"fn()\">\n");
      out.write("            <font face=\"jokerman\" color=\"white\" >\n");
      out.write("              <br>\n");
      out.write("\t<big>Enter the product details<br>\n");
      out.write("                    <font face=\"comic sans ms\" color=\"white\" >\n");
      out.write("                    Product Code :&emsp;<input type=\"text\" name=\"code\"><br><br>\n");
      out.write("                    Product Name :&emsp;<input type=\"text\" name=\"name\"><br><br>\n");
      out.write("                    Product Price :&emsp;<input type=\"text\" name=\"price\"><br><br>\n");
      out.write("                    Product GST :&emsp;<input type=\"text\" name=\"gst\"><br><br>\n");
      out.write("                    <input type=\"submit\"  value=\"Submit\">\n");
      out.write("                    <br><br><br><br><br><br>\n");
      out.write("                    <input type=\"button\" value=\"edit\" onclick='window.open(\"http://localhost:8080/GSTAPPLN/Edit_page.jsp\")'>\n");
      out.write("        </form>\n");
      out.write("         <script language=\"javascript\">\n");
      out.write("            function fn(){\n");

            try{
 String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
      String DB_URL = "jdbc:mysql://localhost/billingdb";  
      
      // Database credentials 
      String USER = "root@localhost"; 
      String PASS = "12";  
      
      Connection conn = null; 
 
      
      //Register JDBC driver 
      Class.forName("com.mysql.jdbc.Driver");   
      
      //Open a connection
      System.out.println("Connecting to a selected database..."); 

      conn = DriverManager.getConnection(DB_URL, USER, PASS); 
      System.out.println("Connected database successfully...");  
      
      //Execute a query 
      System.out.println("Creating statement...");
            PreparedStatement stat=conn.prepareStatement("insert into productinfo values(?,?,?,?)");
            stat.setString(1,request.getParameter("code"));
            stat.setString(2,request.getParameter("name"));
            stat.setString(3,request.getParameter("price"));
            stat.setString(4,request.getParameter("gst"));
            stat.execute();
            out.print("Details entered");
            conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        
      out.write("\n");
      out.write("                \n");
      out.write("         }\n");
      out.write("         </script>\n");
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
