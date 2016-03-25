package com.viralboards.model;

public class Topic {
	private String topicid;
	private String topicname;
	private String topiccreatedate;
	private String topicauthorid;
	private String topicforumid;
	
	public Topic(String id, String name, String createdate, String authorid, String forumid) {
		setTopicId(id);
		setTopicName(name);
		setTopicCreateDate(createdate);
		setTopicAuthorId(authorid);
		setTopicForumId(forumid);
	}
	public void setTopicId(String id) {
		this.topicid = id;
	}
	public String getTopicId() {
		return topicid;
	}
	public void setTopicName(String name) {
		this.topicname = name;
	}
	public String getTopicName() {
		return topicname;
	}
	public void setTopicCreateDate(String createdate) {
		this.topiccreatedate = createdate;
	}
	public String getTopicCreateDate() {
		return topiccreatedate;
	}
	public void setTopicAuthorId(String id) {
		this.topicauthorid = id;
	}
	public String getTopicAuthorId() {
		return topicauthorid;
	}
	public void setTopicForumId(String id) {
		this.topicforumid = id;
	}
	public String getTopicForumId() {
		return topicforumid;
	}

}
