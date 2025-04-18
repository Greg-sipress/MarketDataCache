package org.example.matchingengine.model;


import jdk.jfr.DataAmount;
import lombok.Data;

import java.math.BigDecimal;
//import java.time.LocalDateTime;
import java.util.Objects;

@Data

public class MarketData {

    private String symbol;        // e.g., Stock symbol like "AAPL"
    private double price;         // Current price of the asset
    private double bidPrice;      // Current bid price
    private double askPrice;      // Current ask price
    private long volume;              // Traded volume
    private long timestamp;  // Timestamp of the data

    public MarketData() {

    }
    // Constructor
    public MarketData(String instrument, double price, double bidPrice,
                      double askPrice, long volume, long timestamp) {
        this.symbol = instrument;
        this.price = price;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.volume = volume;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    // Override equals, hashCode, and toString for usability
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketData that = (MarketData) o;
        return volume == that.volume &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(price, that.price) &&
                Objects.equals(bidPrice, that.bidPrice) &&
                Objects.equals(askPrice, that.askPrice) &&
                Objects.equals(timestamp, that.timestamp);
    }


    public String toJson() {
        return String.format(
                "{\"symbol\":\"%s\",\"price\":%.2f,\"bidPrice\":%.2f,\"askPrice\":%.2f,\"volume\":%d,\"timestamp\":\"%s\"}",
                symbol, price, bidPrice, askPrice, volume, timestamp
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, price, bidPrice, askPrice, volume, timestamp);
    }

    @Override
    public String toString() {
        return toJson();
    }
}

