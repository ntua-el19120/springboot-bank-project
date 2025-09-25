package com.example.demo.Controllers;

import java.util.ArrayList;

import com.example.demo.Model.Transaction;
import com.example.demo.Model.AccountBalance;

public class BalanceCalculator {

    public static ArrayList<AccountBalance> getBalances(ArrayList<Transaction> a) {

        int index = 0;
        double balance;
        int acc = a.get(0).getAccountID();
        ArrayList<AccountBalance> accounts = new ArrayList<>();

        while (index < a.size()) {
            acc = a.get(index).getAccountID();
            balance = 0;
            while (index < a.size() && a.get(index).getAccountID() == acc) {
                if (a.get(index).getType().equals("deposit")) {
                    balance = balance + a.get(index).getAmount();
                    index++;
                } else if (a.get(index).getType().equals("withdrawal")) {
                    balance = balance - a.get(index).getAmount();
                    index++;
                }

            }

            AccountBalance account = new AccountBalance(acc, balance);
            accounts.add(account);
        }

        return accounts;
    }
}
