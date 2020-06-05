package view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;


@WebServlet("/forgotpassword")
public class Forgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/forgotpassword.jsp").forward(request, response);
	}

	// receives data
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println(email);


		LoginController l = new LoginController();
		boolean loginError = l.checkUser(email);
		if (loginError) {
			System.out.println("Error");
		}
		//System.out.println("Success");
		
		
	}

}