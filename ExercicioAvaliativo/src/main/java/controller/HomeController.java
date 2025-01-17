package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import controller.command.CadastrarPedidoCommand;
import controller.command.Command;
import controller.command.FormCadastrarPedidoCommand;
import controller.command.FormRegisterCommand;
import controller.command.HomePageCommand;
import controller.command.ListPedidosCommand;
import controller.command.LogoutCommand;
import controller.command.RegisterCommand;
import controller.command.VisualizarPedidosCommand;

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
		
		if("register".equals(action)) {
			command = new RegisterCommand();
		} else if("registerForm".equals(action)) {
			command = new FormRegisterCommand();
		} else if("logout".equals(action)) {
			command = new LogoutCommand();
		} else if("cadastrarPedidoForm".equals(action)) {
			command = new FormCadastrarPedidoCommand();
		} else if("cadastrarPedido".equals(action)) {
			command = new CadastrarPedidoCommand();
		} else if("visualizarPedidos".equals(action)) {
			command = new VisualizarPedidosCommand();
		} else if("homePage".equals(action)) {
			command = new HomePageCommand();
		} else if("listPedidos".equals(action)) {
			command = new ListPedidosCommand();
		}
		
		String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}

}
