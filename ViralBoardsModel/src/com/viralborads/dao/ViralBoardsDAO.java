package com.viralborads.dao;

import java.util.Set;

import com.viralboards.model.Account;
import com.viralboards.model.Forum;
import com.viralboards.model.Post;
import com.viralboards.model.Topic;

public interface ViralBoardsDAO {
	
	public Account findAccount(String id);
	public void saveAccount(String id, Account newaccount);
	public Set findAccountsWithName(String name);
	public Forum findForum(String id);
	public void saveForum(String id, Forum newforum);
	public void deleteForum(String id);
	public Topic findTopic(String id);
	public void saveTopic(String id, Topic newtopic);
	public void editTopicName(String id, String newName);
	public void deleteTopic(String id);
	public Post findPost(String id);
	public void savePost(String id, Post newpost);
	public void deletePost(String id);
	
}
