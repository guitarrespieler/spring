package service;

import model.User;

public class UserService {
	
	public User loginUser(String userId, String password){
		User user = this.findUser(userId);
		
		if(user != null && user.getPassword().equals(password))
			return user;
		return null;
	}

	public User findUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
