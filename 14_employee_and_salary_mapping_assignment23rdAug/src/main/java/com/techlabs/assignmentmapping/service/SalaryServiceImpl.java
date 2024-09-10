package com.techlabs.assignmentmapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techlabs.assignmentmapping.dto.PageDto;
import com.techlabs.assignmentmapping.entity.Salary;
import com.techlabs.assignmentmapping.entity.SalaryTransaction;
import com.techlabs.assignmentmapping.repository.SalaryRepository;
import com.techlabs.assignmentmapping.repository.SalaryTransactionRepository;

@Service
public class SalaryServiceImpl implements SalaryService{

	@Autowired
	private SalaryRepository salaryRepository;

    @Autowired
    private SalaryTransactionRepository salaryTransactionRepository;
    
	@Override
	public Salary saveSalary(Salary salary) {
		// TODO Auto-generated method stub
		return salaryRepository.save(salary);
	}

	@Override
	public PageDto getAllSalaries(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Salary> salaryPage = salaryRepository.findAll(pageable);
		PageDto salaryPageDto = new PageDto();
		salaryPageDto.setTotalPages(salaryPage.getTotalPages());
		salaryPageDto.setTotalElements(salaryPage.getTotalElements());
		salaryPageDto.setSize(salaryPage.getSize());
		salaryPageDto.setContent(salaryPage.getContent());
		salaryPageDto.setLastPage(salaryPage.isLast());
		return salaryPageDto;
	}

	@Override
	public Salary getSalaryById(int id) {
		// TODO Auto-generated method stub
		return  salaryRepository.findById(id).orElse(null);
	}

	@Override
	public SalaryTransaction saveSalaryTransaction(SalaryTransaction transaction) {
		// TODO Auto-generated method stub
		return salaryTransactionRepository.save(transaction);
	}


}
