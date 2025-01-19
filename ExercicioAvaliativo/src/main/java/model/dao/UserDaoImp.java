package model.dao;

import java.sql.SQLException;

import model.dao.connection.DatabaseConnection;
import model.entity.User;

public class UserDaoImp implements UserDao {

	/* tabela usuario criada no banco de dados
	  create table usuario_db(
		email VARCHAR(128) NOT NULL PRIMARY KEY,
	    senha VARCHAR(128) NOT NULL
		);
	 
	 método de inserir o admin no banco de dados
	 insert into usuario_db (email, senha) VALUES ("admin@gmail.com", "admin");
	 
	 */
	
	private static final String INSERT = "INSERT INTO usuario_db (email, senha) VALUES (?, ?)";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM usuario_db WHERE email = ?";
	
	// Função de inserir usuario
	@Override
	public boolean insert(User user) {
		int rows = 0;
		if(user != null) {
			try(var connection = DatabaseConnection.getConnection();
					var statement = connection.prepareStatement(INSERT)) {
				
				statement.setString(1, user.getEmail());
				statement.setString(2, user.getSenha());
				
				rows = statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rows > 0;
	}

	// Função de encontrar o usuario pelo email
	@Override
	public User findByEmail(String email) {
		User user = null;
		try(var connection = DatabaseConnection.getConnection();
				var statement = connection.prepareStatement(SELECT_BY_EMAIL)) {
			
			statement.setString(1, email);
			
			var resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				user = new User(resultSet.getString("email"), resultSet.getString("senha"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			user = null;
		}
		
		return user;
	}

}
