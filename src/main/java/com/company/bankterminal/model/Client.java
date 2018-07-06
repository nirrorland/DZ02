package com.company.bankterminal.model;

import com.company.bankterminal.model.accounts.Account;

public class Client {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
