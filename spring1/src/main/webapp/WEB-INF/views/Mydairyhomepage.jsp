<%@page import="com.twg.spring1.Entities.Entry" %>
<%@page import="java.util.List" %>

<html>
    <head>
    </head>
    <body style="text-align: center">
    <% Integer roll=(Integer)request.getAttribute("id"); %>
    <input type="hidden" name="roll1" value="roll"/>
     <br/>
     <div Style="text-align:left">
     <% String str=(String)request.getAttribute("username"); %>
     <h1>Welocome</h1>
         <h1 style="color:red"><%= str %></h1><%=roll %>
    </div>
    <div style="padding-right:20px">
    <form action="view"><button type="submit" style="text-decoration:none;color:red;float:right;">AddEntry</button></form>
    </div>
     
     <div class="header" style="float:right;padding-right:150px">
         <button type="submit" style="color:blue;text-decoration:none;">Signout</button>
     </div>
     <br/>
      <div>
    <table border="1" style="border-collapse:collapse;text-align: center;width:60%;height:8%;margin:0 auto auto;padding-down:40px"> 

        <caption><h3>List of Past Entries</h3></caption>  
    
    
    </table>
    </div>
    </body>
    </html>    