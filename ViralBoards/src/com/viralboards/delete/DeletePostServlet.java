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
import com.viralboards.util.PostsUtil;

/**
 * Servlet implementation class DeletePostServlet
 */
@WebServlet("/DeletePostServlet")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get delete post servlet");
		String url = "/Shared/Layout.jsp";
		String page_render = "Posts";
		String postid = request.getParameter("postid");
		String posttopicid = request.getParameter("posttopicid");
		String postforumid = request.getParameter("postforumid");
		System.out.println("delete id " + postid);
		
		if ( request.getSession().getAttribute("usersession") != null ) {
			// logged in get post data
			ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
			((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
			boolean delete = facade.deletePost(postid);
			System.out.println("Delete Successfull : " + delete);
			Set posts = facade.getPosts(posttopicid);
			
			request.setAttribute("posttopicid", posttopicid);
			request.setAttribute("postforum", postforumid);
			if ( delete ) request.setAttribute("successful", "Post deleted successfully");
			else request.setAttribute("error_unsuccessful", "An Error occured while deleting Post");
			request.setAttribute("posts", PostsUtil.getPostTable(posts));
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
