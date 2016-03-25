<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViralBoards - Login</title>
</head>
<body>
<%
    String error_uname = "";
	String error_password = "";
	String error_invalid = "";
	String uname = "";
    Object error1 = request.getAttribute("error_uname");
    Object error2 = request.getAttribute("error_password");
    Object err_invalid = request.getAttribute("error_invalid");
    Object uname_obj = request.getAttribute("uname");
    
    if (error1 != null || error2 != null) 
    {
    	if(error1 != null)
    	{
    		error_uname = error1.toString();
    	}
    	if(error2 != null)
    	{
        	error_password = error2.toString();
    	}
    }
    else if ( err_invalid != null )
    {
    	error_invalid = err_invalid.toString();
    }
	if ( uname_obj != null )
	{
		uname = uname_obj.toString();
	}
%>
	<form action="/ViralBoards/LoginServlet" method="post">
	<% if ( error_invalid != "" ) { %>
	<div class="alert alert-danger" role="alert">
		<%= error_invalid %>
	</div>
	<% } 
	   if ( error_uname != "" ) { %>
	<div class="alert alert-danger" role="alert">
		<%= error_uname %>
	</div>
	<% }
		if ( error_password != "" ) { %>
	<div class="alert alert-danger" role="alert">
		<%= error_password %>
	</div>
	<% } %>
		<div class="panel panel-default">
			<div class="panel-heading">
				Please login to continue
			</div>
			<div class="panel-body">
				User Name
				<input type="text" id="input_uname" name="input_uname" value="<%=uname%>" class="form-control">
				<br>
				Password
				<input type="password" id="input_password" name="input_password" class="form-control">
				<br>
				<input type="submit" name="submit" value="LOGIN" class="btn btn-primary">
			</div>
		</div>	
	</form>
</body>
</html>