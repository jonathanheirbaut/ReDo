package com.realdolmen.travel.domain;

public class Account {
    private String bank;
    private String account;
    private String checksum;

    public Account(String bank, String account, String checksum) {
        this.bank = bank;
        this.account = account;
        this.checksum = checksum;
    }

    public String getBank() {
        return bank;
    }

    public String getAccount() {
        return account;
    }

    public String getChecksum() {
        return checksum;
    }

    public boolean isValid() {
        return false;
    }
}
