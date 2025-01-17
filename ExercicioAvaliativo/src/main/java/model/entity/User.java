package model.entity;

import java.util.LinkedList;
import java.util.List;

public class User {
	private String email;
	private String senha;
	private List<Pedido> pedidos;
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public User(String email, String senha) {
		init(email, senha);
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void clearPedido() {
		pedidos.clear();
	}
	
	public static boolean autenticate(User usuarioSistema, String email, String senha) {
		if (usuarioSistema != null) {
			return senha.equals(usuarioSistema.senha) && email.equals(usuarioSistema.email);
		}
		
		return false;
	}
	
	private void init(String email, String senha) {
		this.email = email;
		this.senha = senha;
		pedidos = new LinkedList<Pedido>();
	}
	
}
