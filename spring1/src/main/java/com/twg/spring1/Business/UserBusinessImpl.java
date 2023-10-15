package com.twg.spring1.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.twg.spring1.Dao.UserDaoInterface;
import com.twg.spring1.Entities.User;

@Component
public class UserBusinessImpl implements UserBusinessInterface {
	
   @Autowired
	private UserDaoInterface userDaoInterface;
	public UserDaoInterface getUserDaoInterface() {
	return userDaoInterface;
}

public void setUserDaoInterface(UserDaoInterface userDaoInterface) {
	this.userDaoInterface = userDaoInterface;
}

	@Override
	public void save(User user) {
		
		userDaoInterface.save(user);
	}

	@Override
	public void update(User user) {
		
		userDaoInterface.update(user);
		
	}

	

	@Override
	public List<User> finaAll() {
		
		return userDaoInterface.finaAll();
	}

	@Override
	public void delete(User user) {
		
		userDaoInterface.delete(user);
	}
    
	//Login Functionality
	@Override
	public User find(User user) {
		//String pwd=user.getPassword();
		//User user1=userDaoInterface.find(user);
		// DbPwd=user1.getPassword();
		/*if(pwd.equals(DbPwd)) {
			return true;
		}
		
		return false;*/
		return userDaoInterface.find(user);
	}

	@Override
	public User findByname(String username) {
		// 
		return userDaoInterface.findByname(username);
	}
}
