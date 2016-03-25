package com.viralboards.home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.viralboards.dao.impl.ViralBoardsJdbcDAOImpl;
import com.viralboards.model.Account;
import com.viralboards.services.ViralBoardsFacade;
import com.viralboards.services.impl.ViralBoardsFacadeImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Register Servlet do get");
		//establishDBConnection();
		
		String url = "/Shared/Layout.jsp";
		String page_render = "";
		String uname = request.getParameter("input_uname");
		String password = request.getParameter("input_password");
		String email = request.getParameter("input_email");
		
		if (uname == null || uname.length() == 0 || password == null || password.length() == 0 || email == null || email.length() == 0)
        {
            //url = "/Home/Login.jsp";
            page_render = "Register";
			
            if (uname == null || uname.length() == 0)
            {
            	request.setAttribute("error_uname", "Username must not be empty");
            	request.setAttribute("email", email);
            }
            if (password == null || password.length() == 0)
            {
            	request.setAttribute("error_password", "Password must not be empty");
            	request.setAttribute("uname", uname);
            	request.setAttribute("email", email);
            }
            if (email == null || email.length() == 0)
            {
            	request.setAttribute("error_email", "Email must not be empty");
            	request.setAttribute("uname", uname);
            }
        }
		else
		{
			Account newaccount = new Account(null, uname, password, email);
			
			ViralBoardsFacade facade = new ViralBoardsFacadeImpl();
	        ((ViralBoardsFacadeImpl) facade).setViralBoardsDAO(ViralBoardsJdbcDAOImpl.getViralBoardsDAO());
			if( facade.createAccount(newaccount) ) {
			
					//url = "/Home/Welcome.jsp";
					page_render = "Login";
				}
				else {
					// invalid login
					page_render = "Register";
					request.setAttribute("error_invalid", "Username or Email is not unique !");
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
		doGet(request, response);
	}

}
