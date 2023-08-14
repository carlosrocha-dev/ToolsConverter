package br.com.carlosrocha.utils;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class APIUtils {

    private static final String API_ENDPOINT = "http://ficticious-currency-api.com/rate";

    public static double getConversionRate(String fromCurrency, String toCurrency) throws Exception {
        URL url = new URL(API_ENDPOINT + "?from=" + fromCurrency + "&to=" + toCurrency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        return jsonResponse.getDouble("rate");
    }
}
