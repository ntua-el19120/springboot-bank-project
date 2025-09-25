package com.example.demo.Controllers;

import java.util.ArrayList;
import com.example.demo.Model.Transaction;
import com.example.demo.CSVLoaders.Transactions;

public class BinarySearchTransaction {

    public static ArrayList<Transaction> binarySearchAllByAccounts(ArrayList<Integer> accountIDs) {
        ArrayList<Transaction> transactions = Transactions.getTransactions();
        ArrayList<Transaction> result = new ArrayList<>();

        for (int accId : accountIDs) {
            int index = binarySearch(transactions, 0, transactions.size() - 1, accId);

            if (index != -1) {

                result.add(transactions.get(index));
                for (int i = index - 1; i >= 0; i--) {
                    Transaction examined = transactions.get(i);
                    if (examined.getAccountID() == accId) {
                        result.add(examined);
                    } else {
                        break;
                    }
                }

                for (int i = index + 1; i < transactions.size(); i++) {
                    Transaction examined = transactions.get(i);
                    if (examined.getAccountID() == accId) {
                        result.add(examined);
                    } else {
                        break;
                    }
                }
            }
        }

        return result;
    }
//https://www.geeksforgeeks.org/java/binary-search-in-java/
    private static int binarySearch(ArrayList<Transaction> transactions, int l, int r, int x)     {   

        while (l <= r) {
            int m = (l + r) / 2;

            // Index of Element Returned
            Transaction examined = transactions.get(m);
            if (examined.getAccountID() == x) {
                return m;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            // so we decrease our r pointer to mid - 1 
            } else if (examined.getAccountID() > x) {
                r = m - 1;

            // Else the element can only be present
            // in right subarray
            // so we increase our l pointer to mid + 1
            } else {
              l = m + 1;
            }  
        }

        // No Element Found
        return -1; 

        // int res = binarySearch(a, 0, n - 1, x);

}
}
