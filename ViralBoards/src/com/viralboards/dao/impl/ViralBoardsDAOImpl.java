package com.viralboards.dao.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.viralboards.model.Account;
import com.viralboards.model.Forum;
import com.viralboards.model.Post;
import com.viralboards.model.Topic;
import com.viralborads.dao.ViralBoardsDAO;

public class ViralBoardsDAOImpl implements ViralBoardsDAO{
	private static ViralBoardsDAOImpl ViralBoardsDAO = null;
	private HashMap<String, Account> Accounts = new HashMap<String, Account>();
	private HashMap<String, Forum> Forums = new HashMap<String, Forum>();
	private HashMap<String, Topic> Topics = new HashMap<String, Topic>();
	private HashMap<String, Post> Posts = new HashMap<String, Post>();
	
	public static ViralBoardsDAO getViralBoardsDAO() {
		if ( ViralBoardsDAO == null ) {
			ViralBoardsDAO = new ViralBoardsDAOImpl();
			try{
				ViralBoardsDAO.init();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ViralBoardsDAO;
	}
	
	private void init() {
		Account acc1 = new Account("u_3464377", "Rooney", "rooney@yahoo.com", "rooneyL9#");
		Account acc2 = new Account("u_34346356", "DEGea", "de.gea@yahoo.com", "degeaL9#");
		Accounts.put(new String("u_3464377"),acc1);
		Accounts.put(new String("u_34346356"),acc2);
		
		Forum fr1 = new Forum("f_568569", "Android", "02/10/2015");
		Forum fr2 = new Forum("f_54364", "IOS", "01/16/2015");
		Forums.put(new String("f_568569"), fr1);
		Forums.put(new String("f_54364"), fr2);
		
		Topic tp1 = new Topic("t_45642", "ROMDevelopment", "03/20/2015", "u_3464377", "f_568569");
		Topic tp2 = new Topic("t_475898", "JAILBreaking", "03/02/2015", "u_34346356", "f_54364");
		Topics.put(new String("t_45642"), tp1);
		Topics.put(new String("t_475898"), tp2);
		
		Post po1 = new Post("p_4567457", "kasjhfkasjh ANDROID ashfkjash khask jhaksj asfs", "04/01/2015", "t_45642", "u_34346356", "f_568569");
		Post po2 = new Post("p_2345236", "kasjhfkasj ANDROID kasjhfhfhh kjvjahsjkbvuiawraefssf asdfasgah", "04/02/2015", "t_45642", "u_34346356", "f_568569");
		Post po3 = new Post("p_123789765", "IOS kjash kljas breaking ahsfj lak fkas flkasjf", "04/01/2015", "t_475898", "u_3464377", "f_54364");
		Post po4 = new Post("p_43568987", "IOS kjash tuff sakjf k difficult breaking ahsfj lak fkas flkasjf", "04/09/2015", "t_475898", "u_3464377", "f_54364");
		Posts.put(new String("p_4567457"), po1);
		Posts.put(new String("p_2345236"), po2);
		Posts.put(new String("p_123789765"), po3);
		Posts.put(new String("p_43568987"), po4);
	}
	
	@Override
	public Account findAccount(String id) {
		// TODO Auto-generated method stub
		Object temp = Accounts.get(id);
		return (Account) temp;
	}

	@Override
	public Forum findForum(String id) {
		// TODO Auto-generated method stub
		Object temp = Forums.get(id);
		return (Forum) temp;
	}

	public void saveForum(String id, Forum newforum) {
		// TODO Auto-generated method stub
		Forums.put(id, newforum);
	}

	@Override
	public Topic findTopic(String id) {
		// TODO Auto-generated method stub
		Object temp = Topics.get(id);
		return (Topic) temp;
	}

	public void saveTopic(String id, Topic newtopic) {
		// TODO Auto-generated method stub
		Topics.put(id, newtopic);
	}

	@Override
	public Post findPost(String id) {
		// TODO Auto-generated method stub
		Object temp = Posts.get(id);
		return (Post) temp;
	}

	public void savePost(String id, Post newpost) {
		// TODO Auto-generated method stub
		Posts.put(id, newpost);
	}

	@Override
	public Set findAccountsWithName(String name) {
		// TODO Auto-generated method stub
		Set results = new HashSet();
        Iterator leagueIterator = Accounts.values().iterator();
        while (leagueIterator.hasNext())
        {
            Account aAccount = (Account) leagueIterator.next();
            if (name.equals(aAccount.getUserName()))
                results.add(aAccount);
        }
        return results;
	}
/*
	public void deleteForum(String id) {
		// TODO Auto-generated method stub
		Forum temp = findForum(id);
		if( temp != null ) {
			Forums.remove(id);
		}
	}

	public void editTopicName(String id, String newName) {
		// TODO Auto-generated method stub
		Topic temp = findTopic(id);
		if ( temp != null ) {
			temp.setTopicName(newName);
		}
	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		Topic temp = findTopic(id);
		if ( temp != null ) {
			Topics.remove(id);
		}
	}

	public void deletePost(String id) {
		// TODO Auto-generated method stub
		Post temp = findPost(id);
		if ( temp != null ) {
			Posts.remove(id);
		}
	}
*/
	@Override
	public Account authorizeUser(String username, String password) {
		// TODO Auto-generated method stub
		Account user = null;
	//	LoginController loginController = new LoginController();
	//	user = loginController.authorizeUser(username, password);
		return user;
	}

	@Override
	public boolean saveAccount(Account newaccount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account uniqueUser(String username, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveForum(Forum newforum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteForum(String forumid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveTopic(Topic newtopic) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editTopicName(String topicid, String newtopicname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTopic(String topicid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean savePost(Post newpost) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePost(String postid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set getForums() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editForumName(String forumid, String newforumname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set getTopics(String forumid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set getPosts(String topicid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editPostContent(String postid, String postcontent) {
		// TODO Auto-generated method stub
		return false;
	}
}
