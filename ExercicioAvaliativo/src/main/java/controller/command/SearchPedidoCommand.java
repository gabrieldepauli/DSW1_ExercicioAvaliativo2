package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PedidoDao;
import model.dao.PedidoDaoFactory;
import model.entity.User;

//Command utilizado para fazer a busca de um pedido pelo nome do cliente
public class SearchPedidoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = (User) request.getSession(false).getAttribute("user_id");
		var nome = request.getParameter("nome");
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		var pedidos = dao.findByName(user, nome);
		
		if(pedidos.isEmpty()) {
			pedidos = dao.retrive(user);
			request.setAttribute("message", "Pedido do cliente " + nome + " não foi encontrado.");
		}
		
		request.setAttribute("pedidos", pedidos);
		
		return "/loggedin/visualizarPedido.jsp";
	}
	
}
