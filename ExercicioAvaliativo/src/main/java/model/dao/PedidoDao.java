package model.dao;

import java.util.List;

import model.entity.Pedido;
import model.entity.User;

public interface PedidoDao {
	
	boolean create(User user, Pedido pedido);
	
	boolean delete(User user, Pedido pedido);
	
	boolean update(Pedido pedido, int id);
	
	List<Pedido> retrive(User user);
	
	List<Pedido> findByName(User user, String nome);
	
}
