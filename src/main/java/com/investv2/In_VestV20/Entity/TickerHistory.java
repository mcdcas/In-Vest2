package com.investv2.In_VestV20.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock_history")
public class TickerHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @JsonProperty("t")
    @Temporal(TemporalType.TIMESTAMP) // Specify that this is a timestamp
    private Date date; // Changed to java.util.Date

    @JsonProperty("o")
    private double open_price;

    @JsonProperty("c")
    private double close_price;

    @JsonProperty("h")
    private double high_price;

    @JsonProperty("l")
    private double low_price;

    @JsonProperty("v")
    private int volume;

    @JsonProperty("vw")
    private double volume_weighted_average;

    @JsonProperty("n")
    private int window_transactions;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // New method to return the epoch time
    public long getEpochDate() {
        return date.getTime(); // Return epoch time in milliseconds
    }

    public double getOpen_price() {
        return open_price;
    }

    public void setOpen_price(double open_price) {
        this.open_price = open_price;
    }

    public double getClose_price() {
        return close_price;
    }

    public void setClose_price(double close_price) {
        this.close_price = close_price;
    }

    public double getHigh_price() {
        return high_price;
    }

    public void setHigh_price(double high_price) {
        this.high_price = high_price;
    }

    public double getLow_price() {
        return low_price;
    }

    public void setLow_price(double low_price) {
        this.low_price = low_price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getVolume_weighted_average() {
        return volume_weighted_average;
    }

    public void setVolume_weighted_average(double volume_weighted_average) {
        this.volume_weighted_average = volume_weighted_average;
    }

    public int getWindow_transactions() {
        return window_transactions;
    }

    public void setWindow_transactions(int window_transactions) {
        this.window_transactions = window_transactions;
    }
}
