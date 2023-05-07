package stepdefinitions.api;

import hooks.api.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class TrelloApiSteps {

    public static String fullPath;
   // public static Pojo_RegisterCustomer reqBody;
    @Given("Api kullanicisi {string} path parametreleri set eder")
    public void api_kullanicisi_path_parametreleri_set_eder(String rawPaths) {

      //  HooksAPI.spec.pathParams("pp1","1","pp2","boards");

        // api/register
        String[] paths=rawPaths.split("/"); // [ "api","register"]

        StringBuilder tempPath=new StringBuilder("{");

        for (int i = 0; i <paths.length ; i++) {
            String key="pp"+ i; //pp0 pp1 pp2
            String value=paths[i].trim(); //solunda sagında bosluk varsa silmek icibn trim kulandık
            HooksAPI.spec.pathParam(key,value);
            tempPath.append(key +"}/{"); //{pp0}/{pp1}
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        //System.out.println("tempPath = " + tempPath);

        fullPath=tempPath.toString();
        //System.out.println("fullPath = " + fullPath);
    }

    @Given("api kullanicisi {string}, {string}, {string} query parametrelerini set eder")
    public void apiKullanicisiQueryParametreleriniSetEder(String isim, String key, String token) {
        HooksAPI.
                spec.
                queryParams("name", ConfigReader.getProperty(isim),
                        "key", ConfigReader.getProperty(key),
                        "token" , ConfigReader.getProperty(token));
    }

    @Then("api kullanicisi Post request gonderir")
    public void apiKullanicisiPostRequestGonderir() {
        Response response=given().
                            spec(HooksAPI.spec).
                            contentType(ContentType.JSON).
                        when().
                            post(fullPath);

        response.prettyPrint();
    }



    @Then("api kullanicisi Get request gonderir")
    public void apiKullanicisiGetRequestGonderir() {
        Response response=given().
                            spec(HooksAPI.spec).
                        when().
                            get(fullPath);

        response.prettyPrint();

    }

    @Given("{string}, {string} query parametrelerini set eder")
    public void queryParametreleriniSetEder(String key, String token) {
        HooksAPI.
                spec.
                queryParams("key", ConfigReader.getProperty(key), "token" , ConfigReader.getProperty(token));
    }

    @Then("api kullanicisi Put request gonderir")
    public void apiKullanicisiPutRequestGonderir() {
        Response response=given().
                            spec(HooksAPI.spec).
                            contentType(ContentType.JSON).
                            when().put(fullPath);
        response.prettyPrint();
    }

    @Given("{string}, {string} ve {string} query parametrelerini set eder")
    public void veQueryParametreleriniSetEder(String anahtar, String jeton, String ad) {
        HooksAPI.
                spec.
                queryParams("key", ConfigReader.getProperty(anahtar),
                        "token" , ConfigReader.getProperty(jeton),
                        "name",ConfigReader.getProperty(ad));
    }

    @Then("api kullanicisi Delete request gonderir")
    public void apiKullanicisiDeleteRequestGonderir() {
        Response response=given().
                            spec(HooksAPI.spec).
                        when().
                            delete(fullPath);
        response.prettyPrint();
    }

    @Given("{string}, {string} ve {string} query parametreleriyle gunceller eder")
    public void veQueryParametreleriyleGuncellerEder(String anahtar, String jeton, String renk) {
        HooksAPI.
                spec.
                queryParams("key", ConfigReader.getProperty(anahtar),
                        "token" , ConfigReader.getProperty(jeton),
                        "prefs/background",ConfigReader.getProperty(renk));
    }
}
