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
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String SUCCESS = "login.jsp";
	private final String ERROR = "register.jsp";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = ERROR;
		try {
			String username = request.getParameter("txtUsername");
			String password = request.getParameter("txtPassword");
			String confirmPassword = request.getParameter("txtConfirmPassword");
			String fullname = request.getParameter("txtFullname");
			boolean valid = true;
			
			if (username.isEmpty()) {
				request.setAttribute("USERNAME_ERROR", "Username is required!");
				valid = false;
			}
			
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
				AccountDTO dto = new AccountDTO(username, confirmPassword, fullname);
				AccountDAO dao = new AccountDAO();
				boolean result = dao.insertNewAccount(dto);
				if (result) {
					url = SUCCESS;
				} else {
					request.setAttribute("ERROR", "Register unsuccessfully!");
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
