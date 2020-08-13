package thangha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String ERROR = "error.jsp";
	private final String FORDWARD_REGISTER = "register.jsp";
	
	private final String LOGIN = "LoginController";
	private final String REGISTER = "RegisterController";
	private final String SEARCH = "SearchController";
	private final String FORDWARD_UPDATE = "PreUpdateController";
	private final String UPDATE = "UpdateController";
	private final String DELETE = "DeleteController";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = ERROR;
		try {
			String action = request.getParameter("action");
			if (action.equals("Login")) {
				url = LOGIN;
			} else if (action.equals("Forward_Register")) {
				url = FORDWARD_REGISTER;
			} else if (action.equals("Register")) {
				url = REGISTER;
			} else if (action.equals("Search")) {
				url = SEARCH;
			} else if (action.equals("Update_Account")) {
				url = FORDWARD_UPDATE;
			} else if (action.equals("Update")) {
				url = UPDATE;
			} else if (action.equals("Delete")) {
				url = DELETE;
			}
				
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
