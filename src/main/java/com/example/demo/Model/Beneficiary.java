package com.example.demo.Model;

public class Beneficiary {
        
    private int BeneficiaryID;
    private String FirstName;
    private String LastName;
    
    public Beneficiary(int BeneficiaryID, String FirstName, String LastName){
        
        this.BeneficiaryID = BeneficiaryID;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public int getBeneficiaryID(){
       return BeneficiaryID; 
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
    return LastName;
    }
}
