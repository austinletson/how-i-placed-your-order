package com.example.howiplacedyourorder;
import java.net.*;
import java.sql.Time;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.io.DataOutputStream;

class Order {

    Orders order;

    public Order(Orders orderType, Time timeStart, Time timeEnd){
        Date current = new Date();
        if (timeEnd.after(current) && timeStart.before(current)) {
            // start tracking
            return;
        } else {
            // trigger timer to start tracking
            return;
        }
    }

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

    public enum Orders {

        ONE ("test1", 1),
        TWO ("test2", 2),
        THREE ("test3", 3);

        private final String orderName;
        private final int orderId;

        Orders(String name, int id) {
            orderName = name;
            orderId = id;
        }

        public String getOrderName() {
            return orderName;
        }

        public int getOrderId() {
            return orderId;
        }

        @Override
        public String toString() {
            return orderName;
        }
    }

}