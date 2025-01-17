package model.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.dao.connection.DatabaseConnection;
import model.entity.Pedido;
import model.entity.User;

public class DatabasePedidoDao implements PedidoDao {

	/*
	 * Tabela criada para os pedidos
	 * 
	 * create table pedido_db(
			id INTEGER NOT NULL,
		    nome VARCHAR(150) NOT NULL,
		    endereco VARCHAR(200) NOT NULL,
		    valor DOUBLE NOT NULL,
		    descricao VARCHAR(500),
		    username VARCHAR(150) NOT NULL,
		    PRIMARY KEY (username, id),
		    FOREIGN KEY (username) REFERENCES usuario_db(email) ON DELETE CASCADE
		);
	 *
	 */
	
	private static final String INSERT = "INSERT INTO pedido_db (id, nome, endereco, valor, descricao) VALUES (?, ?, ?, ?, ?)";
	private static final String SELECT_BY_NAME = "SELECT * FROM pedido_db WHERE nome LIKE ? AND username = ? ORDER BY name";
	private static final String SELECT_ALL = "SELECT * FROM pedido_db WHERE username = ? ORDER BY name";
	private static final String UPDATE = "UPDATE pedido_db SET nome = ?, endereco = ?, valor = ?, descricao = ? WHERE id = ?";
	private static final String DELETE = "DELETE FROM pedido_db WHERE id = ? AND username = ?";
	
	@Override
	public boolean create(User user, Pedido pedido) {
		if(pedido != null) {
			int rows = -1;
			
			try ( var connection = DatabaseConnection.getConnection();
					  var preparedStatement = connection.prepareStatement(INSERT)) {

					preparedStatement.setInt(1, pedido.getId());
					preparedStatement.setString(2, pedido.getNome());
					preparedStatement.setString(3, pedido.getEndereco());
					preparedStatement.setDouble(4, pedido.getValor());
					preparedStatement.setString(5, pedido.getDescricao());
					preparedStatement.setString(6, user.getEmail());
					
					rows = preparedStatement.executeUpdate();

					if (rows > 0) {
						user.addPedido(pedido);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return rows > 0;
		}
		
		return false;
	}

	@Override
	public boolean delete(User user, Pedido pedido) {
		if (pedido != null) {
			int rows = -1;
			
			try ( var connection = DatabaseConnection.getConnection();
				  var preparedStatement = connection.prepareStatement(DELETE)) {
				
				preparedStatement.setInt(1, pedido.getId());
				preparedStatement.setString(2, user.getEmail());

				rows = preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rows > 0;
		}
		
		return false;
	}

	@Override
	public boolean update(Pedido pedido, int id) {
		if (pedido != null) {
			int rows = -1;
			
			try ( var connection = DatabaseConnection.getConnection();
				  var preparedStatement = connection.prepareStatement(UPDATE)){
					
				preparedStatement.setString(1, pedido.getNome());
				preparedStatement.setString(2, pedido.getEndereco());
				preparedStatement.setDouble(3, pedido.getValor());
				preparedStatement.setString(4, pedido.getDescricao());
	
				rows = preparedStatement.executeUpdate();
			} catch (SQLException e) {
					e.printStackTrace();
			}
				
			return rows > 0;
		}
		
		return false;
	}

	@Override
	public List<Pedido> retrive(User user) {
		user.clearPedido();
		
		try(var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(SELECT_ALL)) {
			
			preparedStatement.setString(1, user.getEmail());
			
			var result = preparedStatement.executeQuery();
			
			while(result.next()) {
				var pedido = new Pedido();
				pedido.setId(result.getInt("id"));
				pedido.setNome(result.getString("nome"));
				pedido.setEndereco(result.getString("endereco"));
				pedido.setValor(result.getDouble("valor"));
				pedido.setNome(result.getString("descricao"));
				
				user.addPedido(pedido);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user.getPedidos();
	}

	@Override
	public List<Pedido> findByName(User user, String nome) {
		var pedidos = new LinkedList<Pedido>();
		
		if (nome != null && !nome.isEmpty()) {
			try ( var connection = DatabaseConnection.getConnection();
				  var preparedStatement = connection.prepareStatement(SELECT_BY_NAME)){
	
				nome = "%" + nome + "%";
				preparedStatement.setString(1, nome);
				preparedStatement.setString(2, user.getEmail());
				var result = preparedStatement.executeQuery();

				while (result.next()) {
					var pedido = new Pedido();
					
					pedido.setId(result.getInt("id"));
					pedido.setNome(result.getString("nome"));
					pedido.setEndereco(result.getString("endereco"));
					pedido.setValor(result.getDouble("valor"));
					pedido.setDescricao(result.getString("descricao"));
					
					pedidos.add(pedido);
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
				
				pedidos = new LinkedList<Pedido>();
			}
		}
		
		return pedidos;
	}

}
