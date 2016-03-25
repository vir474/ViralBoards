package com.viralboards.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.viralboards.controllers.ConnectionPool;
import com.viralboards.model.Account;
import com.viralboards.model.Forum;
import com.viralboards.model.Post;
import com.viralboards.model.Topic;
import com.viralborads.dao.ViralBoardsDAO;

public class ViralBoardsJdbcDAOImpl implements ViralBoardsDAO {

	private static ViralBoardsJdbcDAOImpl viralBoardsDAO = null;
	private ResultSet resultSet = null;
	private Statement statement = null;
	private Connection connection = null;
	private ConnectionPool pool = null;

	public static ViralBoardsDAO getViralBoardsDAO() {
		if (viralBoardsDAO == null) {
			viralBoardsDAO = new ViralBoardsJdbcDAOImpl();
		}
		return viralBoardsDAO;
	}

	private ConnectionPool getConnectionPool() {
		pool = ConnectionPool.getInstance("jdbc/VRINTW01");
		return pool;
	}

	private Connection openConnection() {
		ConnectionPool pool = getConnectionPool();
		connection = pool.getConnection();
		System.out.println("connection obj " + connection);
		return connection;
	}

	private void closeConnection(Connection connection) {
		if (connection != null) {
			pool.freeConnection(connection);
		}
	}

