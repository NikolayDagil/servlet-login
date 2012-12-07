package org.stas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet(name = "authentication", urlPatterns = { "/authentication" })
public class AuthenticationServlet extends HttpServlet {

	private static final String USERNAME = "stas_sarosek";
	private static final String PASSWORD = "Qwerty123";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("authentication.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (!username.isEmpty() && !password.isEmpty()
				&& username.equals(USERNAME) && password.equals(PASSWORD)) {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("home.jsp");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("authentication.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}