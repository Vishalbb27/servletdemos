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


@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection = null;
    
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("name");
		
		try(Statement statement = connection.createStatement()){
			int result = statement.executeUpdate("delete from user where firstname = '" + name + "'");
			PrintWriter out = response.getWriter();
			if(result>0) {
				out.println("<p>User data removed successfully</p>");
			}
			else {
				out.println("<p>User not found</p>");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}