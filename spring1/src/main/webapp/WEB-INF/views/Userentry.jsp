<%@page import="com.twg.spring1.Entities.User" %>
<%@page import="java.sql.Date" %>

<% User user=new User(); 

 user= (User)session.getAttribute("user");
 Integer ans=user.getId();
%>
<%= ans %>
<html>
<head>
</head>
<body style="text-align:center">
<div style="padding-top:90px">
<h4>Add Entry</h4>
<br/>
<br/>
<form action="addentry" method="post">
<div style="padding-right:98px">
Date
<input type="text" name="entrydate"/>
</div>
<br/>
<br/>
<label>discription</label>
<textarea rows="10" cols="30" name="discription"></textarea>
<br/>
<br/>

<button type="submit">SAVE</button>

</form>
</div>
</body>
</html>
