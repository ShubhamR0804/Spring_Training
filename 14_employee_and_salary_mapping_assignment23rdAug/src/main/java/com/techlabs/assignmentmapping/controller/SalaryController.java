package com.techlabs.assignmentmapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.assignmentmapping.dto.PageDto;
import com.techlabs.assignmentmapping.entity.Salary;
import com.techlabs.assignmentmapping.entity.SalaryTransaction;
import com.techlabs.assignmentmapping.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	@PostMapping("/addsalaries")
    public ResponseEntity<Salary> createSalary(@RequestBody Salary salary) {
        Salary savedSalary = salaryService.saveSalary(salary);
        return ResponseEntity.ok(savedSalary);
    }

    @GetMapping("/allsalaries")
    public ResponseEntity<PageDto> getAllSalaries(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return ResponseEntity.ok(salaryService.getAllSalaries(pageSize, pageNumber));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salary> getSalaryById(@PathVariable int id) {
        Salary salary = salaryService.getSalaryById(id);
        return salary != null ? ResponseEntity.ok(salary) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/transactions")
    public ResponseEntity<SalaryTransaction> createSalaryTransaction(@PathVariable int id,@RequestBody SalaryTransaction transaction) 
    {
        Salary salary = salaryService.getSalaryById(id);
        if (salary != null) {
            transaction.setSalary(salary);
            SalaryTransaction savedTransaction = salaryService.saveSalaryTransaction(transaction);
            return ResponseEntity.ok(savedTransaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
