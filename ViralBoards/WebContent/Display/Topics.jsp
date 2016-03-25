<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Topics</title>
</head>
<link rel="stylesheet" type="text/css" href="/ViralBoards/css/bootstrap.min.css">
<body>
	<%
		String topics = "";
		Object topics_request = request.getAttribute("topics");
		if (topics_request != null) {
			topics = topics_request.toString();
		}
		Object topics_request1 = request.getAttribute("topics");
		if ( topics_request1 != null ) {
			topics = topics_request1.toString();
		}
		String topicforumid = "";
		Object topicforumid_request = request.getAttribute("topicforumid");
		if (topicforumid_request != null) {
			topicforumid = topicforumid_request.toString();
		}
		Object topicforumid_request1 = request.getAttribute("topicforumid");
		if ( topicforumid_request1 != null ) {
			topicforumid = topicforumid_request1.toString();
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
	Topics
	<span class="pull-right"><a href="/ViralBoards/Insert/CreateTopic.jsp?topicforumid=<%=topicforumid%>" class="btn btn-xs btn-success">Create Topic</a></span>
	</div>
	<%= topics %>
	</div>
</body>
</html>