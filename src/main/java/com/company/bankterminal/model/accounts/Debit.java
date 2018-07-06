package com.company.bankterminal.model.accounts;

import com.company.bankterminal.model.Client;

public class Debit extends Account {
    protected short procents;

    public Debit(float balance, Client ownerName, String accountNumber, short procents) {
        super(balance, ownerName, accountNumber);
        this.procents = procents;
    }

    public Debit(float balance, String accountNumber, short procents) {
        super(balance, accountNumber);
        this.procents = procents;
    }

    public short getProcents() {
        return procents;
    }

    public void setProcents(short procents) {
        this.procents = procents;
    }




}
