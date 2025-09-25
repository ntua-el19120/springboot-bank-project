package com.example.demo.Routes;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CSVLoaders.Accounts;
import com.example.demo.CSVLoaders.Beneficiaries;
import com.example.demo.Controllers.BalanceCalculator;
import com.example.demo.Controllers.BinarySearchAccounts;
import com.example.demo.Controllers.BinarySearchTransaction;
import com.example.demo.Model.Transaction;
import com.example.demo.Model.Account;
import com.example.demo.Model.AccountBalance;
import com.example.demo.Model.Beneficiary;
import com.example.demo.Model.Exercise4RequestBody;
import com.example.demo.Model.AccountWithBalances;

@RestController

public class exercise4 {

    @PostMapping("/getbalances")

    public AccountWithBalances getTransactionsById(@RequestBody Exercise4RequestBody benef) {

        ArrayList<Beneficiary> beneficiaries = Beneficiaries.getBeneficiaries();

        Optional<Beneficiary> targetBeneficiary = beneficiaries.stream()
                .filter(beneficiary -> beneficiary.getFirstName().equals(benef.getFirstName()) &&
                        beneficiary.getLastName().equals(benef.getLastName()))
                .findFirst();

        Beneficiary myBeneficiary = targetBeneficiary.get();
        int index = myBeneficiary.getBeneficiaryID();

        ArrayList<Account> accounts = Accounts.getAccounts();

        ArrayList<Account> accountsById = new ArrayList<>();
        ArrayList<Integer> indexes = BinarySearchAccounts.binarySearchAll(0, accounts.size() - 1, index);

        for (int i : indexes) {
            accountsById.add(accounts.get(i));
        }

        ArrayList<Integer> accountIDs = new ArrayList<>();
        for (Account acc : accountsById) {
            accountIDs.add(acc.getAccountID());
        }

        ArrayList<Transaction> transactionsById = BinarySearchTransaction.binarySearchAllByAccounts(accountIDs);

        ArrayList<AccountBalance> balances =  BalanceCalculator.getBalances(transactionsById);

        return new AccountWithBalances(myBeneficiary,balances);

    }

}
