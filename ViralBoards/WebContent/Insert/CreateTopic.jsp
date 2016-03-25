<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Topic</title>
<link rel="stylesheet" type="text/css" href="/ViralBoards/css/bootstrap.min.css">
</head>
<%
		String topicforumid = "";
		Object topicforumid_request = request.getAttribute("topicforumid");
		if (topicforumid_request != null) {
			topicforumid = topicforumid_request.toString();
		}
		Object topicforumid_request1 = request.getParameter("topicforumid");
		if (topicforumid_request1 != null) {
			topicforumid = topicforumid_request1.toString();
		}
		String error_topicname = "";
		Object error_topicname_request = request.getAttribute("error_topicname");
		if (error_topicname_request != null) {
			error_topicname = error_topicname_request.toString();
		}
		Object error_topicname_request1 = request.getParameter("error_topicname");
		if (error_topicname_request1 != null) {
			error_topicname = error_topicname_request1.toString();
		}
	%>
<body>
<br>
	<% if ( error_topicname != "" ) { %>
	<div class="alert alert-danger" role="alert">
		<%= error_topicname %>
	</div>
	<% } %>
	<form method="post" action="/ViralBoards/CreateTopicServlet">
		<input type="hidden" name="topicforumid" value="<%=topicforumid%>">
		<div class="panel panel-default">
			<div class="panel-heading">
				Create Topic
				<span class="pull-right">
					<a href="/ViralBoards/TopicsTableLoaderServlet?topicforumid=<%=topicforumid%>" class="btn btn-xs btn-danger">Cancel Insert</a>
				</span>
			</div>
			<div class="panel-body">
				Topic Name
				<input type="text" name="newtopicname" class="form-control">
				<br>
				<input type="submit" value="Create" class="btn btn-primary">
			</div>
		</div>
	</form> 
</body>
</html>