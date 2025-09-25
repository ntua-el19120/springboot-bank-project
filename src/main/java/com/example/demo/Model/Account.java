package com.example.demo.Model;

public class Account {
    
    int AccountID;
    int BeneficiaryID;
    
    public Account(int AccountID, int BeneficiaryID){
        this.AccountID=AccountID;
        this.BeneficiaryID=BeneficiaryID;
    }

    // public void printInfo() {
    //     System.out.println("Beneficiary: " + BeneficiaryID + ", AccountID: " + AccountID+ "\n");
    // }

    // public String toString() {
    //     return "Beneficiary: " + BeneficiaryID + ", AccountID: " + AccountID+ "\n";
    // }

    public int getBeneficiaryID(){
       return BeneficiaryID; 
    }

    public int getAccountID() {
        return AccountID;
    }
}
