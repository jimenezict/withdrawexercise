package com.jimenezict.demo.model;

class Account {

    private String number;
    private Double balance;

    public Account(String number, Double balance){
        this.number = number;
        this.balance = balance;
    }

    String getNumber() {
        return number;
    }

    Double getBalance() {
        return balance;
    }

    void setBalance(Double balance) {
        this.balance = balance;
    }
}
