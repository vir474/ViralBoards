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
import com.viralboards.model.Post;
import com.viralboards.services.ViralBoardsFacade;
import com.viralboards.services.impl.ViralBoardsFacadeImpl;
import com.viralboards.util.PostsUtil;

/**
 * Servlet implementation class CreatePostServlet
 */
@WebServlet("/CreatePostServlet")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Create Post Servlet do get");
		//establishDBConnection();

		String url = "/Shared/Layout.jsp";
		String page_render = "";
		String postcontent = request.getParameter("newpostcontent");
		String postforumid = request.getParameter("postforumid");
		String posttopicid = request.getParameter("posttopicid");

		if ( request.getSession().getAttribute("usersession") != null ) {	
			
			if (postcontent == null || postcontent.trim().length() == 0)
			{
				request.setAttribute("postforumid", postforumid);
				request.setAttribute("posttopicid", posttopicid);
				request.setAttribute("error_postcontent", "Post Content must not be empty");
				url = "/Insert/CreatePost.jsp";
				
			}
			else
			{ 
				String authorid = request.getSession().getAttribute("usersession").toString();
				Post temppost = new Post("", postcontent, "", posttopicid, authorid, postforumid);
				ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
				((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
				boolean insert = facade.createPost(temppost);
				Set posts = facade.getPosts(posttopicid);	
				request.setAttribute("postforumid", postforumid);
				request.setAttribute("posttopicid", posttopicid);
				//url = "/PostsTableLoaderServlet";
				if ( insert ) request.setAttribute("successful", "Post created successfully");
				else request.setAttribute("error_unsuccessful", "An Error occured while creating Post");
				request.setAttribute("posts", PostsUtil.getPostTable(posts));
				page_render = "Posts";
			}
		}
		else {
			page_render = "Login";
		}

		System.out.println(page_render);
		request.setAttribute("page_render", page_render);
		System.out.println("hey");
		ServletContext context = getServletContext();
		System.out.println("hey 1");
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		System.out.println("hey 2");
		dispatcher.forward(request, response);
		System.out.println("hey 3");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
