package com.expense.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.entity.Role;
import com.expense.entity.user;
import com.expense.login.dto.UserRegistrationDto;
import com.expense.repository.ExpenseRepository;
import com.expense.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	 @Autowired
	 private UserRepository userrepo;
	 
	public UserServiceImpl(UserRepository userrepo) {
		super();
		this.userrepo = userrepo;
	}

	@Override
	public user save(UserRegistrationDto u) {
		user user= new user(u.getFirstName(), u.getLastName(), u.getEmail(), u.getPassword(), Arrays.asList(new Role("Role_User")));
		// TODO Auto-generated method stub
		return userrepo .save(user);
	}
	
	
}
