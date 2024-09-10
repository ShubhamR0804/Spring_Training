package com.techlabs.bank.entity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomerDto {
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private long phone;
    private String address;
    private List<AccountDto> accounts;

}
