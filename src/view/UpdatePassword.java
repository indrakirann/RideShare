package view;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.LoginController;
import view.UserLogin;
import view.FrontendTransfer;
import controller.ForgotPasswordController;
import view.ForgotPasswordError;


@WebServlet("/updatepassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/updatepassword.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		String newpass = request.getParameter("newpass");
		String rptnewpass = request.getParameter("rptnewpass");
		
		
		
	}
}
