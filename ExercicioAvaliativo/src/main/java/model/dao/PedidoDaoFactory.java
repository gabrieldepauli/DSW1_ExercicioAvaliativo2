package model.dao;

public class PedidoDaoFactory {

	public PedidoDao factory() {
		return new DatabasePedidoDao();
	}
	
}
