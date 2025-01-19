package controller.command;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Command utilizado encaminhar para a página do formulario JSP para inserir os dados do novo pedido
public class FormRegisterPedidoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return "/loggedin/cadastrarPedido.jsp";
	}

}
