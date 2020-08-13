package thangha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thangha.dao.AccountDAO;
import thangha.dto.AccountDTO;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String SUCCESS = "SearchController";
	private final String ERROR = "update.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateController() {
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
			String username = request.getParameter("txtUsername");
			String password = request.getParameter("txtPassword");
			String confirmPassword = request.getParameter("txtConfirmPassword");
			String fullname = request.getParameter("txtFullname");
			
			boolean valid = true;
			
			if (password.isEmpty() || confirmPassword.isEmpty()) {
				request.setAttribute("PASSWORD_BLANK_ERROR", "Password is required!");
				valid = false;
			}
			
			if (!password.equals(confirmPassword)) {
				request.setAttribute("PASSWORD_NOT_MATCH", "Password and Confirm password do not match!");
				valid = false;
			}
			
			if (fullname.isEmpty()) {
				request.setAttribute("FULLNAME_ERROR", "Fullname is required!");
				valid = false;
			}
			
			if (valid) {
				AccountDAO dao = new AccountDAO();
				AccountDTO dto = new AccountDTO(username, password, fullname);
				boolean result = dao.updateAccount(dto);
				
				if (result) {
					url = SUCCESS;
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
