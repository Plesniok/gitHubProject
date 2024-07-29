package com.dlesniok.githubproject.services.general;

import com.dlesniok.githubproject.models.api.SimpleResponse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RequestSender {

    private static SimpleResponse getSimpleResponse(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        StringBuilder responseData = new StringBuilder();
        Scanner scanner = new Scanner(responseCode == HttpURLConnection.HTTP_OK ? connection.getInputStream(): connection.getErrorStream());
        while (scanner.hasNextLine()) {
            responseData.append(scanner.nextLine());
        }
        scanner.close();
        return new SimpleResponse(responseCode, responseData.toString());
    }

    public static SimpleResponse sendGetRequest(String url) throws IOException {
        URL requestUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
        connection.setRequestMethod("GET");

        return getSimpleResponse(connection);
    }
}

