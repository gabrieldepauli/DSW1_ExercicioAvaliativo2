package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PedidoDao;
import model.dao.PedidoDaoFactory;
import model.entity.User;

//Command que prepara os dados necessários para a exibição do formulário de alterar um pedido
public class FormUpdatePedido implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var user = (User) request.getSession(false).getAttribute("user_id");
		var id = Integer.parseInt(request.getParameter("id"));
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		var pedido = dao.retrieve(user, id);
		
		request.setAttribute("pedido", pedido);
		
		return "/loggedin/alterarPedido.jsp";
	}

}
