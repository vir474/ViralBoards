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
import com.viralboards.util.PostsUtil;

/**
 * Servlet implementation class PostsTableLoaderServlet
 */
@WebServlet("/PostsTableLoaderServlet")
public class PostsTableLoaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsTableLoaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get posts loader servlet");
		String url = "/Shared/Layout.jsp";
		String page_render = "Posts";
		if ( request.getSession().getAttribute("usersession") != null ) {
			// logged in get posts data
			String posttopicid = request.getParameter("posttopicid");
			Object posttopicid_request = request.getAttribute("posttopicid");
			if (posttopicid_request != null) {
				posttopicid = posttopicid_request.toString();
			}
			String postforumid = request.getParameter("postforumid");
			Object postforumid_request = request.getAttribute("postforumid");
			if (postforumid_request != null) {
				postforumid = postforumid_request.toString();
			}
			ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
	        ((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
	        Set posts = facade.getPosts(posttopicid);
	        
	    //    System.out.println("HTML " + htmlRows.toString());
	        request.setAttribute("posttopicid", posttopicid);
	        request.setAttribute("postforumid", postforumid);
	        request.setAttribute("posts", PostsUtil.getPostTable(posts));
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
	}

}
