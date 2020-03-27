package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class List_005fpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

 session.setAttribute("name",request.getParameter("t1")); 
      out.write('\n');
 session.setAttribute("Product","");
      out.write('\n');
 session.setAttribute("quantity","");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Listing page</title>\n");
      out.write("        <script>\n");
      out.write("            function update(){\n");
      out.write("                alert(\"hi\");\n");
      out.write("  ");
              try{
                    String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
      String DB_URL = "jdbc:mysql://localhost:3306/billingdb?zeroDateTimeBehavior=convertToNull";
      // Database credentials 
      String USER = "root"; 
      String PASS = "12345678";  
      
      Connection conn = null; 
 
      
      //Register JDBC driver 
      Class.forName("com.mysql.jdbc.Driver");   
      
      //Open a connection
      System.out.println("Connecting to a selected database..."); 
      conn = DriverManager.getConnection(DB_URL, USER, PASS); 
            

        PreparedStatement stat=conn.prepareStatement("update list set quantity=? where product=?");
            stat.setString(1,session.getAttribute("quantity").toString());
            stat.setString(2,session.getAttribute("Product").toString());
            stat.execute();
      conn.close();
                }catch(Exception e){
                    
                }
      out.write("\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            try{
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
      String DB_URL = "jdbc:mysql://localhost:3306/billingdb?zeroDateTimeBehavior=convertToNull";
      // Database credentials 
      String USER = "root"; 
      String PASS = "12345678";  
      
      Connection conn = null; 
 
      
      //Register JDBC driver 
      Class.forName("com.mysql.jdbc.Driver");   
      
      //Open a connection
      System.out.println("Connecting to a selected database..."); 
      conn = DriverManager.getConnection(DB_URL, USER, PASS); 
      System.out.println("Connected database successfully...");  
      
      //Execute a query 
      System.out.println("Creating statement...");
            PreparedStatement stat=conn.prepareStatement("select * from productinfo where code=(?) or name=(?)");
            stat.setString(1,request.getParameter("prdt"));
            stat.setString(2,request.getParameter("prdt"));
            ResultSet rs=stat.executeQuery();
            if(rs.next()){
                //
            }else{
                out.print("invalid search");
            }
            conn.close();
            }catch(Exception e){
            
            }
        
      out.write("        \n");
      out.write("        ");
 try{     String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
      String DB_URL = "jdbc:mysql://localhost:3306/billingdb?zeroDateTimeBehavior=convertToNull";
      // Database credentials 
      String USER = "root"; 
      String PASS = "12345678";  
      
      Connection conn = null; 
 
      
      //Register JDBC driver 
      Class.forName("com.mysql.jdbc.Driver");   
      
      //Open a connection
      System.out.println("Connecting to a selected database..."); 
      conn = DriverManager.getConnection(DB_URL, USER, PASS); 
      System.out.println("Connected database successfully...");  
      
      //Execute a query 
      System.out.println("Creating statement...");
      

        PreparedStatement stat=conn.prepareStatement("insert into list values(?,?,?)");
            stat.setString(1,request.getParameter("t1"));
            stat.setString(2,"0");
            stat.setString(3,"0");
            stat.execute();
            out.print("<big>List");
            PreparedStatement stat1=conn.prepareStatement("select * from list");
            ResultSet rs=stat1.executeQuery();
      out.write("\n");
      out.write("            <table style=\"width:100%\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Product Name</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Total Price</th>\n");
      out.write("                </tr>            \n");
      out.write("            ");
if(rs.next()){
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    ");
 session.setAttribute("Product",rs.getString(1));
      out.write("\n");
      out.write("                    <td>");
out.print(session.getAttribute("Product"));
      out.write("</td>\n");
      out.write("                    <td><form name=\"f1\"><input type=\"text\" name=\"quant\" value=\"");
out.print(rs.getString(2));
      out.write("\" onblur=\"change()\"></form>></td>\n");
      out.write("                            \n");
      out.write("            <script language=\"javascript\">\n");
      out.write("            function change(){\n");
      out.write("                var a=document.f1.quant.value;\n");
      out.write("                var p=/[0-9]{1,}/;\n");
      out.write("                if(!a.match(p)){\n");
      out.write("                    alert(\"invalid quantity\");\n");
      out.write("                }else{\n");
      out.write("                    ");

                        String q=request.getParameter("quant");
                        session.setAttribute("quantity",q);
                    
      out.write("\n");
      out.write("                                update();\n");
      out.write("\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("                    <td>");
out.print(rs.getString(2));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td>Gross total</td>\n");
      out.write("                    <td>");
out.print(request.getParameter("total"));
      out.write("</td>\n");
      out.write("                </tr>            \n");
      out.write("            </table>\n");
      out.write("        ");
 conn.close();
        }catch(Exception e){
            
        }
      
      out.write("\n");
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
