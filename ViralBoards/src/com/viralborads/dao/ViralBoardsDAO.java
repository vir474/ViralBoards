package com.viralborads.dao;

import java.util.Set;

import com.viralboards.model.Account;
import com.viralboards.model.Forum;
import com.viralboards.model.Post;
import com.viralboards.model.Topic;

public interface ViralBoardsDAO {
	
	public Account findAccount(String id);
	public boolean saveAccount(Account newaccount);
	public Set findAccountsWithName(String name);
	public Forum findForum(String id);
	public boolean saveForum(Forum newforum);
	public boolean deleteForum(String forumid);
	public Topic findTopic(String id);
	public boolean saveTopic(Topic newtopic);
	public boolean editTopicName(String topicid, String newtopicname);
	public boolean deleteTopic(String topicid);
	public Post findPost(String id);
	public boolean savePost(Post newpost);
	public boolean deletePost(String postid);
	public Account authorizeUser(String username, String password);
	public Account uniqueUser(String username, String email);
	public Set getForums();
	public boolean editForumName(String forumid, String newforumname);
	public Set getTopics(String forumid);
	public Set getPosts(String topicid);
	public boolean editPostContent(String postid, String postcontent);
	
}
