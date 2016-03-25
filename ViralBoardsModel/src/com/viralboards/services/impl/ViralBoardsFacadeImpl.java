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
		if (doesAccountExist(newaccount.getUserName()))
            return false;
		
		Calendar now = Calendar.getInstance();
    	String unique = Long.toString(now.getTimeInMillis());
    	unique = "u" + unique;
        viralboardsDAO.saveAccount(unique,newaccount);
        return true;
	}

	@Override
	public boolean doesAccountExist(String name) {
		// TODO Auto-generated method stub
		Set allAccounts = viralboardsDAO.findAccountsWithName(name);
        return allAccounts.size() > 0;

	}

	@Override
	public boolean createForum(String id, Forum newforum) {
		// TODO Auto-generated method stub
		if ( viralboardsDAO.findForum(id) != null ) {
			viralboardsDAO.saveForum(id, newforum);
			return true;
		}
		else return false;
	}

	@Override
	public boolean deleteForum(String id) {
		// TODO Auto-generated method stub
		if ( viralboardsDAO.findForum(id) != null ) {
			viralboardsDAO.deleteForum(id);
		}
		return true;
	}

	@Override
	public boolean createTopic(String id, Topic newtopic) {
		// TODO Auto-generated method stub
		if ( viralboardsDAO.findTopic(id) == null ) {
			viralboardsDAO.saveTopic(id, newtopic);
			return true;
		}
		else return false;
	}

	@Override
	public boolean editTopicName(String id, String newName) {
		// TODO Auto-generated method stub
		if ( viralboardsDAO.findTopic(id) != null ) {
			viralboardsDAO.editTopicName(id, newName);
			return true;
		}
		else return false;
	}

	@Override
	public boolean deleteTopic(String id) {
		// TODO Auto-generated method stub
		if ( viralboardsDAO.findTopic(id) != null ) {
			viralboardsDAO.deleteTopic(id);
			return true;
		}
		else return false;
	}

	@Override
	public boolean createPost(String id, Post newpost) {
		// TODO Auto-generated method stub
		if ( viralboardsDAO.findPost(id) == null ) {
			viralboardsDAO.savePost(id, newpost);
			return true;
		}
		else return false;
	}

	@Override
	public boolean deletePost(String id) {
		// TODO Auto-generated method stub
		if ( viralboardsDAO.findTopic(id) != null ) {
			viralboardsDAO.deleteTopic(id);
			return true;
		}
		else return false;
		}
}
