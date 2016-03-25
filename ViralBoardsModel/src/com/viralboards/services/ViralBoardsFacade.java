package com.viralboards.services;

import com.viralboards.model.Account;
import com.viralboards.model.Forum;
import com.viralboards.model.Post;
import com.viralboards.model.Topic;

public interface ViralBoardsFacade {
	
	public Account findAccount(String id);
	public boolean createAccount(Account newaccount);
	public boolean doesAccountExist(String name);
	public Forum findForum(String id);
	public boolean createForum(String id, Forum newforum);
	public boolean deleteForum(String id);
	public Topic findTopic(String id);
	public boolean createTopic(String id, Topic newtopic);
	public boolean editTopicName(String id,String newName);
	public boolean deleteTopic(String id);
	public Post findPost(String id);
	public boolean createPost(String id, Post newpost);
	public boolean deletePost(String id);
	
}
