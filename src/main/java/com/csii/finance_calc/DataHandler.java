/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csii.finance_calc;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

/**
 *
 * @author amin_940155
 * https://api.polygon.io/v3/reference/tickers/AAPL?apiKey=iBgMINna1qWgz6EzYPZir3kS2w2r6iWW //appls data
 * https://files.polygon.io/v3/reference/tickers/?apiKey=iBgMINna1qWgz6EzYPZir3kS2w2r6iWW
 * https://api.polygon.io/v3/reference/dividends?apiKey=pSdGavp70WAz1tUImlcTSuZ59JmSdXH9
 */
public class DataHandler {
    
    public String getJSONString (String apiEndPoint){
        
        
        try{
            
            
            HttpRequest request = HttpRequest.newBuilder().GET().uri(new URI("https://api.polygon.io/v3/reference/dividends?apiKey=" + apiEndPoint)).build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
            
            return response.body();
            
         
            
        } catch(URISyntaxException | InterruptedException | IOException ex){
            System.out.println(ex.toString());
        }
        
        return null;
        
    }
    
     public String processStocks(String ticker) {
        try {
            String apiKey = System.getenv("POLYGON_API_KEY");
            String url = "https://api.polygon.io/v2/aggs/ticker/" + ticker.toUpperCase() + "/prev?adjusted=true&apiKey=" + apiKey;

            HttpRequest request = HttpRequest.newBuilder().GET().uri(new URI(url)).build();

            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            
            JSONObject json = new JSONObject(response.body());
            if (json.has("results")) {
                JSONArray results = json.getJSONArray("results");

                
                if (results.length() > 0) {
                    JSONObject result = results.getJSONObject(0);
                    double closingPrice = result.getDouble("c"); 
                    return String.valueOf(closingPrice);
                } else {
                    return "No data available for this ticker"; 
                }
            } else {
                return "API response does not contain 'results' field";
            }

        }catch(URISyntaxException | InterruptedException | IOException ex){
            System.out.println(ex.toString());
        }
        return null;
     }
}
