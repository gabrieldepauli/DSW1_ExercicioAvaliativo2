package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDaoFactory;
import model.entity.User;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		var dao = new UserDaoFactory().factory();
		var user = dao.findByEmail(email);
		
		var autorized = User.autenticate(user, email, senha);
		
		String view;
		
		if(autorized) {
			var session = request.getSession(true);
			session.setAttribute("user_id", user);
			session.setMaxInactiveInterval(24 * 60 * 60);
			
			view = "home.do?action=homePage";
		} else {
			request.setAttribute("message", "Usuário ou senha inválido.");
			
			view = "login.jsp";
		}
		
		return view;
	}

}
