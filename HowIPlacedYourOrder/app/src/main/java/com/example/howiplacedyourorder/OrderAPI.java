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

    public static String orderType;

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

        String data = "{ \"fulfillment\": { \"address\": { \"type\": \"Other\", \"typeLabel\": \"String\", \"line1\": \"String\", \"line2\": \"String\", \"city\": \"String\", \"state\": \"String\", \"country\": \"String\", \"postalCode\": \"String\", \"coordinates\": { \"latitude\": 33.6817952, \"longitude\": -84.4239568 }, \"crossStreets\": [ { \"name\": \"Peachtree St\", \"lineId\": \"String\" } ], \"notes\": \"String\", \"businessInfo\": { \"name\": \"String\", \"department\": \"String\" } }, \"leadTimes\": [ { \"type\": \"Other\", \"typeLabel\": \"String\", \"interval\": 44, \"intervalUnits\": \"Minutes\", \"lineId\": \"String\" } ], \"notes\": \"String\", \"pickupDate\": \"2017-07-06T21:03:46.514Z\", \"pickupLocation\": \"String\", \"fulfillmentTime\": \"2018-01-31T12:34:56.789Z\", \"type\": \"Pickup\", \"typeLabel\": \"String\", \"autoRelease\": null, \"catering\": null }, \"expireAt\": \"2017-07-06T21:03:46.514Z\", \"fees\": [ { \"type\": \"Web\", \"typeLabel\": \"String\", \"provider\": \"String\", \"amount\": 98.35, \"override\": null, \"lineId\": \"String\", \"groupMemberId\": \"String\" } ], \"orderLines\": [ { \"comments\": \"String\", \"description\": \"String\", \"extendedAmount\": 92.9, \"itemType\": \"String\", \"notes\": [ { \"type\": \"Substitutions\", \"typeLabel\": \"String\", \"value\": \"String\", \"lineId\": \"String\" } ], \"parentLineId\": \"String\", \"priceModifiers\": [ { \"amount\": 13.05, \"description\": \"String\", \"referenceId\": \"String\", \"lineId\": \"String\" } ], \"productId\": { \"type\": \"String\", \"value\": \"String\" }, \"quantity\": { \"unitOfMeasure\": \"EA\", \"unitOfMeasureLabel\": \"String\", \"value\": 43.3 }, \"substitutionAllowed\": null, \"taxes\": [ { \"amount\": 77.25, \"code\": \"String\", \"isIncluded\": null, \"percentage\": 23.2, \"lineId\": \"String\" } ], \"unitPrice\": 75.95, \"scanData\": \"String\", \"supplementalData\": \"String\", \"modifierCode\": \"String\", \"linkGroupCode\": \"String\", \"lineReplaced\": \"String\", \"fulfillmentResult\": \"Replaced\", \"overridePrice\": null, \"lineId\": \"String\", \"groupMemberId\": \"String\" } ], \"taxes\": [ { \"amount\": 33.55, \"code\": \"String\", \"description\": \"String\", \"isIncluded\": null, \"percentage\": 1.5, \"source\": \"String\", \"active\": null, \"lineId\": \"String\", \"groupMemberId\": \"String\" } ], \"promotions\": [ { \"referenceId\": \"String\", \"supportingData\": \"String\", \"amount\": 90.4, \"numGuests\": 34, \"orderLineGroups\": [ { \"name\": \"String\", \"orderLineIds\": [ \"String\" ], \"lineId\": \"String\" } ], \"adjustment\": { \"level\": \"ITEM\", \"type\": \"PROMO\", \"applied\": null }, \"lineId\": \"String\" } ], \"additionalReferenceIds\": {}, \"taxExempt\": null, \"taxExemptId\": \"String\", \"totalModifiers\": [ { \"amount\": 85.2, \"description\": \"String\", \"referenceId\": \"String\", \"lineId\": \"String\", \"groupMemberId\": \"String\" } ], \"partySize\": 65, \"pickupContact\": { \"name\": \"String\", \"company\": \"String\", \"imageLink\": \"String\", \"phone\": \"String\", \"hasArrived\": null, \"vehicle\": { \"make\": \"Porsche\", \"model\": \"911 Turbo\", \"year\": \"2017\", \"color\": \"Silver\", \"licensePlate\": \"ABC1234\" } }, \"checkInDetails\": { \"location\": \"Store Front\", \"application\": \"POS\", \"origin\": { \"type\": \"mobile or web\", \"id\": 18 }, \"vector\": { \"type\": \"printer, queue, terminal, display or kiosk\", \"id\": 8 } }, \"dateInTransit\": \"2017-07-06T21:03:46.514Z\", \"dateFulfilled\": \"2017-07-06T21:03:46.514Z\", \"dateClosed\": \"2017-07-06T21:03:46.514Z\", \"comments\": \"String\", \"channel\": \"Web\", \"currency\": \"String\", \"customer\": { \"id\": \"String\", \"externalIds\": [ { \"type\": \"Other\", \"typeLabel\": \"String\", \"value\": \"String\", \"lineId\": \"String\" } ], \"name\": \"String\", \"firstName\": \"String\", \"lastName\": \"String\", \"phone\": \"String\", \"phoneExtension\": \"String\", \"email\": \"String\" }, \"groupMembers\": [ { \"name\": \"String\", \"firstName\": \"String\", \"lastName\": \"String\", \"externalIds\": {}, \"lineId\": \"String\" } ], \"errorDescription\": \"String\", \"owner\": \"String\", \"referenceId\": \"String\", \"source\": \"String\", \"status\": \"OrderPlaced\", \"totals\": [ { \"type\": \"Net\", \"value\": 75.6, \"lineId\": \"String\", \"groupMemberId\": \"String\" } ] }";
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
