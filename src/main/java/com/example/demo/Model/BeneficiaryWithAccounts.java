package com.example.demo.Model;
import java.util.List;


public class BeneficiaryWithAccounts {
    private Beneficiary beneficiary;
    private List<Account> accounts;

    public BeneficiaryWithAccounts(Beneficiary beneficiary, List<Account> accounts) {
        this.beneficiary = beneficiary;
        this.accounts = accounts;
    }

    public String toString(){
        String Accounts=Integer.toString(accounts.get(0).getAccountID());
        for(int i=1; i<accounts.size();i++){
            Accounts = Accounts +", "+ Integer.toString(accounts.get(i).getAccountID());
        }
        return "Beneficiary ID: " + Integer.toString(beneficiary.getBeneficiaryID()) + "\n"
                + "First Name: " + beneficiary.getFirstName() + "\n"
                + "Last Name: " + beneficiary.getLastName() + "\n"
                + "Account IDs: " + Accounts;
    }

    

    public Beneficiary getBeneficiary() { return beneficiary; }
    public List<Account> getAccounts() { return accounts; }
}

