<% session.setAttribute("total","0"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="background-color:black;">
        <form name="form1" method="post" action="http://localhost:8080/GSTAPPLN/product_page.jsp">
            <font face="jokerman" color="white" >
              <br>
	<big>LOGIN<br>
                    <font face="comic sans ms" color="white" >
                    Email_Id :&emsp;<input type="text" name="t1"><br><br>
                    Password :&emsp;<input type="password" name="p1"><br><br>
                    <input type="submit"  value="Submit">
                    <input type="button" value="Register" onclick='window.open("http://localhost:8080/labjsp/val.html")'>
                    <input type="button" value="Forget password" onclick='window.open("http://localhost:8080/labjsp/forgetpass.jsp")'>
        </form>

    </body>
</html>

