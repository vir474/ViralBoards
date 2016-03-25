package com.viralboards.util;

import java.util.Set;

import com.viralboards.model.Topic;

public class TopicsUtil {
	public static String getTopicTable(Set topics) {
		String temptopics = null;
		
		StringBuffer htmlRows = new StringBuffer();
        htmlRows.append("<table class=\"table\">");
        htmlRows.append("<tr>");
        htmlRows.append("<td><b>" + "TopicName" + "</td>");
        htmlRows.append("<td><b>" + "TopicCreated" + "</td>");
        htmlRows.append("<td><b>" + "TopicAuthor" + "</td>");
        htmlRows.append("<td><b>" + "EDIT" + "</td>");
        htmlRows.append("<td><b>" + "DELETE" + "</td>");
        htmlRows.append("</tr>");
        
        Object[] temp = topics.toArray();
        for (int i=0; i< temp.length; i++)
        {
        	htmlRows.append("<tr>");
            htmlRows.append("<td><a href=\"/ViralBoards/PostsTableLoaderServlet?posttopicid=" + ((Topic) temp[i]).getTopicId() + "&postforumid=" + ((Topic) temp[i]).getTopicForumId() + "\">" + ((Topic) temp[i]).getTopicName() + "</a></td>");
            htmlRows.append("<td>" + ((Topic) temp[i]).getTopicCreateDate() + "</td>");
            htmlRows.append("<td>" + ((Topic) temp[i]).getTopicAuthorId() + "</td>");
            htmlRows.append("<td><a href=\"/ViralBoards/Edit/EditTopic.jsp?topicid=" + ((Topic) temp[i]).getTopicId() + "&topicforumid=" + ((Topic) temp[i]).getTopicForumId() + "\">" + "Edit</a></td>");
            htmlRows.append("<td><a href=\"/ViralBoards/DeleteTopicServlet?topicid=" + ((Topic) temp[i]).getTopicId() + "&topicforumid=" + ((Topic) temp[i]).getTopicForumId() + "\">" + "Delete</a></td>");
            htmlRows.append("</tr>");
        }
        htmlRows.append("</table>");
		temptopics = htmlRows.toString();
        
		return temptopics;
	}
}
