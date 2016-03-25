<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Post</title>
<link rel="stylesheet" type="text/css" href="/ViralBoards/css/bootstrap.min.css">
</head>
<%
		String posttopicid = "";
		Object posttopicid_request = request.getAttribute("posttopicid");
		if (posttopicid_request != null) {
			posttopicid = posttopicid_request.toString();
		}
		Object posttopicid_request1 = request.getParameter("posttopicid");
		if (posttopicid_request1 != null) {
			posttopicid = posttopicid_request1.toString();
		}
		String postforumid = "";
		Object postforumid_request = request.getAttribute("postforumid");
		if (postforumid_request != null) {
			postforumid = postforumid_request.toString();
		}
		Object postforumid_request1 = request.getParameter("postforumid");
		if (postforumid_request1 != null) {
			postforumid = postforumid_request1.toString();
		}
		String error_postcontent = "";
		Object error_postcontent_request = request.getAttribute("error_postcontent");
		if (error_postcontent_request != null) {
			error_postcontent = error_postcontent_request.toString();
		}
		Object error_postcontent_request1 = request.getParameter("error_postcontent");
		if (error_postcontent_request1 != null) {
			error_postcontent = error_postcontent_request1.toString();
		}
	%>
<body>
<br>
	<% if ( error_postcontent != "" ) { %>
	<div class="alert alert-danger" role="alert">
		<%= error_postcontent %>
	</div>
	<% } %>
	<form method="post" action="/ViralBoards/CreatePostServlet">
		<input type="hidden" name="postforumid" value="<%=postforumid%>">
		<input type="hidden" name="posttopicid" value="<%=posttopicid%>">
		<div class="panel panel-default">
			<div class="panel-heading">
				Create Post
				<span class="pull-right">
					<a href="/ViralBoards/PostsTableLoaderServlet?posttopicid=<%=posttopicid%>&postforumid=<%=postforumid%>" class="btn btn-xs btn-danger">Cancel Insert</a>
				</span>
			</div>
			<div class="panel-body">
				Post Content
				<input type="text" name="newpostcontent" class="form-control">
				<br>
				<input type="submit" value="Create" class="btn btn-primary">
			</div>
		</div>
	</form> 
</body>
</html>