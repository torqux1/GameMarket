package com.models;
import java.util.ArrayList;
import java.util.List;


public class User {
    private String username;
    private List<String> items;
    private double currentBill;
    private int image;
	
    public User(String username, int image) {
        this.username = username;
        this.currentBill = 0;
        this.image = image;
		this.items = new ArrayList<>();
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public double getCurrentBill() {
        return currentBill;
    }

    public void setCurrentBill(double currentBill) {
        this.currentBill = currentBill;
    }
}
