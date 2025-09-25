package com.example.demo.Routes;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CSVLoaders.Accounts;
import com.example.demo.CSVLoaders.Beneficiaries;
import com.example.demo.Model.Account;
import com.example.demo.Model.Beneficiary;
import com.example.demo.Controllers.BinarySearchAccounts;
import com.example.demo.Model.BeneficiaryWithAccounts;

@RestController
public class exercise2 {

    @GetMapping("/beneficiaryAccounts/{id}")
    public BeneficiaryWithAccounts getAccountById(@PathVariable int id) {
        ArrayList<Beneficiary> beneficiaries = Beneficiaries.getBeneficiaries();
        ArrayList<Account> accounts = Accounts.getAccounts();
        ArrayList<Account> accountsById = new ArrayList<>();

        ArrayList<Integer> indexes = BinarySearchAccounts.binarySearchAll(0, accounts.size() - 1, id);

        for (int i : indexes) {
            accountsById.add(accounts.get(i));
        }

        return new BeneficiaryWithAccounts(beneficiaries.get(id - 1), accountsById);
    }
}

