<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Posts</title>
</head>
<link rel="stylesheet" type="text/css" href="/ViralBoards/css/bootstrap.min.css">
<body>
	<%
		String posts = "";
		Object posts_request = request.getAttribute("posts");
		if (posts_request != null) {
			posts = posts_request.toString();
		}
		Object posts_request1 = request.getParameter("posts");
		if ( posts_request1 != null ) {
			posts = posts_request1.toString();
		}
		String posttopicid = "";
		Object posttopicid_request = request.getAttribute("posttopicid");
		if (posttopicid_request != null) {
			posttopicid = posttopicid_request.toString();
		}
		Object posttopicid_request1 = request.getParameter("posttopicid");
		if ( posttopicid_request1 != null ) {
			posttopicid = posttopicid_request1.toString();
		}
		String postforumid = "";
		Object postforumid_request = request.getAttribute("postforumid");
		if (postforumid_request != null) {
			postforumid = postforumid_request.toString();
		}
		Object postforumid_request1 = request.getParameter("postforumid");
		if ( postforumid_request1 != null ) {
			postforumid = postforumid_request1.toString();
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
	Posts
	<span class="pull-right"><a href="/ViralBoards/Insert/CreatePost.jsp?posttopicid=<%=posttopicid%>&postforumid=<%=postforumid%>" class="btn btn-xs btn-success">Create Post</a></span>
	</div>
	<%= posts %>
	</div>
</body>
</html>