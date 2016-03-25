package com.viralboards.services.impl;

import java.util.Calendar;
import java.util.Set;

import com.viralboards.model.Account;
import com.viralboards.model.Forum;
import com.viralboards.model.Post;
import com.viralboards.model.Topic;
import com.viralboards.services.ViralBoardsFacade;
import com.viralborads.dao.ViralBoardsDAO;

public class ViralBoardsFacadeImpl implements ViralBoardsFacade {

	private ViralBoardsDAO viralboardsDAO;
	
	public ViralBoardsDAO getViralBoardsDAO() {
		return viralboardsDAO;
	}
	
	public void setViralBoardsDAO(ViralBoardsDAO viralboardsDAO) {
		this.viralboardsDAO = viralboardsDAO;
	}
	
	@Override
	public Account findAccount(String id) {
		// TODO Auto-generated method stub
		return viralboardsDAO.findAccount(id);
	}

	@Override
	public Forum findForum(String id) {
		// TODO Auto-generated method stub
		return viralboardsDAO.findForum(id);
	}
/*
	@Override
	public void saveForum(String id, Forum newforum) {
		// TODO Auto-generated method stub
		viralboardsDAO.saveForum(id, newforum);
	}
*/
	@Override
	public Topic findTopic(String id) {
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	public void saveTopic(String id, Topic newtopic) {
		// TODO Auto-generated method stub

	}
*/
	@Override
	public Post findPost(String id) {
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	public void savePost(String id, Post newpost) {
		// TODO Auto-generated method stub

	}
*/

	@Override
	public boolean createAccount(Account newaccount) {
		// TODO Auto-generated method stub
		System.out.println("create account facade");
		if (uniqueUser(newaccount.getUserName(), newaccount.getEmail()) != null ) {
            return false;
		}
		else {
			Calendar now = Calendar.getInstance();
	    	String unique = Long.toString(now.getTimeInMillis());
	    	unique = "u_" + unique;
	    	newaccount.setUserId(unique);
	        viralboardsDAO.saveAccount(newaccount);
	        return true;
		}
	}

	private Account uniqueUser(String username, String email) {
		// TODO Auto-generated method stub
		System.out.println("facade uniqueuser");
		Account user = null;
		user = viralboardsDAO.uniqueUser(username, email);
		return user;
	}

	@Override
	public boolean doesAccountExist(String name) {
		// TODO Auto-generated method stub
		Set allAccounts = viralboardsDAO.findAccountsWithName(name);
        return allAccounts.size() > 0;
	}
	
	public Account authorizeUser(String username, String password) {
		System.out.println("authorize user facade impl");
		Account account = null;
		account = viralboardsDAO.authorizeUser(username, password);
		return account;
	}

	@Override
	public boolean createForum(Forum newforum) {
		// TODO Auto-generated method stub
		System.out.println("facade createforum");
		boolean create = false;
		Calendar now = Calendar.getInstance();
    	String unique = Long.toString(now.getTimeInMillis());
    	unique = "f_" + unique;
		newforum.setForumId(unique);
		int year = now.get(Calendar.YEAR);
	    int month = now.get(Calendar.MONTH) + 1;
	    int day = now.get(Calendar.DAY_OF_MONTH);
	    String createdate = year + "-" + month + "-" + day;
	    newforum.setForumCreateDate(createdate);
		create = viralboardsDAO.saveForum(newforum);
		return create;
	}

	@Override
	public boolean deleteForum(String forumid) {
		// TODO Auto-generated method stub
	/*	if ( viralboardsDAO.findForum(forumid) != null ) {
			viralboardsDAO.deleteForum(forumid);
		}
	*/
		System.out.println("facade deleteforum");
		boolean delete = false;
		delete = viralboardsDAO.deleteForum(forumid);
		return delete;
	}

	@Override
	public boolean createTopic(Topic newtopic) {
		// TODO Auto-generated method stub
		System.out.println("facade createtopic");
		boolean create = false;
		Calendar now = Calendar.getInstance();
    	String unique = Long.toString(now.getTimeInMillis());
    	unique = "t_" + unique;
		newtopic.setTopicId(unique);
		int year = now.get(Calendar.YEAR);
	    int month = now.get(Calendar.MONTH) + 1;
	    int day = now.get(Calendar.DAY_OF_MONTH);
	    String createdate = year + "-" + month + "-" + day;
	    newtopic.setTopicCreateDate(createdate);
		create = viralboardsDAO.saveTopic(newtopic);
		return create;
	}

	@Override
	public boolean editTopicName(String id, String newName) {
		// TODO Auto-generated method stub
		System.out.println("facade edittopic");
		boolean edit = false;
	//	if ( viralboardsDAO.findTopic(id) != null ) {
		edit = viralboardsDAO.editTopicName(id, newName);
	//		return true;
	//	}
		return edit;
	}

	@Override
	public boolean deleteTopic(String topicid) {
		// TODO Auto-generated method stub
	/*	if ( viralboardsDAO.findTopic(id) != null ) {
			viralboardsDAO.deleteTopic(id);
			return true;
		}	
		else return false;
	*/
		System.out.println("facade deletetopic");
		boolean delete = false;
		delete = viralboardsDAO.deleteTopic(topicid);
		return delete;
	}

	@Override
	public boolean createPost(Post newpost) {
		// TODO Auto-generated method stub
		System.out.println("facade createpost");
		boolean create = false;
		Calendar now = Calendar.getInstance();
    	String unique = Long.toString(now.getTimeInMillis());
    	unique = "p_" + unique;
		newpost.setPostId(unique);
		int year = now.get(Calendar.YEAR);
	    int month = now.get(Calendar.MONTH) + 1;
	    int day = now.get(Calendar.DAY_OF_MONTH);
	    String createdate = year + "-" + month + "-" + day;
	    newpost.setPostCreateDate(createdate);
		create = viralboardsDAO.savePost(newpost);
		return create;
	}

	@Override
	public boolean deletePost(String postid) {
		// TODO Auto-generated method stub
	/*	if ( viralboardsDAO.findTopic(id) != null ) {
			viralboardsDAO.deleteTopic(id);
			return true;
		}
		else return false;
	*/
			System.out.println("facade deletepost");
			boolean delete = false;
			delete = viralboardsDAO.deletePost(postid);
			return delete;
	}

	@Override
	public Set getForums() {
		// TODO Auto-generated method stub
		System.out.println("facade getforums");
		Set forums = null;
		forums = viralboardsDAO.getForums();
		return forums;
	}

	@Override
	public boolean editForumName(String forumid, String newforumname) {
		// TODO Auto-generated method stub
		System.out.println("facade editforum");
		boolean edit = false;
		edit = viralboardsDAO.editForumName(forumid, newforumname);
		return edit;
	}

	@Override
	public Set getTopics(String forumid) {
		// TODO Auto-generated method stub
		System.out.println("facade gettopics");
		Set topics = null;
		topics = viralboardsDAO.getTopics(forumid);
		return topics;
	}

	@Override
	public Set getPosts(String topicid) {
		// TODO Auto-generated method stub
		System.out.println("facade getposts");
		Set posts = null;
		posts = viralboardsDAO.getPosts(topicid);
		return posts;
	}

	@Override
	public boolean editPostContent(String postid, String postcontent) {
		// TODO Auto-generated method stub
		System.out.println("facade editpost");
		boolean edit = false;
		edit = viralboardsDAO.editPostContent(postid, postcontent);
		return edit;
	}
	
	public Set getPostsPagi(String topicid, int start, int stop) {
		// TODO Auto-generated method stub
		System.out.println("facade getposts");
		Set posts = null;
		//posts = viralboardsDAO.getPostsPagi(topicid,start,stop);
		return posts;
	}
}
