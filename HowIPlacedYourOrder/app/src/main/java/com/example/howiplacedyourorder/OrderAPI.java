package com.example.howiplacedyourorder;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class OrderAPI extends AsyncTask<String, String, String> {

    public OrderAPI() {
        //set context variables if required
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String urlString = "https://gateway-staging.ncrcloud.com/order/orders";

        String data = "{\"details\":[\"ApplicationKey\",\"null\",\"identifier\"],\"errorType\":\"com.ncr.nep.common.exception.ResourceDoesNotExistException\",\"message\":\"The ApplicationKey resource with the identifier 'null' does not exist.\",\"statusCode\":404}";
        OutputStream out = null;

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Key","Value");
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            urlConnection.setRequestProperty ("Authorization", "Basic YWNjdDpyb290QGhvd19pX3BsYWNlZF95b3VyX29yZGVyOlhCUUp6WnNNaXVOMnFjJDE=");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("nep-application-key", "8a0389b96bff8ba8016c4553d826007d");
            urlConnection.setRequestProperty("nep-enterprise-unit", "7e15b6051a2748109a40444d9dd726da");
            urlConnection.setRequestProperty("nep-organization", "how-i-placed-your-order");
            urlConnection.setRequestProperty("Test id", "Walking into Cheetah");
            //urlConnection.setRequestProperty("Content-Length", "" + data.getBytes().length);

            out = new BufferedOutputStream(urlConnection.getOutputStream());

            out.write(data.getBytes());
            out.flush();
            out.close();



            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            String respose = convertStreamToString(in);
            urlConnection.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "";
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
