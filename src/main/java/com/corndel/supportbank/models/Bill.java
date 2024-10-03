package com.corndel.supportbank.models;

import com.corndel.supportbank.Services.Converter;
import com.corndel.supportbank.Services.Split;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command (name = "Bill", description = "Takes an amount and divisor and equally divides it", subcommands = {Split.class, Converter.class})
public class Bill  {


    private double price;

    public Bill(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double split(double people) {
        return price / people;
    }


    public String toString() {
        return "Bill{" +
                ", price=" + price +
                '}';
    }
}
