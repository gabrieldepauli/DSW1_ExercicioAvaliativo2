package model.dao;

import java.sql.ResultSet;
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
	 CREATE TABLE pedido_db (
	    id INT AUTO_INCREMENT,
	    nome VARCHAR(150) NOT NULL,
	    endereco VARCHAR(200) NOT NULL,
	    valor DECIMAL(10,2) NOT NULL,
	    descricao VARCHAR(500),
	    username VARCHAR(150) NOT NULL,
	    PRIMARY KEY (id),
	    UNIQUE (username, id),
	    FOREIGN KEY (username) REFERENCES usuario_db(email) ON DELETE CASCADE
	);
	 *
	 */
	
	// Métodos de consultas no Banco
	private static final String INSERT = "INSERT INTO pedido_db (nome, endereco, valor, descricao, username) VALUES (?, ?, ?, ?, ?)";
	private static final String SELECT_BY_NAME = "SELECT * FROM pedido_db WHERE nome LIKE ? AND username = ? ORDER BY nome";
	private static final String SELECT_BY_ID = "SELECT * FROM pedido_db WHERE id = ? AND username = ?";
	private static final String SELECT_ALL = "SELECT * FROM pedido_db WHERE username = ?";
	private static final String UPDATE = "UPDATE pedido_db SET nome = ?, endereco = ?, valor = ?, descricao = ? WHERE id = ?";
	private static final String DELETE = "DELETE FROM pedido_db WHERE id = ? AND username = ?";
	
	// Método utilizado para criar o pedido no Banco de Dados
	@Override
	public boolean create(User user, Pedido pedido) {
		if(pedido != null) {
			int rows = -1;
			
			try ( var connection = DatabaseConnection.getConnection();
					  var preparedStatement = connection.prepareStatement(INSERT)) {

				preparedStatement.setString(1, pedido.getNome());
				preparedStatement.setString(2, pedido.getEndereco());
				preparedStatement.setDouble(3, pedido.getValor());
				preparedStatement.setString(4, pedido.getDescricao());
				preparedStatement.setString(5, user.getEmail());
					
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

	// Método utilizado para deletar o pedido no Banco de Dados
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

	// Método utilizado para atualizar o pedido no Banco de Dados
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
				preparedStatement.setInt(5, id);
				
				rows = preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
					e.printStackTrace();
			}
				
			return rows > 0;
		}
		
		return false;
	}

	// Método utilizado para recuperar um pedido em específico do Banco de Dados
	@Override
	public Pedido retrieve(User user, int id) {
		Pedido pedido = null;
			
		try(var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
				
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, user.getEmail());
			
			var result = preparedStatement.executeQuery();
			
			if(result.next()) {
				pedido = new Pedido();
				pedido.setId(result.getInt("id"));
				pedido.setNome(result.getString("nome"));
				pedido.setEndereco(result.getString("endereco"));
				pedido.setValor(result.getDouble("valor"));
				pedido.setDescricao(result.getString("descricao"));
			}
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}
	
		return pedido; 
	}
	
	// Método utilizado para recuperar a lista de pedidos do Banco de Dados
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
				pedido.setDescricao(result.getString("descricao"));
				
				user.addPedido(pedido);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user.getPedidos();
	}

	// Método utilizado para procurar o pedido pelo nome
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
