package com.example.demo.Model;

import java.util.List;

public class BeneficiaryWithTransactions {

    private Beneficiary beneficiary;
    private List<Transaction> transactions;

    public BeneficiaryWithTransactions(Beneficiary beneficiary, List<Transaction> transactions) {
        this.beneficiary = beneficiary;
        this.transactions = transactions;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public static double getBalance(BeneficiaryWithTransactions a) {
        double balance = 0;
        for (int i = 0; i < a.transactions.size(); i++) {

            if (a.transactions.get(i).getType().equals("deposit")) {
                balance = balance + a.transactions.get(i).getAmount();
            } else if (a.transactions.get(i).getType().equals("withdrawal")) {
                balance = balance - a.transactions.get(i).getAmount();
            }
        }
        return balance;
    }

}
