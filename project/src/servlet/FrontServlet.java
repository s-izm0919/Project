<<<<<<< HEAD
package servlet;

import controler.*;
import context.RequestContext;
import java.io.IOException;
import context.RequestContext;
import context.ResponseContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/FrontServlet")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("-- FrontServlet --");

		req.setCharacterEncoding("UTF-8");
		ApplicationControler app=new  WebApplicationControler();
		RequestContext reqc=app.getRequest(req);
		ResponseContext resc=app.handleRequest(reqc);
		resc.setResponse(res);
		app.handleResponse(reqc, resc);


	}
}
=======
package servlet;

import controler.*;
import context.RequestContext;
import java.io.IOException;
import context.RequestContext;
import context.ResponseContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/FrontServlet")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("-- FrontServlet --");

		req.setCharacterEncoding("UTF-8");
		ApplicationControler app=new  WebApplicationControler();
		RequestContext reqc=app.getRequest(req);
		ResponseContext resc=app.handleRequest(reqc);
		resc.setResponse(res);
		app.handleResponse(reqc, resc);


	}
}
>>>>>>> branch 'master' of git@github.com:s-izm0919/Project.git
