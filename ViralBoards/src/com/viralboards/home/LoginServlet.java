package com.viralboards.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.viralboards.dao.impl.ViralBoardsJdbcDAOImpl;
import com.viralboards.model.Account;
import com.viralboards.services.ViralBoardsFacade;
import com.viralboards.services.impl.ViralBoardsFacadeImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get");
		
		String url = "/Shared/Layout.jsp";
		String page_render = "";
		String uname = request.getParameter("input_uname");
		String password = request.getParameter("input_password");
		
		if (uname == null || uname.length() == 0 || password == null || password.length() == 0)
        {
            //url = "/Home/Login.jsp";
            page_render = "Login";
			
            if (uname == null || uname.length() == 0)
            {
            	request.setAttribute("error_uname", "Username must not be empty");
            }
            if (password == null || password.length() == 0)
            {
            	request.setAttribute("error_password", "Password must not be empty");
            	request.setAttribute("uname", uname);
            }
        }
		else
		{
			Account user = null;
			ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
	        ((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
			user = facade.authorizeUser(uname, password);
			
			if ( user != null ) {
				// change the url to forum data loading servlet
				url = "/ForumTableLoaderServlet";
				HttpSession loginsession = request.getSession();
				loginsession.setAttribute("usersession", user.getUserId());
				page_render = "Welcome";
			}
			else {
				page_render = "Login";
				request.setAttribute("error_invalid", "Username and Password is invalid !");
			}
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
		System.out.println("do post login servlet");
		doGet(request, response);
	}
}
