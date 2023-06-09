package com.expense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.expense.entity.Expense;
import com.expense.service.ExpenseService;
//import com.expense.service.MyBookListService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
//@RequestMapping("/login")
public class MainController {
	
	
	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	
	
}
