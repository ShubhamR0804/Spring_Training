package com.techlabs.validationandexception.service;

import com.techlabs.validationandexception.dto.PageResponseDto;
import com.techlabs.validationandexception.entity.Loan;

public interface LoanService {
	
	PageResponseDto<Loan> getAllLoans(int pageNumber, int pageSize);

    Loan getLoan(int loanId);

    Loan insertLoan(Loan loan);

    Loan updateLoan(Loan loan);

}
