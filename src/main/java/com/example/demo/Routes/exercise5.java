package com.example.demo.Routes;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CSVLoaders.Accounts;
import com.example.demo.Controllers.BinarySearchAccounts;
import com.example.demo.Controllers.BinarySearchTransaction;
import com.example.demo.Model.Transaction;
import com.example.demo.Model.Account;
import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class exercise5 {

    @GetMapping("/ex5/{id}")
    public ResponseEntity<?> getMaxWithdrawal(@PathVariable int id) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfLastMonth = today.minusMonths(1).withDayOfMonth(1);
        LocalDate lastDayOfLastMonth = today.withDayOfMonth(1).minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");

        ArrayList<Account> accounts = Accounts.getAccounts();
        ArrayList<Account> accountsById = new ArrayList<>();
        ArrayList<Integer> indexes = BinarySearchAccounts.binarySearchAll(0, accounts.size() - 1, id);
        for (int i : indexes) {
            accountsById.add(accounts.get(i));
        }
        ArrayList<Integer> accountIDs = new ArrayList<>();
        for (Account acc : accountsById) {
            accountIDs.add(acc.getAccountID());
        }
        ArrayList<Transaction> transactionsById = BinarySearchTransaction.binarySearchAllByAccounts(accountIDs);

        Transaction maxWithdrawal = null;
        for (Transaction t : transactionsById) {
            String dateStr = t.getDate();
            String type = t.getType();
            try {
                LocalDate transDate = LocalDate.parse(dateStr, formatter);
                if (!transDate.isBefore(firstDayOfLastMonth)
                    && !transDate.isAfter(lastDayOfLastMonth)
                    && "withdrawal".equalsIgnoreCase(type)) {
                    if (maxWithdrawal == null || t.getAmount() > maxWithdrawal.getAmount()) {
                        maxWithdrawal = t;
                    }
                }
            } catch (DateTimeParseException ex) {
                System.err.println("Invalid date format for transaction: " + dateStr);
            }
        }

        if (maxWithdrawal == null) {
            // No withdrawal found last month — return a message
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("No withdrawals found in the last month for beneficiary " + id);
        }

        // Otherwise return the found transaction
        return ResponseEntity.ok(maxWithdrawal);
    }
}



