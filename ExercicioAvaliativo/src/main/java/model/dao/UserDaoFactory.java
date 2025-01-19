package model.dao;

// Cria instâncias do UserDaoImp()
public class UserDaoFactory {

	public UserDao factory() {
		return new UserDaoImp();
	}
	
}
