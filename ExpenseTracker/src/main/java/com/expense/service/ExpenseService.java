package com.expense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.entity.Expense;
import com.expense.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository bRepo;
	
	public Expense save(Expense b) {
		return bRepo.save(b);
	}
	
	public List<Expense> getAllExpense(){
		return bRepo.findAll();
	}
	
	public Expense getBookById(int id) {
		return bRepo.findById(id).orElse(null);
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}
