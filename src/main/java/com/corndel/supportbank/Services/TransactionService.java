package com.corndel.supportbank.Services;


import com.corndel.supportbank.models.TransactionModel;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Command(name = "Summarise", description = "Updates users accounts with the value")
public class TransactionService implements Runnable {

    @Parameters(index = "0", description = "holds filename")
    private String Filename;

    @Override
    public void run() {
        Path filePath = Paths.get("src", "data", "transactions", "Transactions2014.csv");
        List<TransactionModel> transactions = new ArrayList<>();
        Map<String, Double> userBalances = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (int i = 1; i < lines.size(); i++) {

                String line = lines.get(i);
                String[] values = line.split(",");
                String date = values[0];
                String from = values[1];
                String to = values[2];
                String narrative = values[3];
                double amount = Double.parseDouble(values[4]);

                TransactionModel transaction = new TransactionModel(date, from, to, narrative, amount);
                transactions.add(transaction);
                userBalances.put(from, userBalances.getOrDefault(from, 0.0) - amount); //
                userBalances.put(to, userBalances.getOrDefault(to, 0.0) + amount);
            }
            for (Map.Entry<String, Double> entry : userBalances.entrySet()) {
                System.out.println(entry.getKey() + " has a balance of: " + String.format("£%.2f", entry.getValue()));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}