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
import com.viralboards.util.ForumsUtil;

/**
 * Servlet implementation class EditForumServlet
 */
@WebServlet("/EditForumServlet")
public class EditForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditForumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get edit forum servlet");
		String url = "/Shared/Layout.jsp";
		String page_render = "Welcome";
		String forumid = request.getParameter("forumid");
		String newforumname = request.getParameter("newforumname");
		System.out.println("edit id " + forumid + " " + newforumname);
		if ( request.getSession().getAttribute("usersession") != null ) {
			// logged in get forum data
			if (newforumname == null || newforumname.trim().length() == 0)
			{
				request.setAttribute("error_forumname", "Forum Name must not be empty");
				url = "/Edit/EditForum.jsp";
			}
			else
			{
			ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
			((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
			boolean edit = facade.editForumName(forumid, newforumname);
			System.out.println("edit successfull : " + edit);
			Set forums = facade.getForums();
			if ( edit ) request.setAttribute("successful", "Forum updated successfully");
			else request.setAttribute("error_unsuccessful", "An Error occured while updating Forum");
			request.setAttribute("forums", ForumsUtil.getForumTable(forums));
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
