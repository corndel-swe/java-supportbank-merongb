package com.corndel.supportbank;

import com.corndel.supportbank.Controllers.TransactionController;
import com.corndel.supportbank.Services.ConversionRates;
import com.corndel.supportbank.Services.Converter;
import com.github.tomaslanger.chalk.Chalk;
import picocli.CommandLine.Command;
import picocli.CommandLine;
import com.corndel.supportbank.Controllers.BillController;

import java.util.Arrays;

@Command(name = "supportbank", subcommands = {BillController.class, TransactionController.class, Converter.class, ConversionRates.class})
public class SupportBank {

  public static void main(String[] args) {
    CommandLine commandLine = new CommandLine(new SupportBank());
    System.out.println(Arrays.toString(args));
    int exitCode = commandLine.execute(args);
    System.exit(exitCode);

    System.out.println(Chalk.on("Build your CLI here!").magenta());
  }
}
