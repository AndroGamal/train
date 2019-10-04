package com.example.andro.train;

/**
 * Created by Andro on 9/16/2019.
 */

public class java_train_journey {
    private double price;
    private int id;
    private String from;
    private String to;
    private boolean select=false;

    public String getDecuman() {
        return decuman;
    }

    public void setDecuman(String decuman) {
        this.decuman = decuman;
    }

    private String decuman;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
