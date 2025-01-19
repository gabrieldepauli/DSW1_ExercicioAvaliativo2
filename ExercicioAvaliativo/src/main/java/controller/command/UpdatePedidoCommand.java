package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PedidoDao;
import model.dao.PedidoDaoFactory;
import model.entity.Pedido;
import model.entity.User;

//Command utilizado para atualizar um pedido
public class UpdatePedidoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String message = "";
		
		var user = (User) request.getSession(false).getAttribute("user_id");
		
		var id = Integer.parseInt(request.getParameter("id"));
        var nome = request.getParameter("nome");
        var endereco = request.getParameter("endereco");
        var valor = Double.parseDouble(request.getParameter("valor"));
        var descricao = request.getParameter("descricao");
        
        Pedido pedido = new Pedido();
        pedido.setNome(nome);
        pedido.setEndereco(endereco);
        pedido.setValor(valor);
        pedido.setDescricao(descricao);
		
		PedidoDao dao = new PedidoDaoFactory().factory();
		var editado = dao.update(pedido, id);
		
		if(editado) {
			message = "Pedido alterado com sucesso.";
			
			var pedidosAtualizados = dao.retrive(user);
	        request.setAttribute("pedidos", pedidosAtualizados);
		} else {
			message = "Erro ao editar o pedido.";
		}
		
		request.setAttribute("message", message);
		
		return "/loggedin/visualizarPedido.jsp";
		
	}

}
