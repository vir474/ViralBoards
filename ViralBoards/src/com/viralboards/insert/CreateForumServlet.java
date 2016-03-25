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
import com.viralboards.model.Forum;
import com.viralboards.services.ViralBoardsFacade;
import com.viralboards.services.impl.ViralBoardsFacadeImpl;
import com.viralboards.util.ForumsUtil;

/**
 * Servlet implementation class CreateForumServlet
 */
@WebServlet("/CreateForumServlet")
public class CreateForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateForumServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Create Forum Servlet do get");
		//establishDBConnection();

		String url = "/Shared/Layout.jsp";
		String page_render = "";
		String forumname = request.getParameter("newforumname");

		if ( request.getSession().getAttribute("usersession") != null ) {	

			if (forumname == null || forumname.trim().length() == 0)
			{
				request.setAttribute("error_forumname", "Forum Name must not be empty");
				url = "/Insert/CreateForum.jsp";
			}
			else
			{
				Forum tempforum = new Forum("",forumname,"");
				ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
				((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
				boolean insert = facade.createForum(tempforum);
				Set forums = facade.getForums();
				request.setAttribute("forums", forums);
				if ( insert ) request.setAttribute("successful", "Forum created successfully");
				else request.setAttribute("error_unsuccessful", "An Error occured while creating Forum");
				request.setAttribute("forums", ForumsUtil.getForumTable(forums));
				page_render = "Welcome";
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
