package com.corndel.supportbank.models;


import com.corndel.supportbank.Services.Converter;
import com.corndel.supportbank.Services.Split;

import picocli.CommandLine;
import picocli.CommandLine.Command;


import java.io.IOException;

@Command(name = "Transaction", description = "Stores all the transaction data")
public class TransactionModel {

    private String date;
    private String from;
    private String to;
    private String narrative;
    private double amount;

    public TransactionModel(String date, String from, String to, String narrative, double amount) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.narrative = narrative;
        this.amount = amount;

    }

    @Override
    public String toString() {
        return "Transaction - " +
                "date: '" + date + '\'' +
                ", from: '" + from + '\'' +
                ", to: '" + to + '\'' +
                ", narrative: '" + narrative + '\'' +
                ", amount: " + amount
                ;
    }

    public String getDate() {
        return date;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getNarrative() {
        return narrative;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
