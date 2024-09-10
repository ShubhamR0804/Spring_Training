package com.techlabs.validationandexception.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techlabs.validationandexception.dto.PageResponseDto;
import com.techlabs.validationandexception.entity.Loan;
import com.techlabs.validationandexception.exception.LoanDoesNotExistException;
import com.techlabs.validationandexception.repository.LoanRepository;

import jakarta.transaction.Transactional;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Override
	public PageResponseDto<Loan> getAllLoans(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Loan> loanPage = loanRepository.findAll(pageable);

        PageResponseDto<Loan> loanPageDto = new PageResponseDto<>();
        loanPageDto.setTotalElements(loanPage.getTotalElements()); // Set total number of elements
        loanPageDto.setTotalPages(loanPage.getTotalPages()); // Set total number of pages
        loanPageDto.setSize(loanPage.getSize()); // Set page size
        loanPageDto.setContent(loanPage.getContent()); // Set content of the page
        loanPageDto.setLastPage(loanPage.isLast()); // Set if this is the last page

        return loanPageDto;
	}

	@Override
	public Loan getLoan(int loanId) {
		// TODO Auto-generated method stub
		Optional<Loan> dbLoan = loanRepository.findById(loanId);
        if (!dbLoan.isPresent()) {
            throw new LoanDoesNotExistException();
        }
        return dbLoan.get();
	}

	@Override
	@Transactional
	public Loan insertLoan(Loan loan) {
		// TODO Auto-generated method stub
		return loanRepository.save(loan);
	}

	@Override
	@Transactional
	public Loan updateLoan(Loan loan) {
		// TODO Auto-generated method stub
		 if (!loanRepository.existsById(loan.getLoanid())) {
	            throw new LoanDoesNotExistException();
	        }
	        return loanRepository.save(loan);
	}

}
