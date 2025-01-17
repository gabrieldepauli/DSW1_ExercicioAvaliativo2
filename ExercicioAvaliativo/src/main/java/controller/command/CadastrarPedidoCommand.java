package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PedidoDao;
import model.dao.PedidoDaoFactory;
import model.entity.Pedido;
import model.entity.User;

public class CadastrarPedidoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var id = (String) request.getParameter("id");
		var nome = request.getParameter("nome");
		var endereco = request.getParameter("endereco");
		var valor = (String) request.getParameter("valor");
		var descricao = request.getParameter("descricao");
		
		var user = (User) request.getSession(false).getAttribute("user_id");
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		Pedido pedido = new Pedido(id, nome, endereco, valor, descricao);
		
		boolean saved = dao.create(user, pedido);
		
		String message = "";
		if(saved) {
			message = "Pedido cadastrado com sucesso!";
		} else {
			message = "Erro ao cadastrar o pedido.";
		}
		
		request.setAttribute("message", message);
		request.setAttribute("saved", saved);
		
		return "home.do?action=cadastrarPedidoForm";
	}

}
