package com.example.demo.Routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CSVLoaders.Beneficiaries;
import com.example.demo.Model.Beneficiary;
import java.util.ArrayList;

@RestController
public class AllBeneficiaries {

    @GetMapping("/allbeneficiaries")
    public ArrayList<Beneficiary> hello() {

        return Beneficiaries.getBeneficiaries();

    }

}
