package com.example.howiplacedyourorder;
import java.net.*;
import java.util.Map;
import java.util.HashMap;
import java.io.DataOutputStream;

class Order {

    Orders order;

    public String placeOrder() {
        try {
            URL url = new URL("gateway-staging.ncrcloud.com/order/orders");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

            Map<String, String> parameters = new HashMap<>();
            parameters.put("param1", "val");

            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            //out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();
        } catch (Exception e) {
            return "Failure";
        }
        return "Success";
    }

    //The following are just a list of functions to implement and may be broken into other classes

    public void checkOrder() {
    }

    public void trackLocation() {
    }

    public void cancelOrder() {
    }

    public void changeOrder() {
    }

    public void timeTrigger() {
    }

    public void timeFrameTrigger() {}

}