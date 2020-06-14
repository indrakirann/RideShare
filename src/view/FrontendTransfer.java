package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FrontendTransfer {
	private static ObjectMapper mapper = new ObjectMapper();

	protected static void response(HttpServletResponse response, Object data) {
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
