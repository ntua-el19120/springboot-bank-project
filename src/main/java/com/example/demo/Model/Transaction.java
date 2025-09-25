package com.example.demo.Model;

public class Transaction {

    private int TransactionID;
    private int AccountID;
    private double Amount;
    private String Type;
    private String Date;

    public Transaction(int TransactionID, int AccountID, double Amount, String Type, String Date) {
        this.TransactionID = TransactionID;
        this.AccountID = AccountID;
        this.Amount = Amount;
        this.Type = Type;
        this.Date = Date;
    }

    public int getTransactionID() {
        return TransactionID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public double getAmount() {
        return Amount;
    }

    public String getType() {
        return Type;
    }

    public String getDate() {
        return Date;
    }
}
