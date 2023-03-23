package com.bookstorewebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.bookstorewebapp.model.bookmodel;
import com.bookstorewebapp.utils.BookUtil;



@WebServlet("/Bookstore")
public class Bookstore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session=BookUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String isbn = request.getParameter("isbn");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		bookmodel book=new bookmodel(isbn,name,price);
		System.out.println(book);
		session.save(book);
		session.getTransaction().commit();
//		List<bookmodel> books=(List<bookmodel>) session.createQuery("from bookmodel");
		session.close();
//		request.setAttribute(name, books);
//		RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
//		rd.forward(request, response);
		doGet(request, response);
	}

}
