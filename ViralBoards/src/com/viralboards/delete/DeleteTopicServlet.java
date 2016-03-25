package com.viralboards.delete;

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
 * Servlet implementation class DeleteTopicServlet
 */
@WebServlet("/DeleteTopicServlet")
public class DeleteTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get delete topic servlet");
		String url = "/Shared/Layout.jsp";
		String page_render = "Topics";
		String topicid = request.getParameter("topicid");
		String topicforumid = request.getParameter("topicforumid");
		System.out.println("delete id " + topicid);
		
		if ( request.getSession().getAttribute("usersession") != null ) {
			// logged in get topic data
			ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
			((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
			boolean delete = facade.deleteTopic(topicid);
			System.out.println("Delete Successfull : " + delete);
			Set topics = facade.getTopics(topicforumid);
			if ( delete ) request.setAttribute("successful", "Topic deleted successfully");
			else request.setAttribute("error_unsuccessful", "An Error occured while deleting Topic, The topic may contain childs");
			request.setAttribute("topicforumid", topicforumid);
			request.setAttribute("topics", TopicsUtil.getTopicTable(topics));
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
