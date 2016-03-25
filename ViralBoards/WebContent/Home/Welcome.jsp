<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<link rel="stylesheet" type="text/css" href="/ViralBoards/css/bootstrap.min.css">
<body>
	<%
		String uname = "";
		String forums = "";
//		ArrayList<ForumModel> forumlist = null;
		Object uname_request = request.getAttribute("uname");
		if (uname_request != null) {
			uname = uname_request.toString();
		}
		Object forumlist_request = request.getAttribute("forums");
		if ( forumlist_request != null ) {
			forums = forumlist_request.toString();
		}
		String successful = "";
		Object successful_request = request.getAttribute("successful");
		if (successful_request != null) {
			successful = successful_request.toString();
		}
		Object successful_request1 = request.getParameter("successful");
		if ( successful_request1 != null ) {
			successful = successful_request1.toString();
		}
		String error_unsuccessful = "";
		Object error_unsuccessful_request = request.getAttribute("error_unsuccessful");
		if (error_unsuccessful_request != null) {
			error_unsuccessful = error_unsuccessful_request.toString();
		}
		Object error_unsuccessful_request1 = request.getParameter("error_unsuccessful");
		if ( error_unsuccessful_request1 != null ) {
			error_unsuccessful = error_unsuccessful_request1.toString();
		}
	%>
	<br>
	<% if ( error_unsuccessful != "" ) { %>
	<div class="alert alert-danger" role="alert">
		<%= error_unsuccessful %>
	</div>
	<% } %>
	<% if ( successful != "" ) { %>
	<div class="alert alert-success" role="alert">
		<%= successful %>
	</div>
	<% } %>
	<div class="panel panel-default">
	<div class="panel-heading">
	Forums
	<span class="pull-right"><a href="/ViralBoards/Insert/CreateForum.jsp" class="btn btn-xs btn-success">Create Forum</a></span>
	</div>
	<%= forums %>
	</div>
</body>
</html>