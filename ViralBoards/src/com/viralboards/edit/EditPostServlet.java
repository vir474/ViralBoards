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
import com.viralboards.util.PostsUtil;

/**
 * Servlet implementation class EditPostServlet
 */
@WebServlet("/EditPostServlet")
public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get edit post servlet");
		String url = "/Shared/Layout.jsp";
		String page_render = "Posts";
		String postid = request.getParameter("postid");
		String posttopicid = request.getParameter("posttopicid");
		String postforumid = request.getParameter("postforumid");
		String postcontent = request.getParameter("postcontent");
		System.out.println("edit id " + postid + " " + postcontent);
		if ( request.getSession().getAttribute("usersession") != null ) {
			// logged in get post data
			if (postcontent == null || postcontent.trim().length() == 0)
			{
				request.setAttribute("postforumid", postforumid);
				request.setAttribute("posttopicid", posttopicid);
				request.setAttribute("error_postcontent", "Post Content must not be empty");
				url = "/Edit/EditPost.jsp";
				
			}
			else
			{ 
			ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
			((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
			boolean edit = facade.editPostContent(postid, postcontent);
			System.out.println("edit successfull : " + edit);
			Set posts = facade.getPosts(posttopicid);
			
			request.setAttribute("posttopicid", posttopicid);
			request.setAttribute("postforumid", postforumid);
			if ( edit ) request.setAttribute("successful", "Post updated successfully");
			else request.setAttribute("error_unsuccessful", "An Error occured while updating Post");
			request.setAttribute("posts", PostsUtil.getPostTable(posts));
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
