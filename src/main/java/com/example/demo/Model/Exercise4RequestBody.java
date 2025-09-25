package com.example.demo.Model;

public class Exercise4RequestBody {
    
    private String FirstName;
    private String LastName;
    
    public Exercise4RequestBody(String FirstName, String LastName){
        
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
    return LastName;
    
}



}
