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
	
	public List<Expense> getAllExpenses(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
	    return bRepo.findAllByUserEmail(username);
	}
	
	public Expense getById(int id, String username) {
		//user name= urepo.findByEmail(username);
		return bRepo.findByIdAndUserEmail(id, username);
	}
	@Transactional
	public void deleteExpenseByIdAndUserId(int id, String u) {
		bRepo.deleteByIdAndUserEmail(id, u);
	}
//	public List<Expense> getFilteredEntries(String month, String year) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	    String username = authentication.getName();
//		if (month != "00" && year != "0000") {
//            // Filter entries based on both month and year
//			int m = Integer.parseInt(month);
//			int y = Integer.parseInt(year);  
//            return bRepo.findByMonthAndYear(m, y);
//        } else if (month != "00") {
//            // Filter entries based on month only
//        	int m = Integer.parseInt(month);
//            return bRepo.findByMonth(m);
//        } else if (year != "0000") {
//            // Filter entries based on year only
//        	int y = Integer.parseInt(year); 
//            return bRepo.findByYear(y);
//        } else {
//            // No filters specified, return all entries
//            return bRepo.findAllByUserEmail(username);
//        }
//    }

}
