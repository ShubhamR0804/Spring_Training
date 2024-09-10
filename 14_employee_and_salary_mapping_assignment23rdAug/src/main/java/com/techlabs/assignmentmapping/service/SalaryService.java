package com.techlabs.assignmentmapping.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.techlabs.assignmentmapping.dto.PageDto;
import com.techlabs.assignmentmapping.entity.Salary;
import com.techlabs.assignmentmapping.entity.SalaryTransaction;

public interface SalaryService {

	Salary saveSalary(Salary salary);

    PageDto getAllSalaries(int pageSize, int pageNumber);

    Salary getSalaryById(int id);

    SalaryTransaction saveSalaryTransaction(SalaryTransaction transaction);
}
