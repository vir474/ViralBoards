package com.viralboards.edit;

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
import com.viralboards.services.ViralBoardsFacade;
import com.viralboards.services.impl.ViralBoardsFacadeImpl;
import com.viralboards.util.TopicsUtil;

/**
 * Servlet implementation class EditTopicServlet
 */
@WebServlet("/EditTopicServlet")
public class EditTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get edit topic servlet");
		String url = "/Shared/Layout.jsp";
		String page_render = "Topics";
		String topicid = request.getParameter("topicid");
		String topicforumid = request.getParameter("topicforumid");
		String newtopicname = request.getParameter("newtopicname");
		System.out.println("edit id " + topicid + " " + newtopicname);
		if ( request.getSession().getAttribute("usersession") != null ) {
			// logged in get topic data
			if (newtopicname == null || newtopicname.trim().length() == 0)
			{
				request.setAttribute("topicforumid", topicforumid);
				request.setAttribute("error_topicname", "Topic Name must not be empty");
				url = "/Edit/EditTopic.jsp";
			}
			else
			{
			ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
			((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
			boolean edit = facade.editTopicName(topicid, newtopicname);
			System.out.println("edit successfull : " + edit);
			Set topics = facade.getTopics(topicforumid);
			if ( edit ) request.setAttribute("successful", "Topic updated successfully");
			else request.setAttribute("error_unsuccessful", "An Error occured while updating Topic");
			request.setAttribute("topicforumid", topicforumid);
			request.setAttribute("topics", TopicsUtil.getTopicTable(topics));
			}
		}
		else {
			page_render = "Login";
		}
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
