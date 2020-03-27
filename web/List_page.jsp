<% session.setAttribute("total","0"); %>
<% session.setAttribute("Product","12");%>
<% session.setAttribute("quantity","12");%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listing page</title>
        <script>
            function update(){
                alert("hi");
  <%              try{
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
            

        PreparedStatement stat=conn.prepareStatement("update list set quantity=? where name=?");
        
            stat.setString(1,session.getAttribute("quantity").toString());
            stat.setString(2,session.getAttribute("Product").toString());
            stat.execute();
        stat=conn.prepareStatement("select * from list");    
        ResultSet rs=stat.executeQuery();
        Double t=0.00;
        while(rs.next()){
            Double gst_per_product=Double.parseDouble(rs.getString(5));
            int quantity=Integer.parseInt(rs.getString(2));
            t+=(gst_per_product*quantity);
        }
           session.setAttribute("total", String.valueOf(t));
      conn.close();
                }catch(Exception e){
                    
                }%>
                
            }
            
        </script>
    </head>
    <body>
        <%
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
            PreparedStatement stat=conn.prepareStatement("select * from productinfo where code=(?) or name=(?)");
            stat.setString(1,request.getParameter("prdt"));
            stat.setString(2,request.getParameter("prdt"));
            ResultSet rs=stat.executeQuery();
            if(rs.next()){
                
      try{     String JDBC_DRIVER1 = "com.mysql.jdbc.Driver";   
      String DB_URL1 = "jdbc:mysql://localhost/billingdb";
      // Database credentials 
      String USER1 = "root@localhost"; 
      String PASS1 = "12";  
      
      Connection conn1 = null; 
 
      
      //Register JDBC driver 
      Class.forName("com.mysql.jdbc.Driver");   
      
      //Open a connection
      System.out.println("Connecting to a selected database..."); 
      conn = DriverManager.getConnection(DB_URL1, USER1, PASS1); 
      System.out.println("Connected database successfully...");  
      
      //Execute a query 
      System.out.println("Creating statement...");
      
        
        PreparedStatement stat1=conn.prepareStatement("insert into list values(?,?,?,?,?)");
            stat1.setString(1,rs.getString(2));
            stat1.setString(2,"1");
            String price=rs.getString(3);
            stat1.setString(3,price);
            String gst=rs.getString(4);
            stat1.setString(4,gst);
            Double a=(Integer.parseInt(price)*0.01*Integer.parseInt(gst));
            stat1.setString(5,String.valueOf(a));
            stat1.execute();
            out.print("<big>List");
            PreparedStatement stat2=conn.prepareStatement("select * from list");
            ResultSet rs1=stat2.executeQuery();%>
            <table style="width:100%">
                <tr>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price per product</th>
                </tr>            
            <%if(rs.next()){%>
                <tr>
                    <% session.setAttribute("Product",rs.getString(1));%>
                    <td><%out.print(session.getAttribute("Product"));%></td>
                    <td><form name="f1"><input type="text" name="quant" value="<%out.print(rs.getString(2));%>" onblur="change()"></form>></td>                           
                    <td><%out.print(rs.getString(3));%></td>
                </tr>
            <%}%>
                <tr>
                    <td></td>
                    <td>Gross total</td>
                    <td><%out.print(request.getParameter("total"));%></td>
                </tr>            
            </table>
        <% conn.close();
        }catch(Exception e){
            
        }
      %> 
        }else{
                out.print("invalid search");
            }
            conn.close();
            }catch(Exception e){
            
            }
        %>        

         <script language="javascript">
            function change(){
                var a=document.f1.quant.value;
                var p=/[0-9]{1,}/;
                if(!a.match(p)){
                    alert("invalid quantity");
                }else{
                    <%
                        String q=request.getParameter("quant");
                        session.setAttribute("quantity",q);
                    %>
                                update();

                }
                
            }
        </script>
    </body>
</html>
