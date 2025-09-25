package com.example.demo.Routes;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CSVLoaders.Accounts;
import com.example.demo.CSVLoaders.Beneficiaries;
import com.example.demo.Controllers.BinarySearchAccounts;
import com.example.demo.Controllers.BinarySearchTransaction;
import com.example.demo.Model.Transaction;
import com.example.demo.Model.Account;
import com.example.demo.Model.Beneficiary;
import com.example.demo.Model.BeneficiaryWithTransactions;


@RestController
public class exercise4demo {
    
    @GetMapping("/getbalance/{id}")


public double getTransactionsById(@PathVariable int id) {
    ArrayList<Account> accounts = Accounts.getAccounts();

    ArrayList<Beneficiary> beneficiaries = Beneficiaries.getBeneficiaries();
    
    
    ArrayList<Account> accountsById = new ArrayList<>();
    ArrayList<Integer> indexes = BinarySearchAccounts.binarySearchAll(0, accounts.size() - 1, id);

    for (int i : indexes) {
        accountsById.add(accounts.get(i));
    }

    ArrayList<Integer> accountIDs = new ArrayList<>();
    for (Account acc : accountsById) {
        accountIDs.add(acc.getAccountID());
    }

    ArrayList<Transaction> transactionsById = BinarySearchTransaction.binarySearchAllByAccounts(accountIDs);

    BeneficiaryWithTransactions allTransactions= new BeneficiaryWithTransactions(beneficiaries.get(id - 1), transactionsById);

    return BeneficiaryWithTransactions.getBalance(allTransactions);

    
}}

