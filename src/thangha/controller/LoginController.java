package thangha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thangha.dao.AccountDAO;
import thangha.dto.AccountDTO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String ERROR = "login.jsp";
	private final String SUCCESS = "welcome.jsp";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
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
			
			AccountDAO dao = new AccountDAO();
			AccountDTO dto = dao.checkLogin(username, password);
			
			if (dto != null) {
				url = SUCCESS;
				HttpSession session = request.getSession();
				session.setAttribute("USER", dto);
			} else {
				request.setAttribute("ERROR_MESSAGE", "Username or password is invalid!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
}
