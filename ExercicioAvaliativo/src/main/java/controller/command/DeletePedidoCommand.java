package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PedidoDao;
import model.dao.PedidoDaoFactory;
import model.entity.User;

//Command utilizado para deletar um pedido em específico
public class DeletePedidoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String message = "";
		
		User user = (User) request.getSession(false).getAttribute("user_id");
		var id = Integer.parseInt(request.getParameter("id"));
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		var pedido = dao.retrieve(user, id);
		
		var saved = dao.delete(user, pedido);	
		
		if(saved) {
			message = "Pedido deletado com sucesso!";
		} else {
			message = "Erro ao deletar o pedido.";
		}
		
		request.setAttribute("message", message);
		request.setAttribute("saved", saved);
		
		return "home.do?action=visualizarPedidos";
	}
	
}
