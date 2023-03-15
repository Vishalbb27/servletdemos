package com.userwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home") // Helps to eliminate the web mappings in the xml file
public class HomeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doGet(request,response); //If not included get exception occurs and this is redirected to the do get method.
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		PrintWriter out = response.getWriter();
		if (username == null) {
			out.println("Username not found in session");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		} else {
			out.println("<p>"+request.getCookies()+"</p>");
			
			out.println("Username found in session - " + username);
			
		}

	}

}
