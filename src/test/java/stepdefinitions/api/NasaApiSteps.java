package stepdefinitions.api;

import hooks.api.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigReader;

public class NasaApiSteps {
    @Then("{string}, {string} query parametreleri set eder")
    public void query_parametreleri_set_eder(String baslangic, String bitis) {
        HooksAPI.
                spec.
                queryParams("start_date", ConfigReader.getProperty(baslangic),
                        "end_date", ConfigReader.getProperty(bitis));
    }

    @Then("{string},{string},{string} query parametreleri set eder")
    public void queryParametreleriSetEder(String apiKey, String start, String end) {
        HooksAPI.spec.queryParams("api_key",ConfigReader.getProperty(apiKey),
                "start_date",ConfigReader.getProperty(start),
                "end_date",ConfigReader.getProperty(end));
    }
}
