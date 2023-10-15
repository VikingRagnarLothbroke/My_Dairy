<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<%
        //Extracting Data from request
        String name=(String)request.getAttribute("name");   
        String mail=(String)request.getAttribute("mail");
        String pwd=(String)request.getAttribute("pwd");
        //out.println(name);
       // out.println(mail);
       // out.println(pwd);
       
      //Connecting to Database and Pushing data into Database
       try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/springjdbc","root", "Mahesh@26");
		
		String qry="insert into logintable values(?,?,?)";
		PreparedStatement stmt1=con.prepareStatement(qry);
		stmt1.setString(1, name);
		stmt1.setString(2, mail);
		stmt1.setString(3, pwd);
		
		int i=stmt1.executeUpdate();
		if(i>=1) {
			out.println("<h1>SUCCESSFULLY REGISTERED</h1>");
			//out.println("<h1> <a href=\"./LoginFront.jsp\">LOGIN</a></h1>");
		}
		
		con.close();
		} 
		catch(Exception e) {
			System.out.println(e);
		}
       response.sendRedirect("login");
%>