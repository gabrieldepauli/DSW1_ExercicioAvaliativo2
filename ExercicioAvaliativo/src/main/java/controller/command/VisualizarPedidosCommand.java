package controller.command;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PedidoDao;
import model.dao.PedidoDaoFactory;
import model.entity.Pedido;
import model.entity.User;

public class VisualizarPedidosCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var user = (User) request.getSession(false).getAttribute("user_id");
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		
		List<Pedido> pedidos = dao.retrive(user);
		
		request.setAttribute("pedidos", pedidos);
		
		return "home.do?action=listPedidos";
	}

}
