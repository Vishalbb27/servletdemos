package com.userwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddUserServlet") // Helps to eliminate the web mappings in the xml file
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ServletContext context=config.getServletContext();
			String dburl=context.getInitParameter("dburl");
			String dbpassword=context.getInitParameter("dbpassword");
			String dbuser=context.getInitParameter("dbuser");
			connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
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

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");

		try (Statement statement = connection.createStatement();) {
			int result = statement.executeUpdate("insert into user values('" + firstName + "','" + lastName + "','"
					+ emailId + "', '" + password + "')");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<h1>User added to Database</h1>");
			} else {
				out.println("<h1>Error inserting the data</h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			if (connection != null) {
				connection.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
