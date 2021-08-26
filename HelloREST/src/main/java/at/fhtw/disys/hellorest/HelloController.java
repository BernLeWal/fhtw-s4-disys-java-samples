package at.fhtw.disys.hellorest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class HelloController {
    @FXML
    public TextField name;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onURLConnectionClicked() {
        try {
            String urlString = "http://localhost:8080/hello?name=" + URLEncoder.encode(name.getText(), StandardCharsets.UTF_8.toString());
            System.out.println(urlString);

            final URLConnection connection = new URL(urlString).openConnection();
            try (
                    final InputStreamReader isr = new InputStreamReader(connection.getInputStream());
                    final BufferedReader br = new BufferedReader(isr)
            ) {
                welcomeText.setText(br.lines().collect(Collectors.joining()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            welcomeText.setText("ERROR: " + e.getLocalizedMessage());
        }
    }

    public void onHttpClientClicked(ActionEvent actionEvent) {
        try {
            String urlString = "http://localhost:8080/hello?name=" + URLEncoder.encode(name.getText(), StandardCharsets.UTF_8.toString());
            System.out.println(urlString);

            var request = HttpRequest.newBuilder().uri(URI.create(urlString)).GET().build();
            var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Status Code: " + response.statusCode());
            welcomeText.setText(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            welcomeText.setText("ERROR: " + e.getLocalizedMessage());
        }
    }

    public void onHttpClientPostClicked(ActionEvent actionEvent) {
        try {
            // parameters will be transferred within the request body
            HashMap<String, String> params = new HashMap<>();
            params.put("name", name.getText());
            params.put("value", "dummy");
            StringBuilder requestBody = new StringBuilder();
            params.entrySet().forEach((v) -> requestBody.append(v + "\n"));

            var request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/hello"))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();
            System.out.printf("%s\n%s\n", request, params);

            var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Status Code: " + response.statusCode());
            welcomeText.setText(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            welcomeText.setText("ERROR: " + e.getLocalizedMessage());
        }
    }


    public void onWebClientClicked(ActionEvent actionEvent) {
        try {
            WebClient client = WebClient.builder()
                    .baseUrl("http://localhost:8080/hello?name=" + URLEncoder.encode(name.getText(), StandardCharsets.UTF_8.toString()))
                    .build();
            System.out.println(client);
            Mono<String> response = client
                    .get()
                    .retrieve()
                    .bodyToMono(String.class);
            welcomeText.setText(response.block());
        } catch (Exception e) {
            e.printStackTrace();
            welcomeText.setText("ERROR: " + e.getLocalizedMessage());
        }
    }


    public void onWebClientPostClicked(ActionEvent actionEvent) {
        // parameters will be transferred within the request body
        HashMap<String, String> params = new HashMap<>();
        params.put("name", name.getText());
        params.put("value", "dummy");
        StringBuilder requestBody = new StringBuilder();
        params.entrySet().forEach((v) -> requestBody.append(v + "\n"));

        try {
            WebClient client = WebClient.builder()
                    .baseUrl("http://localhost:8080/hello")
                    .build();
            System.out.println(client);
            Mono<String> response = client
                    .post()
                    .body(BodyInserters.fromValue(requestBody.toString()))
                    .retrieve()
                    .bodyToMono(String.class);
            welcomeText.setText(response.block());
        } catch (Exception e) {
            e.printStackTrace();
            welcomeText.setText("ERROR: " + e.getLocalizedMessage());
        }
    }

}