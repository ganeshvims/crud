package com.nav.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nav.entities.User;
import com.nav.repositories.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void saveUserInformation(User user) {
		userRepo.save(user);	
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public User findUserById(long id) {
		Optional<User> findById = userRepo.findById(id);
		User user = findById.get();
		return user;
	}

	@Override
	public void deleteUser(long id) {
		userRepo.deleteById(id);
		
	}

	@Override
	public User getOneUser(long id) {
		Optional<User> findById = userRepo.findById(id);
		User user = findById.get();
		return user;
	}

	@Override
	public void saveUserInfo(User user) {
		userRepo.save(user);
		
	}

	@Override
	public void deleteOneUser(long id) {
		userRepo.deleteById(id);
		
	}

}
