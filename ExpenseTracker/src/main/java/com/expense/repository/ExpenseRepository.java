package com.expense.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expense.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer>  {
	 List<Expense> findAllByUserEmail(@Param("email") String email);
	 void deleteByIdAndUserEmail(int recordId, String userId);
	 Expense findByIdAndUserEmail(int id, String username);
//	 @Query("SELECT e FROM Expense e WHERE MONTH(e.dateColumn) = :month AND YEAR(e.dateColumn) = :year")
//	 List<Expense> findByMonthAndYear(@Param("month")int month, @Param("year")int year);
//	 @Query("SELECT e FROM Expense e WHERE MONTH(e.dateColumn) = :month")
//	    List<Expense> findByMonth(@Param("month")int month);
//	    @Query("SELECT e FROM Expense e WHERE YEAR(e.dateColumn) = :year")
//	    List<Expense> findByYear(@Param("year") int year);



}
