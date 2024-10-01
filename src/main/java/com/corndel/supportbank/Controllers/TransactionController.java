package com.corndel.supportbank.Controllers;


import com.corndel.supportbank.Services.ListService;
import com.corndel.supportbank.Services.TransactionService;
import picocli.CommandLine.Command;

@Command(name = "Transaction", subcommands = {TransactionService.class, ListService.class})
public class TransactionController
{

}
