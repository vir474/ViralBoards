<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
	String title = "Home";
	String page_render = "";
	Object pagerender_obj = request.getAttribute("page_render");

	if ( pagerender_obj != null ) {
		page_render = pagerender_obj.toString();
	}
	
	Object pagerender_obj1 = request.getParameter("page_render");
	if ( pagerender_obj1 != null ) {
		page_render = pagerender_obj1.toString();
	}
	
	if ( page_render.equalsIgnoreCase("Login" ) ) {
		try {
			request.getSession().removeAttribute("usersession");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=title%> ViralBoards</title>
<link rel="stylesheet" type="text/css" href="/ViralBoards/css/bootstrap.min.css">
</head>
<body>
	<table align="center">
		<tr>
			<td class="page-header"><h1>ViralBoards</h1></td>
		</tr>
	</table>
	<nav class="navbar navbar-default">
  	<div class="container-fluid">
	<ul class="nav navbar-nav">
		<% if ( request.getSession().getAttribute("usersession") != null ) {
		%>
		<li class="navbaritem"><a href="/ViralBoards/ForumTableLoaderServlet">Home</a></li>
		<li class="navbaritem"><a
			href="/ViralBoards/Shared/Layout.jsp?page_render=Login">LogOut</a></li>
		<% 
		   }
		else {
		%>
		<li class="navbaritem"><a href="/ViralBoards/Shared/Layout.jsp?page_render=Menu">Home</a></li>
		<li class="navbaritem"><a
			href="/ViralBoards/Shared/Layout.jsp?page_render=Login">Login</a></li>
		<li class="navbaritem"><a
			href="/ViralBoards/Shared/Layout.jsp?page_render=Register">Register</a></li>
		<% } %>
    </ul>
    </div>
    </nav>
    <%
		if ( page_render.equalsIgnoreCase("Menu") ) {
			%>
	<jsp:include page="/Home/Menu.jsp" />
	<% 
		}
		else if ( page_render.equalsIgnoreCase("Login") ) {
			%>
	<jsp:include page="/Home/Login.jsp" />
	<% 
		}
		else if ( page_render.equalsIgnoreCase("Register") ) {
			%>
	<jsp:include page="/Home/Register.jsp" />
	<%
		}
		else if ( page_render.equalsIgnoreCase("Welcome") ) {
			%>
	<jsp:include page="/Home/Welcome.jsp" />
	<%
		}
		else if ( page_render.equalsIgnoreCase("Topics") ) {
	%>
	<jsp:include page="/Display/Topics.jsp" />
	<%
		}
		else if ( page_render.equalsIgnoreCase("Posts") ) {
	%>
	<jsp:include page="/Display/Posts.jsp" />
	<% 
		}
		else {
			if ( request.getSession().getAttribute("usersession") != null ) {
	%>
				<jsp:include page="/ForumTableLoaderServlet"/>
	<%
			}
			else {
	%>
				<jsp:include page="/Home/Menu.jsp" />
	<% 			
			}
		}
    %>
</body>
</html>