package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Command utilizado para fazer o Logout do usuário no sistema
public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		return "index.jsp";
	}
	
}
