package com.example.poyntassignment;

public class TransationModel {
    private String transactionSummary;
    private String date;
    private String transactionaAmount;


    public TransationModel(String transactionSummary, String date, String transactionaAmount) {
        this.transactionSummary = transactionSummary;
        this.date = date;
        this.transactionaAmount = transactionaAmount;
    }

    public String getTransactionSummary() {
        return transactionSummary;
    }

    public void setTransactionSummary(String transactionSummary) {
        this.transactionSummary = transactionSummary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransactionaAmount() {
        return transactionaAmount;
    }

    public void setTransactionaAmount(String transactionaAmount) {
        this.transactionaAmount = transactionaAmount;
    }
}
