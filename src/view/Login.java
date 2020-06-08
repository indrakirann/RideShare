package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.LoginController;
import view.UserLogin;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper mapper = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}

	// receives data
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		
		LoginController c = new LoginController();
		UserLogin loginError = c.checkUser(email,password);
		response(response, loginError);

	}

	protected void response(HttpServletResponse response, Object data) {
		response.setContentType("application/json");
		PrintWriter writer = null;
		String responseStr = null;
		try {
			responseStr = mapper.writeValueAsString(data);
			writer = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (writer != null) {
			writer.println(responseStr);
			writer.flush();
			writer.close();
			
	}
  }

}