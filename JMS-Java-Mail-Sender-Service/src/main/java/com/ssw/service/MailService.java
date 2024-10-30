package com.ssw.service;

import java.util.List;

import com.ssw.model.User;

public interface MailService {

	void saveUser(User user);

	List<User> getUser();

	User loginUser(String username, String password);

	String deleteUserById(int uid);

	

}
