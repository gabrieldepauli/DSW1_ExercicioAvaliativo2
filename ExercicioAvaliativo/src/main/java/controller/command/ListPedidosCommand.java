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

//Command utilizado para exibir os pedidos na tela
public class ListPedidosCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String message = "";
		
		var user = (User) request.getSession(false).getAttribute("user_id");
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		
		List<Pedido> pedidos = dao.retrive(user);
		
		request.setAttribute("pedidos", pedidos);
		
		if(pedidos.isEmpty()) {
			message = "Não há pedidos registrados.";
			
			request.setAttribute("message", message);
		}
		
		// Mensagem para o console para ver se os pedidos estão sendo passados
		System.out.println("Pedidos: " + pedidos);
		
		return "/loggedin/visualizarPedido.jsp";
	}

}
