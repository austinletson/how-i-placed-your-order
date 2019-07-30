package com.example.howiplacedyourorder;

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