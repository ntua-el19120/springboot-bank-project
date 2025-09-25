package com.example.demo.Routes;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CSVLoaders.Transactions;
import com.example.demo.Model.Transaction;
import java.util.ArrayList;

@RestController
public class AllTransactions {
    
    @GetMapping("/alltransactions")
    public ArrayList<Transaction> hello() {

        return Transactions.getTransactions();

    }

}



