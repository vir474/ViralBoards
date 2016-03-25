package com.viralboards.remoteloader;

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
 * Servlet implementation class TopicsTableLoaderServlet
 */
@WebServlet("/TopicsTableLoaderServlet")
public class TopicsTableLoaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicsTableLoaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get topics loader servlet");
		String url = "/Shared/Layout.jsp";
		String page_render = "Topics";
		if ( request.getSession().getAttribute("usersession") != null ) {
			// logged in get forum data
			String topicforumid = request.getParameter("topicforumid");
			Object topicforumid_request = request.getAttribute("topicforumid");
			if (topicforumid_request != null) {
				topicforumid = topicforumid_request.toString();
			}
			ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
	        ((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
	        Set topics = facade.getTopics(topicforumid);
	        
	    //    System.out.println("HTML " + htmlRows.toString());
	        request.setAttribute("topics", TopicsUtil.getTopicTable(topics));
	        request.setAttribute("topicforumid", topicforumid);
		}
		else{
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