	@Override
	public Account findAccount(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveAccount(Account newaccount) {
		// TODO Auto-generated method stub
		boolean result = false;
		System.out.println("save account jdbcdao");
		connection = openConnection();
		try {
			statement = connection.createStatement();
			String template = "SELECT * FROM VRINTW01.Accounts WHERE USERNAME=? OR EMAIL=?";
			PreparedStatement ps = connection.prepareStatement(template);
			ps.setString(1, newaccount.getUserName());
			ps.setString(2, newaccount.getEmail());
			System.out.println("The query being run is: ");
			System.out.println(ps.toString());
			resultSet = ps.executeQuery();

			if (!resultSet.next()) {
				System.out.println("unique, valid to create a account");
				// valid -- create account

				String inserttemplate = "INSERT INTO VRINTW01.ACCOUNTS ( UID, USERNAME, PASSWORD, EMAIL ) VALUES (?,?,?,?)";
				PreparedStatement ps_ins = connection
						.prepareStatement(inserttemplate);
				ps_ins.setString(1, newaccount.getUserId());
				ps_ins.setString(2, newaccount.getUserName());
				ps_ins.setString(3, newaccount.getPassword());
				ps_ins.setString(4, newaccount.getEmail());
				int resultSet_ins = ps_ins.executeUpdate();
				result = true;
			} else {
				System.out.println("not unique, invalid to create a account");
				// not valid, disallow to create account

				do {
					System.out.println(resultSet.getString(1) + " "
							+ resultSet.getString(2) + " "
							+ resultSet.getString(3) + " "
							+ resultSet.getString(4));
				} while (resultSet.next());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(connection);
		return result;
	}

	@Override
	public Set findAccountsWithName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Forum findForum(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveForum(Forum newforum) {
		// TODO Auto-generated method stub
		int resultSet_ins = 0;
		System.out.println("save forum jdbcdao");
		connection = openConnection();
		try {
			statement = connection.createStatement();
			String template = "INSERT INTO VRINTW01.FORUMS ( FORUMID, FORUMNAME, CREATEDATE ) VALUES (?,?,?)";
			PreparedStatement ps = connection.prepareStatement(template);
			ps.setString(1, newforum.getForumId());
			ps.setString(2, newforum.getForumName());
			ps.setString(3, newforum.getForumCreateDate());
			System.out.println("The query being run is: ");
			System.out.println(ps.toString());
			resultSet_ins = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(connection);
		return (resultSet_ins>0);
	}

	@Override
	public boolean deleteForum(String forumid) {
		// TODO Auto-generated method stub
		System.out.println("jdbc DAO deleteforum");
		connection = openConnection();
		int rc = 0;
        String template = "DELETE FROM VRINTW01.FORUMS WHERE FORUMID = ?";
        try
        {
            PreparedStatement ps = connection.prepareStatement(template);
            ps.setString(1, forumid);
            rc = ps.executeUpdate();
            System.out.println("delete "+ forumid + " = " + "template" + ps);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
		System.out.println("delete returned " + rc);
		closeConnection(connection);
		return (rc > 0);
	}

	@Override
	public Topic findTopic(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveTopic(Topic newtopic) {
		// TODO Auto-generated method stub
		int resultSet_ins = 0;
		System.out.println("save topic jdbcdao");
		connection = openConnection();
		try {
			statement = connection.createStatement();
			String template = "INSERT INTO VRINTW01.TOPICS ( TOPICID, TOPICNAME, CREATEDATE, TOPICFORUMID, TOPICAUTHORID ) VALUES (?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(template);
			ps.setString(1, newtopic.getTopicId());
			ps.setString(2, newtopic.getTopicName());
			ps.setString(3, newtopic.getTopicCreateDate());
			ps.setString(4, newtopic.getTopicForumId());
			ps.setString(5, newtopic.getTopicAuthorId());
			System.out.println("The query being run is: ");
			System.out.println(ps.toString());
			resultSet_ins = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(connection);
		return (resultSet_ins>0);
	}

	@Override
	public boolean editTopicName(String topicid, String newtopicname) {
		// TODO Auto-generated method stub
		System.out.println("jdbc DAO edittopic");
		connection = openConnection();
		int rc = 0;
        String template = "UPDATE VRINTW01.TOPICS SET TOPICNAME = ? WHERE TOPICID = ?";
        try
        {
            PreparedStatement ps = connection.prepareStatement(template);
            ps.setString(1, newtopicname);
            ps.setString(2, topicid);
            rc = ps.executeUpdate();
            System.out.println("edit "+ topicid + " " + newtopicname + " = " + "template" + ps);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
		System.out.println("update returned " + rc);
		closeConnection(connection);
		return (rc > 0);
	}

	@Override
	public boolean deleteTopic(String topicid) {
		// TODO Auto-generated method stub
		System.out.println("jdbc DAO deletetopic");
		connection = openConnection();
		int rc = 0;
        String template = "DELETE FROM VRINTW01.TOPICS WHERE TOPICID = ?";
        try
        {
            PreparedStatement ps = connection.prepareStatement(template);
            ps.setString(1, topicid);
            rc = ps.executeUpdate();
            System.out.println("delete "+ topicid + " = " + "template" + ps);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
		System.out.println("delete returned " + rc);
		closeConnection(connection);
		return (rc > 0);
	}

	@Override
	public Post findPost(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean savePost(Post newpost) {
		// TODO Auto-generated method stub
		int resultSet_ins = 0;
		System.out.println("save post jdbcdao");
		connection = openConnection();
		try {
			statement = connection.createStatement();
			String template = "INSERT INTO VRINTW01.POSTS ( POSTID, POSTCONTENT, CREATEDATE, POSTTOPICID, POSTAUTHORID, POSTFORUMID ) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(template);
			ps.setString(1, newpost.getPostId());
			ps.setString(2, newpost.getPostContent());
			ps.setString(3, newpost.getPostCreateDate());
			ps.setString(4, newpost.getPostTopicId());
			ps.setString(5, newpost.getPostAuthorId());
			ps.setString(6, newpost.getPostForumId());
			System.out.println("The query being run is: ");
			System.out.println(ps.toString());
			resultSet_ins = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(connection);
		return (resultSet_ins>0);
	}

	@Override
	public boolean deletePost(String postid) {
		// TODO Auto-generated method stub
		System.out.println("jdbc DAO deletepost");
		connection = openConnection();
		
		int rc = 0;
        String template = "DELETE FROM POSTS WHERE POSTID = ?";
        try
        {
        	//Statement statement = connection.createStatement();
        	//rc = statement.executeUpdate(template);
            PreparedStatement ps = connection.prepareStatement(template);
            ps.setString(1, postid);
            rc = ps.executeUpdate();
            System.out.println("delete "+ postid + " = " + "template" + ps.toString());
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
		System.out.println("delete returned " + rc);
		closeConnection(connection);
		return (rc > 0);
	}

	@Override
	public Account authorizeUser(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("authorize User jdbcdao");
		Account user = null;
		connection = openConnection();
		try {
			statement = connection.createStatement();
			String template = "SELECT * FROM VRINTW01.Accounts WHERE USERNAME=? AND PASSWORD=?";
			PreparedStatement ps = connection.prepareStatement(template);
			ps.setString(1, username);
			ps.setString(2, password);
			System.out.println("The query being run is: ");
			System.out.println(ps.toString());
			resultSet = ps.executeQuery();

			if (!resultSet.next()) {
				System.out.println("authorization failed");
			} else {
				System.out.println("found user account");
				System.out.println(resultSet.getString(1) + " "
						+ resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getString(4));
				user = new Account(resultSet.getString(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
				while (resultSet.next()) {
					System.out.println(resultSet.getString(1) + " "
							+ resultSet.getString(2) + " "
							+ resultSet.getString(3) + " "
							+ resultSet.getString(4));
					// temp = new Account(resultSet.getString(1) ,
					// resultSet.getString(2), resultSet.getString(3),
					// resultSet.getString(4));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(connection);
		return user;
	}

	@Override
	public Account uniqueUser(String username, String email) {
		// TODO Auto-generated method stub
		System.out.println("unique user check jdbcdao");
		Account user = null;
		connection = openConnection();
		try {
			statement = connection.createStatement();
			String template = "SELECT * FROM VRINTW01.Accounts WHERE USERNAME=? OR EMAIL=?";
			PreparedStatement ps = connection.prepareStatement(template);
			ps.setString(1, username);
			ps.setString(2, email);
			System.out.println("The query being run is: ");
			System.out.println(ps.toString());
			resultSet = ps.executeQuery();

			if (!resultSet.next()) {
				System.out.println("unique user");
				// valid -- create account
			} else {
				System.out.println("not unique, invalid to create a account");
				// not valid, disallow to create account

				do {
					System.out.println(resultSet.getString(1) + " "
							+ resultSet.getString(2) + " "
							+ resultSet.getString(3) + " "
							+ resultSet.getString(4));
					user = new Account(resultSet.getString(1),
							resultSet.getString(2), resultSet.getString(3),
							resultSet.getString(4));
				} while (resultSet.next());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(connection);
		return user;
	}

	@Override
	public Set getForums() {
		// TODO Auto-generated method stub
		Set forums = new HashSet();
		connection = openConnection();
		try {
			statement = connection.createStatement();
			String sqlStatement = "SELECT * FROM FORUMS";
			resultSet = statement.executeQuery(sqlStatement);
			while (resultSet.next()) {
				System.out.println(resultSet.getString("forumid") + " " + resultSet.getString("forumname") + " " + resultSet.getDate("createdate"));
				Forum tempdata = new Forum(resultSet.getString("forumid"), resultSet.getString("forumname"), resultSet.getDate("createdate").toString());
				forums.add(tempdata);
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("Cannot execute query");
			e.printStackTrace();
		}
		System.out.println("Forum Set length : " + forums.size());
		closeConnection(connection);
		return forums;
	}

	@Override
	public boolean editForumName(String forumid, String newforumname) {
		// TODO Auto-generated method stub
		System.out.println("jdbc DAO editforum");
		connection = openConnection();
		int rc = 0;
        String template = "UPDATE VRINTW01.FORUMS SET FORUMNAME = ? WHERE FORUMID = ?";
        try
        {
            PreparedStatement ps = connection.prepareStatement(template);
            ps.setString(1, newforumname);
            ps.setString(2, forumid);
            rc = ps.executeUpdate();
            System.out.println("edit "+ forumid + " " + newforumname + " = " + "template" + ps);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
		System.out.println("update returned " + rc);
		closeConnection(connection);
		return (rc > 0);
	}

	@Override
	public Set getTopics(String forumid) {
		// TODO Auto-generated method stub
		Set topics = new HashSet();
		connection = openConnection();
		try {
			String sqlStatement = "SELECT * FROM Accounts INNER JOIN topics ON topics.topicauthorid=accounts.uid and topics.topicforumid = ?";
			PreparedStatement ps = connection.prepareStatement(sqlStatement);
            ps.setString(1, forumid);
			resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString("topicid") + " " + resultSet.getString("topicname") + " " + resultSet.getDate("createdate") + " " + resultSet.getString("username") + " " + resultSet.getString("topicforumid"));
				Topic tempdata = new Topic(resultSet.getString("topicid"), resultSet.getString("topicname"), resultSet.getDate("createdate").toString(), resultSet.getString("username"), resultSet.getString("topicforumid"));
				topics.add(tempdata);
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("Cannot execute query");
			e.printStackTrace();
		}
		System.out.println("Topics Set length : " + topics.size());
		closeConnection(connection);
		return topics;
	}

	@Override
	public Set getPosts(String topicid) {
		// TODO Auto-generated method stub
		Set posts = new HashSet();
		connection = openConnection();
		try {
			//String sqlStatement = "SELECT * FROM VRINTW01.POSTS WHERE POSTTOPICID = ?";
			String sqlStatement = "SELECT * FROM Accounts INNER JOIN posts ON posts.postauthorid=accounts.uid and posts.posttopicid = ?";
			PreparedStatement ps = connection.prepareStatement(sqlStatement);
            ps.setString(1, topicid);
			resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString("postid") + " " + resultSet.getString("postcontent") + " " + resultSet.getDate("createdate") + " " + resultSet.getString("username") + " " + resultSet.getString("posttopicid") + " " + resultSet.getString("postforumid"));
				Post tempdata = new Post(resultSet.getString("postid"), resultSet.getString("postcontent"), resultSet.getDate("createdate").toString(), resultSet.getString("posttopicid"), resultSet.getString("username"), resultSet.getString("postforumid"));
				posts.add(tempdata);
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("Cannot execute query");
			e.printStackTrace();
		}
		System.out.println("Posts Set length : " + posts.size());
		closeConnection(connection);
		return posts;
	}

	@Override
	public boolean editPostContent(String postid, String postcontent) {
		// TODO Auto-generated method stub
		System.out.println("jdbc DAO editpost");
		connection = openConnection();
		int rc = 0;
        String template = "UPDATE VRINTW01.POSTS SET POSTCONTENT = ? WHERE POSTID = ?";
        try
        {
            PreparedStatement ps = connection.prepareStatement(template);
            ps.setString(1, postcontent);
            ps.setString(2, postid);
            rc = ps.executeUpdate();
            System.out.println("edit "+ postid + " " + postcontent + " = " + "template" + ps);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
		System.out.println("update returned " + rc);
		closeConnection(connection);
		return (rc > 0);
	}
	
	public Set getPostsPagi(String topicid, String start, String stop) {
		// TODO Auto-generated method stub
		Set posts = new HashSet();
		connection = openConnection();
		try {
			String sqlStatement = "SELECT * FROM VRINTW01.POSTS WHERE POSTTOPICID = ?";
			PreparedStatement ps = connection.prepareStatement(sqlStatement);
            ps.setString(1, topicid);
			resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString("postid") + " " + resultSet.getString("postcontent") + " " + resultSet.getDate("createdate") + " " + resultSet.getString("postauthorid") + " " + resultSet.getString("posttopicid") + " " + resultSet.getString("postforumid"));
				Post tempdata = new Post(resultSet.getString("postid"), resultSet.getString("postcontent"), resultSet.getDate("createdate").toString(), resultSet.getString("posttopicid"), resultSet.getString("postauthorid"), resultSet.getString("postforumid"));
				posts.add(tempdata);
			}
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("Cannot execute query");
			e.printStackTrace();
		}
		System.out.println("Posts Set length : " + posts.size());
		closeConnection(connection);
		return posts;
	}
}
