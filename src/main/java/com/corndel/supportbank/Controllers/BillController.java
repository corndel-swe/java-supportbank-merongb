package com.corndel.supportbank.Controllers;

import com.corndel.supportbank.Services.Split;
import picocli.CommandLine.Command;

@Command(name = "bill", subcommands = {Split.class})
public class BillController {

}
