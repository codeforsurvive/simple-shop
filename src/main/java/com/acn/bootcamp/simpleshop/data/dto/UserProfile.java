package com.acn.bootcamp.simpleshop.data.dto;

import lombok.Setter;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Setter @Getter
public class UserProfile extends UserCredential {
    private String name;
    private String registrationNumber;
    private RoleDto role;
    private Set<ContactDto> contacts;
    private Set<BankAccountDto> bankAccounts;

    public UserProfile(String username, String name, String registrationNumber, RoleDto role) {
        this(username, null, name, registrationNumber, role);
    }

    public UserProfile(String username, String password, String name, String registrationNumber, RoleDto role) {
        super(username, password);
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.role = role;
        this.contacts = new HashSet<>();
        this.bankAccounts = new HashSet<>();
    }

    public void addContact(ContactDto contact) {
        contacts.add(contact);
    }

    public void addBankAccount(BankAccountDto bankAccount){
        bankAccounts.add(bankAccount);
    }
}
