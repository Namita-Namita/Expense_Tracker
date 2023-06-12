package com.expense.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expense.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer>  {
	 List<Expense> findAllByUserEmail(@Param("email") String email);
	 void deleteByIdAndUserEmail(int recordId, String userId);
	 Expense findByIdAndUserEmail(int id, String username);



}
