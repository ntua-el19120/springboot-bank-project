package com.example.demo.Routes;
import com.example.demo.CSVLoaders.Accounts;
import com.example.demo.Model.Account;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AllAccounts {
@GetMapping("/allaccounts")
public ArrayList<Account> hello() {

    return Accounts.getAccounts();
}
    
}
