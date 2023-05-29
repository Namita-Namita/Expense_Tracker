package com.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.expense.entity.Expense;
import com.expense.entity.MyBookList;
import com.expense.service.ExpenseService;
//import com.expense.service.MyBookListService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class ExpenseController {
	
	@Autowired
	private ExpenseService service;
	
	@Autowired
	//private MyBookListService myBookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/new_expense")
	public String Newexpense() {
		return "ExpenseForm";
	}
	
	@GetMapping("/available_expenses")
	public ModelAndView getAllBook() {
		List<Expense>list=service.getAllExpense();
		//System.out.println(list);
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("ExpenseList","expense",list);
	}
	
	@PostMapping("/save")
	public String addExpense(@ModelAttribute Expense b) {
		service.save(b);
		return "redirect:/available_expenses";
	}
//	@GetMapping("/my_books")
//	public String getMyBooks(Model model)
//	{
//		List<MyBookList>list=myBookService.getAllMyBooks();
//		model.addAttribute("book",list);
//		return "myBooks";
//	}
//	@RequestMapping("/mylist/{id}")
//	public String getMyList(@PathVariable("id") int id) {
//		Expense b=service.getBookById(id);
//		MyBookList mb=new MyBookList(b.getId(),b.getAmount(),b.getCurrency(),b.getDate());
//		myBookService.saveMyBooks(mb);
//		return "redirect:/my_books";
//	}
	
	@RequestMapping("/editExpense/{id}")
	public String editExpense(@PathVariable("id") int id, @RequestParam("category") String cat, @RequestParam("currency") String curr,@RequestParam("amount") double amt,@RequestParam("date") @DateTimeFormat(pattern = "dd/MM/yyyy") Date date,@RequestParam("description") String des, Model model) throws ParseException {
		
		Expense b=service.getBookById(id);
		// Format the date as mm-dd-yyyy
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    String d = dateFormat.format(date);
		System.out.println("Category: " + cat);
		System.out.println("Currency: " + curr);
		System.out.println("Date: " + d);
		//date= (Date) date;
		 model.addAttribute("id", id);
		    model.addAttribute("category", cat);
		    model.addAttribute("currency", curr);
		    model.addAttribute("amount", amt);
		    model.addAttribute("date", d);
		    model.addAttribute("description", des);
		//model.addAttribute("Expense",b);
		//model.addAttribute("cssFile", "style.css");
		    
		return "ExpenseFormEdit";
	}
	@RequestMapping("/deleteExpense/{id}")
	public String deleteExpense(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_expenses";
	}
	
}
