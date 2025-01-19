package model.dao;

//Cria instâncias do DatabasePedidoDao()
public class PedidoDaoFactory {

	public PedidoDao factory() {
		return new DatabasePedidoDao();
	}
	
}
