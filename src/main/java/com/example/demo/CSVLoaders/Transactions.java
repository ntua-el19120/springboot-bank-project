package com.example.demo.CSVLoaders;

import com.example.demo.Model.Transaction;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Transactions {

    private static ArrayList<Transaction> transactions = new ArrayList<>();

    static {
        loadTransactions();
    }

    private static void loadTransactions() {
        String line;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource("transactions.csv").getInputStream()))) {

            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length == 5) {
                    int transactionID = Integer.parseInt(values[0]);
                    int accountID = Integer.parseInt(values[1]);
                    double amount = Double.parseDouble(values[2]);
                    String type = values[3];
                    String date = values[4];

                    Transaction transaction = new Transaction(transactionID, accountID, amount, type, date);
                    transactions.add(transaction);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        transactions.sort((a1, a2) -> Integer.compare(a1.getAccountID(), a2.getAccountID()));

    }

    public static ArrayList<Transaction> getTransactions() {
        return transactions;
    }


}
