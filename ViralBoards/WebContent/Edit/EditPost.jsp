<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Post</title>
<link rel="stylesheet" type="text/css" href="/ViralBoards/css/bootstrap.min.css">
</head>
<%
		String postid = "";
		String posttopicid = "";
		Object postid_request = request.getAttribute("postid");
		if (postid_request != null) {
			postid = postid_request.toString();
		}
		Object postid_request1 = request.getParameter("postid");
		if (postid_request1 != null) {
			postid = postid_request1.toString();
		}
		Object posttopicid_request = request.getAttribute("posttopicid");
		if (posttopicid_request != null) {
			posttopicid = posttopicid_request.toString();
		}
		Object posttopicid_request1 = request.getParameter("posttopicid");
		if (posttopicid_request1 != null) {
			posttopicid = posttopicid_request1.toString();
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
	<form method="post" action="/ViralBoards/EditPostServlet">
		<input type="hidden" name="postid" value="<%=postid%>">
		<input type="hidden" name="posttopicid" value="<%=posttopicid%>">
		<div class="panel panel-default">
			<div class="panel-heading">
				Edit Post
				<span class="pull-right">
					<a href="/ViralBoards/PostsTableLoaderServlet" class="btn btn-xs btn-danger">Cancel Edit</a>
				</span>
			</div>
			<div class="panel-body">
				Post Content
				<input type="text" name="postcontent" class="form-control">
				<br>
				<input type="submit" value="Update" class="btn btn-primary">
			</div>
		</div>
	</form> 
</body>
</html>