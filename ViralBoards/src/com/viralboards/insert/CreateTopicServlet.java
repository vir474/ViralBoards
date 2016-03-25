package com.viralboards.insert;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viralboards.dao.impl.ViralBoardsJdbcDAOImpl;
import com.viralboards.model.Topic;
import com.viralboards.services.ViralBoardsFacade;
import com.viralboards.services.impl.ViralBoardsFacadeImpl;
import com.viralboards.util.TopicsUtil;

/**
 * Servlet implementation class CreateTopicServlet
 */
@WebServlet("/CreateTopicServlet")
public class CreateTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Create Topic Servlet do get");
		//establishDBConnection();

		String url = "/Shared/Layout.jsp";
		String page_render = "";
		String topicname = request.getParameter("newtopicname");
		String topicforumid = request.getParameter("topicforumid");

		if ( request.getSession().getAttribute("usersession") != null ) {	

			if (topicname == null || topicname.trim().length() == 0)
			{
				request.setAttribute("topicforumid", topicforumid);
				request.setAttribute("error_topicname", "Topic Name must not be empty");
				url = "/Insert/CreateTopic.jsp";
			}
			else
			{
				String authorid = request.getSession().getAttribute("usersession").toString();
				Topic temptopic = new Topic("", topicname, "", authorid, topicforumid);
				ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
				((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
				boolean insert = facade.createTopic(temptopic);
				Set topics = facade.getTopics(topicforumid);
				request.setAttribute("topicforumid", topicforumid);
				if ( insert ) request.setAttribute("successful", "Topic created successfully");
				else request.setAttribute("error_unsuccessful", "An Error occured while creating Topic");
				request.setAttribute("topics", TopicsUtil.getTopicTable(topics));
				page_render = "Topics";
			}
		}
		else {
			page_render = "Login";
		}
		System.out.println(page_render);
		request.setAttribute("page_render", page_render);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
