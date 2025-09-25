package com.example.demo.CSVLoaders;

import com.example.demo.Model.Beneficiary;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Beneficiaries {

    private static ArrayList<Beneficiary> beneficiaries = new ArrayList<>();

    static {
        loadBeneficiaries();
    }

    private static void loadBeneficiaries() {
        String line;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource("beneficiaries.csv").getInputStream()))) {
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length == 3) {
                    int beneficiaryID = Integer.parseInt(values[0]);
                    String firstName = values[1];
                    String lastName = values[2];

                    Beneficiary beneficiary = new Beneficiary(beneficiaryID, firstName, lastName);
                    beneficiaries.add(beneficiary);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }
}
