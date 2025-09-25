package com.example.demo.Model;

import java.util.ArrayList;

public class AccountWithBalances {
   
    Beneficiary Account;
    ArrayList<AccountBalance> Balances;
    
    public AccountWithBalances(Beneficiary Account, ArrayList<AccountBalance> Balances){
        this.Account=Account;
        this.Balances=Balances;
    }

    public ArrayList<AccountBalance> getBalances(){
       return Balances; 
    }

    public Beneficiary getAccountID() {
        return Account;
    }



}
