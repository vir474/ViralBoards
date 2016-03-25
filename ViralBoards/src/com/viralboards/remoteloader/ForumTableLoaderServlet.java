package com.viralboards.remoteloader;

import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viralboards.dao.impl.ViralBoardsJdbcDAOImpl;
import com.viralboards.model.Account;
import com.viralboards.model.Forum;
import com.viralboards.services.ViralBoardsFacade;
import com.viralboards.services.impl.ViralBoardsFacadeImpl;
import com.viralboards.util.ForumsUtil;

/**
 * Servlet implementation class ForumTableLoaderServlet
 */
@WebServlet("/ForumTableLoaderServlet")
public class ForumTableLoaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForumTableLoaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get forumtableloader");
		String url = "/Shared/Layout.jsp";
		String page_render = "Welcome";
		if ( request.getSession().getAttribute("usersession") != null ) {
			// logged in get forum data
			ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
	        ((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
	        Set forums = facade.getForums();
	        
	    //    System.out.println("HTML " + htmlRows.toString());
	        request.setAttribute("forums", ForumsUtil.getForumTable(forums));
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
