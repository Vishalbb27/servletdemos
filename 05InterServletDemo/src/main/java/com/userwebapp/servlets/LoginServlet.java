package com.userwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginservlet") // Helps to eliminate the web mappings in the xml file
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement preparedStatement;

	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ServletContext context = config.getServletContext();
			String dburl = context.getInitParameter("dburl");
			String dbpassword = context.getInitParameter("dbpassword");
			String dbuser = context.getInitParameter("dbuser");
			connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
			preparedStatement = connection.prepareStatement("select * from user where email = ? and password = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if (!isValidInputString(username, false) ||  !isValidInputString(password, false)
				) {
			out.println("<h1>Please Enter valid input</h1>");
			return;
		}

		try {
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet=null;
			boolean result = preparedStatement.execute();
			if(result)
				resultSet=preparedStatement.getResultSet();
			if (resultSet.next()) {
				String message="You have successfully logged in to the home page"+username;
				request.setAttribute("msg", message);
				RequestDispatcher rd=request.getRequestDispatcher("homeservlet"); //Name of the servlet not the servlet class name
				rd.include(request, response);
			} else {
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean isValidInputString(String inputValue, boolean isNumber) {
		if (inputValue == null || inputValue.isBlank() || inputValue.isEmpty()) {
			return false;
		} else if (isNumber) {
			try {
				Integer someint = Integer.parseInt(inputValue);
				return true;
			} catch (NumberFormatException nfe) {
				return false;
			}
		} else {
			
			return true;
		}
	}

	public void destroy() {
		try {
			if (connection != null) {
				connection.close();

			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
