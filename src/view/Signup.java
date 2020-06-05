package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.SignupController;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper mapper = new ObjectMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/signup.jsp").forward(request, response);
	}

	// receives data
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		SignupController c = new SignupController();
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(email);
		System.out.println(password);
		response(response, c.createUser(firstname, lastname, email, password));

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
