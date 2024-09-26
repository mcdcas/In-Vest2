package com.investv2.In_VestV20.Entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stocks") // Ensure this table name matches your database schema
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ticker", unique = true, nullable = false)
    private String ticker;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "sector")
    private String sector;

    @Column(name = "industry")
    private String industry;

    @Column(name = "exchange")
    private String exchange;

    // You can add other fields related to the stock here

    // If the Stock has a one-to-many relationship with another entity (e.g., TickerHistory)
    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TickerHistory> tickerHistories = new HashSet<>();

    // Constructors
    public Stock() {
    }

    public Stock(String ticker, String companyName, String sector, String industry, String exchange) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.sector = sector;
        this.industry = industry;
        this.exchange = exchange;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Set<TickerHistory> getTickerHistories() {
        return tickerHistories;
    }

    public void setTickerHistories(Set<TickerHistory> tickerHistories) {
        this.tickerHistories = tickerHistories;
    }

    // Utility methods to manage bidirectional relationship with TickerHistory
    public void addTickerHistory(TickerHistory tickerHistory) {
        tickerHistories.add(tickerHistory);
        tickerHistory.setStock(this);
    }

    public void removeTickerHistory(TickerHistory tickerHistory) {
        tickerHistories.remove(tickerHistory);
        tickerHistory.setStock(null);
    }

    // toString method (optional, for debugging purposes)
    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", ticker='" + ticker + '\'' +
                ", companyName='" + companyName + '\'' +
                ", sector='" + sector + '\'' +
                ", industry='" + industry + '\'' +
                ", exchange='" + exchange + '\'' +
                '}';
    }
}
