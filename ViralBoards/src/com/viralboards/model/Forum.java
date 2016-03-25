package com.viralboards.model;

public class Forum {
	private String forumid;
	private String forumname;
	private String forumcreatedate;
	
	public Forum(String id, String name, String createdate) {
		setForumId(id);
		setForumName(name);
		setForumCreateDate(createdate);
	}
	public void setForumId(String id) {
		this.forumid = id;
	}
	public String getForumId() {
		return forumid;
	}
	public void setForumName(String name) {
		this.forumname = name;
	}
	public String getForumName() {
		return forumname;
	}
	public void setForumCreateDate(String createdate) {
		this.forumcreatedate = createdate;
	}
	public String getForumCreateDate() {
		return forumcreatedate;
	}
}
