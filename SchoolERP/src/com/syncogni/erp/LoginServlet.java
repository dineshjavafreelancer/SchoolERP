package com.syncogni.erp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();

		String emailId = request.getParameter("Email ID");
		System.out.println(emailId);
		
		
		String password = request.getParameter("password");
		System.out.println(password);
		authenticate(emailId,password, request, response);
		
		//TODO
		
		writer.flush();
		writer.close();
		
		
		
	}

	private void authenticate(String emailId,String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		if((emailId.equals("admin@erp.com")&&(password.equals("admin")))){
			System.out.println("correct email ID and password");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage.html");
			requestDispatcher.forward(request, response);
		}
		else{
			System.out.println("Incorrect email ID and password");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.html");
			requestDispatcher.forward(request, response);
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
