package com.techlabs.bank.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.techlabs.bank.entity.Accounts;
import com.techlabs.bank.entity.Customers;
import com.techlabs.bank.entity.EmailDetails;
import com.techlabs.bank.entity.Transactions;
import com.techlabs.bank.entity.dto.AccountDto;
import com.techlabs.bank.entity.dto.CustomerDto;
import com.techlabs.bank.entity.dto.PageResponse;
import com.techlabs.bank.entity.dto.TransactionDto;
import com.techlabs.bank.exception.ResourceNotFoundException;
import com.techlabs.bank.repository.AccountRepository;
import com.techlabs.bank.repository.CustomerRepository;
import com.techlabs.bank.repository.TransactionRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
    private EmailService emailService;
	

	public CustomerDto addCustomer(CustomerDto customerDto) {
		Customers customer = new Customers();
		// map dto fields to entity
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setEmail(customerDto.getEmail());
		customer.setPhone(customerDto.getPhone());
		customer.setAddress(customerDto.getAddress());
		// save customer
		customer = customerRepository.save(customer);
		return toDto(customer);
	}

	public PageResponse<CustomerDto> getAllCustomers(int pageNo, int pageSize) {
		PageRequest pageable = PageRequest.of(pageNo, pageSize);
		Page<Customers> customerPage = customerRepository.findAll(pageable);
		List<CustomerDto> customersDto = customerPage.stream()
				.map(this :: toDto).collect(Collectors.toList());
		
		PageResponse<CustomerDto> pageResponse = new PageResponse<>();
	    pageResponse.setSize(customerPage.getSize());
	    pageResponse.setTotalElements(customerPage.getTotalElements());
	    pageResponse.setTotalPages(customerPage.getTotalPages());
	    pageResponse.setLastPage(customerPage.isLast());
	    pageResponse.setContents(customersDto);
		
		return pageResponse;
		/*
		 * List<Customers> customers = customerRepository.findAll(); return
		 * customers.stream().map(this::toDto).collect(Collectors.toList());
		 */
	}

	public CustomerDto getCustomerById(int customerId) {
		Customers customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
		return toDto(customer);
	}

	public CustomerDto updateCustomer(int customerId, CustomerDto customerDto) {
		Customers customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
		// update fields
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setEmail(customerDto.getEmail());
		customer.setPhone(customerDto.getPhone());
		customer.setAddress(customerDto.getAddress());
		// save updated customer
		customer = customerRepository.save(customer);
		return toDto(customer);
	}

	public AccountDto addAccount(int customerId, Accounts accounts) {
		Customers customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
		Accounts account = new Accounts();
		long accountNumber=generateRandomAccountNumber();
		// map dto fields to entity
		//This was changed 
		account.setAccountNumber(accountNumber);
		account.setAccountType(accounts.getAccountType());
		account.setBalance(accounts.getBalance());
		account.setCustomer(customer);
		// save account
		account = accountRepository.save(account);
		EmailDetails emailDetails = setEmailDetails(account);
		emailService.sendSimpleEmail(emailDetails);
		return toDto(account);
	}
	private EmailDetails setEmailDetails(Accounts accounts) {
	    EmailDetails emailDetails = new EmailDetails();
	    emailDetails.setRecipient(accounts.getCustomer().getUser().getUsername());
	    emailDetails.setSubject("Customer Registration Successfull");
	    emailDetails.setMsgBody("Welcome Customer : "+accounts.getCustomer().getFirstName() +" " + accounts.getCustomer().getLastName() +
	    "\n Your Account Id : "+accounts.getAccountId() +
	    "\n Your Account Number : " +accounts.getAccountNumber()
	    +"\n Your Account Type : "+accounts.getAccountType() +"\n Your Balance : "+accounts.getBalance());
	    return emailDetails;
	}

	public List<TransactionDto> getAllTransactions() {
		List<Transactions> transactions = transactionRepository.findAll();
		return transactions.stream().map(this::toDto).collect(Collectors.toList());
	}
	
	public boolean doesAccountBelongToCustomer(int accountId, int customerId) {
	    Accounts account = accountRepository.findById(accountId)
	            .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
	    return account.getCustomer().getCustomerId() == customerId;
	}

	private CustomerDto toDto(Customers customer) {
		CustomerDto dto = new CustomerDto();
		// map entity fields to dto
		dto.setCustomerId(customer.getCustomerId());
		dto.setFirstName(customer.getFirstName());
		dto.setLastName(customer.getLastName());
		dto.setEmail(customer.getEmail());
		dto.setPhone(customer.getPhone());
		dto.setAddress(customer.getAddress());
		//dto.setAccounts(customer.getAccounts().stream().map(this::toDto).collect(Collectors.toList()));
		//THIS WAS CHANGED IF YOU WANT TO UNCOMMENT THIS THEN ALSO UNCOMMENT THE LAST LINE IN CustomerDto
		/*
		 * if (customer.getAccounts() != null && !customer.getAccounts().isEmpty()) {
		 * dto.setAccounts(customer.getAccounts().stream().map(this::toDto).collect(
		 * Collectors.toList())); } else { dto.setAccounts(new ArrayList<>()); }
		 */
		return dto;
	}
	
	private long generateRandomAccountNumber() {
        SecureRandom random = new SecureRandom();
        return random.nextLong(1000000000L, 10000000000L); // Generates a 10-digit long
    }

	private AccountDto toDto(Accounts account) {
		AccountDto dto = new AccountDto();
		dto.setAccountId(account.getAccountId());
		dto.setAccountNumber(account.getAccountNumber());
		dto.setAccountType(account.getAccountType());
		dto.setBalance(account.getBalance());
		return dto;
	}

	private TransactionDto toDto(Transactions transaction) {
		TransactionDto dto = new TransactionDto();
		dto.setTransactionId(transaction.getTransactionId());
		dto.setTransactionType(transaction.getTransactionType());
		dto.setAmount(transaction.getAmount());
		dto.setDescription(transaction.getDescription());
		dto.setSenderAccountId(transaction.getAccount().getAccountId());
		return dto;
	}
}
