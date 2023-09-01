package com.acn.bootcamp.simpleshop.data.dto;

import com.acn.bootcamp.simpleshop.data.enums.BankingServiceProvider;

public record BankAccountDto(String number, BankingServiceProvider provider) {

}
