package model.dao;

import model.entity.User;

//Interface Dao para os usuários, que está implementada pelo UserDaoImp
public interface UserDao {

	boolean insert(User user);
	
	User findByEmail(String email); 
	
}
