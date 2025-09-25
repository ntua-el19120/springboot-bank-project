package com.example.demo.CSVLoaders;

import com.example.demo.Model.Account;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Accounts {

    private static ArrayList<Account> accounts = new ArrayList<>();
    
    static {
        loadAccounts();
    }

    private static void loadAccounts() {
        String line;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource("accounts.csv").getInputStream()))) {
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length == 2) {
                    int accountID = Integer.parseInt(values[0]);
                    int beneficiaryID = Integer.parseInt(values[1]);

                    Account account = new Account(accountID, beneficiaryID);
                    accounts.add(account);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        accounts.sort((a1, a2) -> Integer.compare(a1.getBeneficiaryID(), a2.getBeneficiaryID()));
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }
}
