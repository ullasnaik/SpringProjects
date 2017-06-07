package com.ullas.repo.services;

import com.ullas.repo.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
	
	
	public User getUser(long userId);
	public User getUser(String email);
	public User addUser(String firstName,String lastName,String email,String sex,String password);

}
