package com.example.demo.Controllers;

import java.util.ArrayList;
import com.example.demo.Model.Account;
import com.example.demo.CSVLoaders.Accounts;
//https://www.geeksforgeeks.org/java/binary-search-in-java/
public class BinarySearchAccounts {

    public static ArrayList<Integer> binarySearchAll(int l, int r, int target) {   
        ArrayList<Account> accounts = Accounts.getAccounts();
        ArrayList<Integer> indexes = new ArrayList<>();

        while (l <= r) {
            int m = (l + r) / 2;
            Account examined = accounts.get(m);

            if (examined.getBeneficiaryID() == target) {
                indexes.add(m);

                for (int i = m - 1; i >= 0; i--) {
                    if (accounts.get(i).getBeneficiaryID() == target) {
                        indexes.add(i);
                    } else {
                        break;
                    }
                }
                for (int i = m + 1; i < accounts.size(); i++) {
                    if (accounts.get(i).getBeneficiaryID() == target) {
                        indexes.add(i);
                    } else {
                        break;
                    }
                }

                break; 
            } 
            else if (examined.getBeneficiaryID() > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }  
        }

        return indexes; 
    }
}
