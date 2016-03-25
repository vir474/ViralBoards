<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Topic</title>
<link rel="stylesheet" type="text/css" href="/ViralBoards/css/bootstrap.min.css">
</head>
<%
		String topicid = "";
		String topicforumid = "";
		Object topicid_request = request.getAttribute("topicid");
		if (topicid_request != null) {
			topicid = topicid_request.toString();
		}
		Object topicid_request1 = request.getParameter("topicid");
		if (topicid_request1 != null) {
			topicid = topicid_request1.toString();
		}
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
	<form method="post" action="/ViralBoards/EditTopicServlet">
		<input type="hidden" name="topicid" value="<%=topicid%>">
		<input type="hidden" name="topicforumid" value="<%=topicforumid%>">
		<div class="panel panel-default">
			<div class="panel-heading">
				Edit Topic
				<span class="pull-right">
					<a href="/ViralBoards/TopicsTableLoaderServlet" class="btn btn-xs btn-danger">Cancel Edit</a>
				</span>
			</div>
			<div class="panel-body">
				Topic Name
				<input type="text" name="newtopicname" class="form-control">
				<br>
				<input type="submit" value="Update" class="btn btn-primary">
			</div>
		</div>
	</form> 
</body>
</html>