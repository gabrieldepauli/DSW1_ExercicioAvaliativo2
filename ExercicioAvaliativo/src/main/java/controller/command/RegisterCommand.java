package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDaoFactory;
import model.entity.User;

public class RegisterCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var email = request.getParameter("email");
		var senha = request.getParameter("senha");
		
		var dao = new UserDaoFactory().factory();
		var user = new User(email, senha);
		var saved = dao.insert(user);
		
		String message;
		if(saved) {
			message = "Usuario registrado com sucesso.";
		} else {
			message = "Erro ao cadastrar o usuario.";
		}
		
		request.setAttribute("message", message);
		request.setAttribute("saved", saved);
		
		return "home.jsp";
	}

}
