package com.example.demo.Model;

public class AccountBalance {
        
    int AccountID;
    double Balance;
    
    public AccountBalance(int AccountID, double Balance){
        this.AccountID=AccountID;
        this.Balance=Balance;
    }

    public double getBalance(){
       return Balance; 
    }

    public int getAccountID() {
        return AccountID;
    }
}

