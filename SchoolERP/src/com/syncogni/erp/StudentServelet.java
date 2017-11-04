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

//import com.syncogni.erp.bean.Student;

@WebServlet("/StudentServlet")
public class StudentServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolerp", "root", "123456");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM student");
			while (rs.next()) {
				out.print(rs.getObject(1).toString());
				out.print("\t\t\t");
				out.print(rs.getObject(2).toString());
				out.print("\t\t\t");
				out.print(rs.getObject(3).toString());
				out.print("<br>");
			}
		} catch (SQLException e) {
			throw new ServletException("Servlet Could not display records.", e);
		} catch (ClassNotFoundException e) {
			throw new ServletException("JDBC Driver not found.", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
					//rs = null; //unnecessary 
				}
				if (stmt != null) {
					stmt.close();
					//stmt = null; //unnecessary 
				}
				if (con != null) {
					con.close();
					//con = null; //unnecessary 
				}
			} catch (SQLException e) {
			}
		}
		out.close();
	}
}
