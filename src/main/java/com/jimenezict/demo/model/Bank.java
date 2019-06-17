package com.jimenezict.demo.model;

import java.util.HashMap;
import java.util.Map;

class Bank {

    private Map<String,Account> accounts;
    private ATM atm;

    private static Bank bank;

    public static Bank getInstance(){
        if(bank == null){
            bank = new Bank();
        }
        return bank;
    }

    private Bank() {
        this.accounts = createTestAccounts();
        this.atm = initializeATM();
    }

    private static ATM initializeATM() {
        ATM atm = new ATM();
        atm.setNotes_5(0);
        atm.setNotes_10(0);
        atm.setNotes_20(0);
        atm.setNotes_50(0);
        return atm;
    }

    private static Map<String, Account> createTestAccounts() {
        Map<String,Account> accounts = new HashMap<String,Account>();
        accounts.put("01001",new Account("01001",new Double(2738.59)));
        accounts.put("01002",new Account("01002",new Double(23.00)));
        accounts.put("01003",new Account("01003",new Double(0.00)));
        return accounts;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }
}
