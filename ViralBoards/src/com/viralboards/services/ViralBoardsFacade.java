package com.viralboards.services;

import java.util.Set;

import com.viralboards.model.Account;
import com.viralboards.model.Forum;
import com.viralboards.model.Post;
import com.viralboards.model.Topic;

public interface ViralBoardsFacade {
	
	public Account findAccount(String id);
	public boolean createAccount(Account newaccount);
	public boolean doesAccountExist(String name);
	public Forum findForum(String id);
	public boolean createForum(Forum newforum);
	public boolean deleteForum(String forumid);
	public Topic findTopic(String id);
	public boolean createTopic(Topic newtopic);
	public boolean editTopicName(String topicid,String newtopicname);
	public boolean deleteTopic(String topicid);
	public Post findPost(String id);
	public boolean createPost(Post newpost);
	public boolean deletePost(String postid);
	public boolean editPostContent(String postid, String postcontent);
	public Account authorizeUser(String username, String password);
	public Set getForums();
	public boolean editForumName(String forumid, String newforumname);
	public Set getTopics(String forumid);
	public Set getPosts(String topicid);
}
