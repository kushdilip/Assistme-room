package com.tavant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.db.impl.UserDAO;
import com.tavant.domain.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDAO.insert(user);

	}

	public User selectByEmailId(String emailId) {
		return userDAO.selectByEmailId(emailId);
	}

}
