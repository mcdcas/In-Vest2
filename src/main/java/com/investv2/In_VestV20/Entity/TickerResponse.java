package com.investv2.In_VestV20.Entity;

import java.util.ArrayList;
import java.util.List;

public class TickerResponse {

    private String ticker;
    private int queryCount;
    private int resultsCount;
    private boolean adjusted; // Add this field for adjusted
    private List<TickerHistory> results = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private String status;
    private String request_id;
    private int count;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getQueryCount() {
        return queryCount;
    }

    public void setQueryCount(int queryCount) {
        this.queryCount = queryCount;
    }

    public int getResultsCount() {
        return resultsCount;
    }

    public void setResultsCount(int resultsCount) {
        this.resultsCount = resultsCount;
    }

    public boolean isAdjusted() { // Add this getter
        return adjusted;
    }

    public void setAdjusted(boolean adjusted) { // Add this setter
        this.adjusted = adjusted;
    }

    public List<TickerHistory> getResults() {
        return results;
    }

    public void setResults(List<TickerHistory> results) {
        this.results = results;
    }
}
