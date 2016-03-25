package com.viralboards.util;

import java.util.Set;

import com.viralboards.model.Forum;

public class ForumsUtil {
	public static String getForumTable(Set forums) {
		String tempforums = null;
		
		StringBuffer htmlRows = new StringBuffer();
        htmlRows.append("<table class=\"table\">");
        htmlRows.append("<tr>");
        htmlRows.append("<td><b>" + "ForumName" + "</td>");
        htmlRows.append("<td><b>" + "ForumCreated" + "</td>");
        htmlRows.append("<td><b>" + "EDIT" + "</td>");
        htmlRows.append("<td><b>" + "DELETE" + "</td>");
        htmlRows.append("</tr>");
        
        Object[] temp = forums.toArray();
        for (int i=0; i< temp.length; i++)
        {
        	htmlRows.append("<tr>");
            htmlRows.append("<td><a href=\"/ViralBoards/TopicsTableLoaderServlet?topicforumid=" + ((Forum) temp[i]).getForumId() + "\">" + ((Forum) temp[i]).getForumName() + "</a></td>");
            htmlRows.append("<td>" + ((Forum) temp[i]).getForumCreateDate() + "</td>");
            htmlRows.append("<td><a href=\"/ViralBoards/Edit/EditForum.jsp?forumid=" + ((Forum) temp[i]).getForumId() + "\">" + "Edit</a></td>");
            htmlRows.append("<td><a href=\"/ViralBoards/DeleteForumServlet?forumid=" + ((Forum) temp[i]).getForumId() + "\">" + "Delete</a></td>");
            htmlRows.append("</tr>");
        }
        htmlRows.append("</table>");
		tempforums = htmlRows.toString();
        
		return tempforums;
	}
}
