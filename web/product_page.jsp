<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product entry</title>
    </head>
     <body style="background-color:black;">
         
         <form name="form1" method="post" onsubmit= "fn()">
            <font face="jokerman" color="white" >
              <br>
	<big>Enter the product details<br>
                    <font face="comic sans ms" color="white" >
                    Product Code :&emsp;<input type="text" name="code"><br><br>
                    Product Name :&emsp;<input type="text" name="name"><br><br>
                    Product Price :&emsp;<input type="text" name="price"><br><br>
                    Product GST :&emsp;<input type="text" name="gst"><br><br>
                    <input type="submit"  value="Submit">
                    <br><br><br><br><br><br>
                    
        </form>
         <script language="javascript">
            function fn(){
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
        %>
                
         }
         </script>
    </body>
</html>
