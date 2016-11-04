package com.syncogni.erp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syncogni.erp.model.Student;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		Student student = new Student();
		
		String name = request.getParameter("name");
		student.setName(name);
		
		String fatherName = request.getParameter("fatherName");
		student.setFatherName(fatherName);
		
		String motherName = request.getParameter("motherName");
		student.setMotherName(motherName);
		
//		String motherName = request.getParameter("motherName");
//		student.setMotherName(motherName);

		
		
		request.setAttribute("student", student);
		
		boolean updatedDB = updateDB(student);
		
		System.out.println("updatedDB = "+ updatedDB);
		
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("homepage.html");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("StudentDetails.jsp");
		requestDispatcher.forward(request, response);
		
		writer.flush();
		writer.close();

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

	private boolean updateDB(Student student){
		
		String dbUrl = "jdbc:mysql://localhost:3306/schoolerp";
		String driverClass = "com.mysql.jdbc.Driver";
		String query = "insert into student(id, name, father_name) values ("+ (getLastId()+1) +", '"+student.getName()+"', '"+student.getFatherName()+"')";
		System.out.println("query="+query);
		String username = "root";
		String password = "123456";
		
		// Comment from Sagar
		
		
	
		try {

			Class.forName(driverClass);
			Connection connection = DriverManager.getConnection(dbUrl,
					username, password);
			{
				Statement statement = connection.createStatement();
				int updateCount= statement.executeUpdate(query);
				System.out.println(updateCount);
				statement.close();
			}
			{
				Statement statement = connection.createStatement();
				int updateCount= statement.executeUpdate("update ids_keeper set last_value_generated =" + (getLastId()+1) + " where id =1 ");
				System.out.println(updateCount);
				
			}
			
			connection.close();
		} catch (ClassNotFoundException  | SQLException e) {
			e.printStackTrace();
			return true;
		}
		return true;
	}

	private long getLastId(){
		long lastId=0;
		
		String dbUrl = "jdbc:mysql://localhost:3306/schoolerp";
		String driverClass = "com.mysql.jdbc.Driver";
		String query = "Select max(LAST_VALUE_GENERATED) from ids_keeper where id=1";
		String username = "root";
		String password = "123456";
		try {

			Class.forName(driverClass);
			Connection connection = DriverManager.getConnection(dbUrl,
					username, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				lastId = resultSet.getLong(1);
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lastId;
	}
	
}
