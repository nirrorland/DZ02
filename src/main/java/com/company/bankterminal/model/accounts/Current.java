package com.company.bankterminal.model.accounts;

import com.company.bankterminal.model.Client;

public class Current extends Account {


    public Current(float balance, Client ownerName, String accountNumber) {
        super(balance, ownerName, accountNumber);
    }

    public Current(float balance, String accountNumber) {
        super(balance, accountNumber);
    }


    @Override
    public void AddSum(float sum) {
        super.AddSum(sum);
        if (sum>1000000) {
            this.getOwnerName();
        }
    }
}
