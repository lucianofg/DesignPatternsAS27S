package Proxy;

import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DogFacts implements IDogFacts {

    public final String baseUrl = "https://dog-facts-api.herokuapp.com/api/v1/resources/dogs";

    @Override
    public List<Fact> getAllDogFacts() {
        List<Fact> listOfDogFacts = new ArrayList<>();

        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(URI.create(this.baseUrl + "/all"))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONParser parser = new JSONParser();
            JSONArray obj = (JSONArray) parser.parse(response.body());

            for (int i = 0; i < obj.size(); i++) {
                JSONObject o = (JSONObject) obj.get(i);
                listOfDogFacts.add(new Fact(i, "dog", o.get("fact").toString()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listOfDogFacts;
    }

    @Override
    public Fact getDogFact(int id) {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(this.baseUrl + "?index=" + id))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONParser parser = new JSONParser();
            JSONArray arr = (JSONArray) parser.parse(response.body());
            JSONObject obj = (JSONObject) arr.get(0);
            return new Fact(id, "dog", obj.get("fact").toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Fact(0, null, null);
        }
    }

    @Override
    public Fact getRandomFact() {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(this.baseUrl + "?number=1"))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONParser parser = new JSONParser();
            JSONArray arr = (JSONArray) parser.parse(response.body());
            JSONObject obj = (JSONObject) arr.get(0);
            return new Fact(1, "dog", obj.get("fact").toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Fact(0, null, null);
        }
    }
}
