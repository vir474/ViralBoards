package com.viralboards.model;

public class Post {
	private String postid;
	private String postcontent;
	private String postcreatedate;
	private String posttopicid;
	private String postauthorid;
	private String postforumid;
	
	public Post(String id, String content, String createdate, String topicid, String authorid, String forumid) {
		setPostId(id);
		setPostContent(content);
		setPostCreateDate(createdate);
		setPostTopicId(topicid);
		setPostAuthorId(authorid);
		setPostForumId(forumid);
	}
	public void setPostId(String id) {
		this.postid = id;
	}
	public String getPostId() {
		return postid;
	}
	public void setPostContent(String content) {
		this.postcontent = content;
	}
	public String getPostContent() {
		return postcontent;
	}
	public void setPostCreateDate(String createdate) {
		this.postcreatedate = createdate;
	}
	public String getPostCreateDate() {
		return postcreatedate;
	}
	public void setPostTopicId(String id) {
		this.posttopicid = id;
	}
	public String getPostTopicId() {
		return posttopicid;
	}
	public void setPostAuthorId(String id) {
		this.postauthorid = id;
	}
	public String getPostAuthorId() {
		return postauthorid;
	}
	public void setPostForumId(String id) {
		this.postforumid = id;
	}
	public String getPostForumId() {
		return postforumid;
	}
}
