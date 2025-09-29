/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csii.finance_calc;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author alvin
 */
public class AIWrapper {
    private static final String API_KEY = System.getenv("GEMINI_API_KEY"); // You get this from Google
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent"; // Where we ask the AI

    public static String askQuestion(String question) throws IOException, InterruptedException {
        //creating ai api
        String requestBody = "{\"contents\":[{\"role\":\"user\",\"parts\":[{\"text\":\"" + question + "\"}]}]}";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL + "?key=" + API_KEY)).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        //if response code is 200 is not ok
        if (response.statusCode() != 200) {
            return "Error: " + response.statusCode() + " - " + response.body();
        }
        String responseBody = response.body();
        JSONObject jsonResponse = new JSONObject(responseBody);
        JSONArray Response = jsonResponse.getJSONArray("candidates");
        //if returns something
        if (Response.length() > 0) {
            try {
                return Response.getJSONObject(0).getJSONObject("content").getJSONArray("parts").getJSONObject(0).getString("text");
            } catch (Exception e) {
                return "Error parsing response";
            }
        }
        return "No answer found";
    }
}

