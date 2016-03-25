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
import com.viralboards.util.ForumsUtil;

/**
 * Servlet implementation class DeleteForumServlet
 */
@WebServlet("/DeleteForumServlet")
public class DeleteForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteForumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get delete forum servlet");
		String url = "/Shared/Layout.jsp";
		String page_render = "Welcome";
		String forumid = request.getParameter("forumid");
		System.out.println("delete id " + forumid);
		
		if ( request.getSession().getAttribute("usersession") != null ) {
			// logged in get forum data
			ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
			((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
			boolean delete = facade.deleteForum(forumid);
			System.out.println("Delete Successfull : " + delete);
			Set forums = facade.getForums();
			if ( delete ) request.setAttribute("successful", "Forum deleted successfully");
			else request.setAttribute("error_unsuccessful", "An Error occured while deleting forum, The forum may contain childs");
			request.setAttribute("forums", ForumsUtil.getForumTable(forums));
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
