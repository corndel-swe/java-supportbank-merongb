package com.corndel.supportbank.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.sql.SQLOutput;

@Command(name = "ListCurrencies")
public class ConversionRates implements Runnable{



    @Override
    public void run() {
      String conversionRates =  null;
        try {
            conversionRates = ListCurrencies();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(conversionRates);

    }

    private String ListCurrencies() throws Exception{

        Dotenv dotenv = Dotenv.load();
        String ApiKey = dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");

        String url = String.format("https://openexchangerates.org/api/latest.json?app_id=%s", ApiKey);

        var response = Unirest
                .get(url)
                .header("Accept", "application/json")
                .asString();

        String json = response.getBody();

        ObjectMapper mapper = new ObjectMapper();
        var tree = mapper.readTree(json);

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tree);
    }
}
