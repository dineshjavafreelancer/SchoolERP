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

import com.syncogni.erp.bean.Student;
@WebServlet("/StudentServlet")
public class StudentServelet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public StudentServelet(){
		super();
		
	}

}
