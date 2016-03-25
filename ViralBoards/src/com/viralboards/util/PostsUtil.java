package com.viralboards.util;

import java.util.Set;

import com.viralboards.model.Post;
import com.viralboards.model.Topic;

public class PostsUtil {
	public static String getPostTable(Set posts) {
		String tempposts = null;
		
		StringBuffer htmlRows = new StringBuffer();
        htmlRows.append("<table class=\"table\">");
        htmlRows.append("<tr>");
        htmlRows.append("<td><b>" + "Post" + "</td>");
        htmlRows.append("<td><b>" + "PostCreated" + "</td>");
        htmlRows.append("<td><b>" + "PostAuthor" + "</td>");
        htmlRows.append("<td><b>" + "EDIT" + "</td>");
        htmlRows.append("<td><b>" + "DELETE" + "</td>");
        htmlRows.append("</tr>");
        
        Object[] temp = posts.toArray();
        for (int i=0; i< temp.length; i++)
        {
        	htmlRows.append("<tr>");
            htmlRows.append("<td>" + ((Post) temp[i]).getPostContent() + "</td>");
            htmlRows.append("<td>" + ((Post) temp[i]).getPostCreateDate() + "</td>");
            htmlRows.append("<td>" + ((Post) temp[i]).getPostAuthorId() + "</td>");
            htmlRows.append("<td><a href=\"/ViralBoards/Edit/EditPost.jsp?postid=" + ((Post) temp[i]).getPostId() + "&posttopicid=" + ((Post) temp[i]).getPostTopicId() + "&postforumid=" + ((Post) temp[i]).getPostForumId() + "\">" + "Edit</a></td>");
            htmlRows.append("<td><a href=\"/ViralBoards/DeletePostServlet?postid=" + ((Post) temp[i]).getPostId() + "&posttopicid=" + ((Post) temp[i]).getPostTopicId() + "&postforumid=" + ((Post) temp[i]).getPostForumId() + "\">" + "Delete</a></td>");
            htmlRows.append("</tr>");
        }
        htmlRows.append("</table>");
		tempposts = htmlRows.toString();
        
		return tempposts;
	}
}
