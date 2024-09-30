package com.corndel.supportbank.Services;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import com.corndel.supportbank.models.Bill;

@Command(name = "Split")
public class Split implements Runnable{

    @Parameters(index = "0", description = "The amount being divided")
    private double total;

    @Parameters(index = "1", description = "The number of people to divide the total by")
    private int numPeople;

    @Override
    public void run() {
        Bill bill = new Bill(total);
            String msg = String.format("Each person owes £%.2f", bill.split(numPeople));
            System.out.println(msg);
    }
}
