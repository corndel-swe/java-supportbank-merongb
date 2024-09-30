package com.corndel.supportbank.Services;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

@Command(name = "Convert")
public class Converter implements Runnable{

        @Parameters(index = "0", description = "The amount being divided")
        private double amount;

        @Parameters(index = "1", description = "Currency1")
        private String fromCurrency;

        @Parameters(index = "2", description = "Currency2")
        private String toCurrency;

        @Override
        public void run() {
            double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
            if (convertedAmount == -1) {
                System.out.println("Error: Invalid currency specified.");
            } else {
                String msg = String.format("%.2f %s is equivalent to %.2f %s", amount, fromCurrency, convertedAmount, toCurrency);
                System.out.println(msg);
            }
        }

        private double convertCurrency(double amount, String fromCurrency, String toCurrency) {

            double rate = 0.0;

            //  conversion rates
            if ("USD".equals(fromCurrency) && "GBP".equals(toCurrency)) {
                rate = 0.75;
            } else if ("GBP".equals(fromCurrency) && "USD".equals(toCurrency)) {
                rate = 1.33;
            } else if ("USD".equals(fromCurrency) && "EUR".equals(toCurrency)) {
                rate = 0.85;
            } else if ("EUR".equals(fromCurrency) && "USD".equals(toCurrency)) {
                rate = 1.18;
            } else if ("GBP".equals(fromCurrency) && "EUR".equals(toCurrency)) {
                rate = 1.17;
            } else if ("EUR".equals(fromCurrency) && "GBP".equals(toCurrency)) {
                rate = 0.85;
            } else {
                return -1;
            }

            return amount * rate;
        }
    }
