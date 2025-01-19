package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import controller.command.RegisterPedidoCommand;
import controller.command.UpdatePedidoCommand;
import controller.command.Command;
import controller.command.DeletePedidoCommand;
import controller.command.ErrorCommand;
import controller.command.FormRegisterPedidoCommand;
import controller.command.FormUpdatePedido;
import controller.command.FormRegisterUserCommand;
import controller.command.HomePageCommand;
import controller.command.ListPedidosCommand;
import controller.command.LogoutCommand;
import controller.command.RegisterUserCommand;
import controller.command.SearchPedidoCommand;

// FrontController utilizado para encaminhar requisições após o usuário já estar logado
@WebServlet("/home.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Command command = null;
		
		if("registerForm".equals(action)) {
			command = new FormRegisterUserCommand();
		} else if("register".equals(action)) {
			command = new RegisterUserCommand();
		} else if("logout".equals(action)) {
			command = new LogoutCommand();
		} else if("cadastrarPedidoForm".equals(action)) {
			command = new FormRegisterPedidoCommand();
		} else if("cadastrarPedido".equals(action)) {
			command = new RegisterPedidoCommand();
		} else if("visualizarPedidos".equals(action)) {
			command = new ListPedidosCommand();
		} else if("homePage".equals(action)) {
			command = new HomePageCommand();
		} else if("delete".equals(action)) {
			command = new DeletePedidoCommand();
		} else if("update".equals(action)) {
			command = new UpdatePedidoCommand();
		} else if("formUpdatePedido".equals(action)) {
			command = new FormUpdatePedido();
		} else if("buscaPedido".equals(action)) {
			command = new SearchPedidoCommand();
		} else {
			command = new ErrorCommand();
		}
		
		String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);	
		
	}

}
