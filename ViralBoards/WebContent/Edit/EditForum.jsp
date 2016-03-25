<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Forum</title>
<link rel="stylesheet" type="text/css" href="/ViralBoards/css/bootstrap.min.css">
</head>
<%
		String forumid = "";
		Object forumid_request = request.getAttribute("forumid");
		if (forumid_request != null) {
			forumid = forumid_request.toString();
		}
		Object forumid_request1 = request.getParameter("forumid");
		if (forumid_request1 != null) {
			forumid = forumid_request1.toString();
		}
		String error_forumname = "";
		Object error_forumname_request = request.getAttribute("error_forumname");
		if (error_forumname_request != null) {
			error_forumname = error_forumname_request.toString();
		}
		Object error_forumname_request1 = request.getParameter("error_forumname");
		if (error_forumname_request1 != null) {
			error_forumname = error_forumname_request1.toString();
		}
	%>
<body>
<br>
	<% if ( error_forumname != "" ) { %>
	<div class="alert alert-danger" role="alert">
		<%= error_forumname %>
	</div>
	<% } %>
	<form method="post" action="/ViralBoards/EditForumServlet">
		<input type="hidden" name="forumid" value="<%=forumid%>">
		<div class="panel panel-default">
			<div class="panel-heading">
				Edit Forum
				<span class="pull-right">
					<a href="/ViralBoards/ForumTableLoaderServlet" class="btn btn-xs btn-danger">Cancel Edit</a>
				</span>
			</div>
			<div class="panel-body">
				Forum Name
				<input type="text" name="newforumname" class="form-control">
				<br>
				<input type="submit" value="Update" class="btn btn-primary">
			</div>
		</div>
	</form> 
</body>
</html>