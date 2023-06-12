package com.expense.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expense.entity.Expense;
import com.expense.entity.user;
import com.expense.repository.ExpenseRepository;
import com.expense.repository.UserRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository bRepo;
	@Autowired 
	private UserRepository urepo;
	
	public Expense save(Expense b, String username) {
		user name= urepo.findByEmail(username);
		b.setuser(name);
		return bRepo.save(b);
	}
	
	public List<Expense> getAllExpense(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
	    return bRepo.findAllByUserEmail(username);
	}
	
	public Expense getById(int id, String username) {
		//user name= urepo.findByEmail(username);
		return bRepo.findByIdAndUserId(id, username);
	}
	@Transactional
	public void deleteExpenseByIdAndUserId(int id, String u) {
		bRepo.deleteByIdAndUserId(id, u);
	}
}
