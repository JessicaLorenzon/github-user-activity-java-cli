package service;

import com.google.gson.Gson;
import exception.NotFoundException;
import model.GitHubEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitHubService {

    static String webService = "https://api.github.com/users/";
    static int codeSuccess = 200;

    public static GitHubEvent[] searchActivity(String user) throws Exception {
        String ApiUrl = webService + user + "/events";

        URL url = new URL(ApiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        if (connection.getResponseCode() == 404) {
            throw new NotFoundException();
        }
        if (connection.getResponseCode() != 404 && connection.getResponseCode() != codeSuccess) {
            throw new RuntimeException();
        }

        BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String jsontoString = convertResponseToString(response);

        Gson gson = new Gson();

        return gson.fromJson(jsontoString, GitHubEvent[].class);
    }

    public static String convertResponseToString(BufferedReader buffereReader) throws IOException {
        StringBuilder jsontoString = new StringBuilder();

        String response;

        while ((response = buffereReader.readLine()) != null) {
            jsontoString.append(response);
        }
        return jsontoString.toString();
    }
}
