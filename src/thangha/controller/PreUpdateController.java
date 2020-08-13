package thangha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreUpdateController
 */
@WebServlet("/PreUpdateController")
public class PreUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String SUCCESS = "update.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreUpdateController() {
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
		String url = SUCCESS;
		try {
			String username = request.getParameter("txtUsername");
			String fullname = request.getParameter("txtFullname");
			
			request.setAttribute("USERNAME", username);
			request.setAttribute("FULLNAME", fullname);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
