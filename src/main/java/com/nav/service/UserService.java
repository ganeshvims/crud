package com.nav.service;


import java.util.List;

import com.nav.entities.User;





 public interface UserService {
	public void saveUserInformation(User user);

	public List<User> getAllUsers();

	public User findUserById(long id);
	public void deleteUser(long id);

	public User getOneUser(long id);

	public void saveUserInfo(User user);

	public void deleteOneUser(long id);

}
