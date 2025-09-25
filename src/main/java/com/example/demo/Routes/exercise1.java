package com.example.demo.Routes;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CSVLoaders.Accounts;
import com.example.demo.CSVLoaders.Beneficiaries;
import com.example.demo.Model.Account;
import com.example.demo.Model.Beneficiary;

@RestController

public class exercise1 {

    @GetMapping("/benefeciary/{id}")

    public Beneficiary getAccountById(@PathVariable int id) {
        ArrayList<Beneficiary> result = Beneficiaries.getBeneficiaries();
        ArrayList<Account> accounts = Accounts.getAccounts();

        Optional<Account> targetAccount = accounts.stream()
                .filter(account -> account.getAccountID() == id)
                .findFirst();

        Account acc = targetAccount.get();
        int index = acc.getBeneficiaryID();

        return result.get(index - 1);
    }
}
