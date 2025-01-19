package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDaoFactory;
import model.entity.User;

// Command utilizado para criar um registro de usuário
public class RegisterUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = "";
		
		var email = request.getParameter("email");
		var senha = request.getParameter("senha");
		
		var dao = new UserDaoFactory().factory();
		var user = new User(email, senha);
		var saved = dao.insert(user);
		
		if(saved) {
			message = "Usuario registrado com sucesso.";
			
			request.setAttribute("message", message);
			request.setAttribute("saved", saved);
			
			return "home.do?action=homePage";
		} else {
			message = "Erro ao cadastrar o usuario.";
			
			request.setAttribute("message", message);
			request.setAttribute("saved", saved);
			
			return "home.do?action=registerForm";
		}
		
	}

}
