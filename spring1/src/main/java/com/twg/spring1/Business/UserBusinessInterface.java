package com.twg.spring1.Business;

import java.util.List;

import com.twg.spring1.Entities.User;

public interface UserBusinessInterface {
	public void save(User user);
	public void update(User user);
	public User find(User user);
	public List<User> finaAll();
	public void delete(User user);
	public User findByname(String username);
}
