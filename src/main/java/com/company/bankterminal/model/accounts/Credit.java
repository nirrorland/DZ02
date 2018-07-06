package com.company.bankterminal.model.accounts;

import com.company.bankterminal.model.Client;

public class Credit extends Account{
    protected float creditLimit;

    public Credit(float balance, Client ownerName, String accountNumber, float creditLimit) {
        super(balance, ownerName, accountNumber);
        this.creditLimit = creditLimit;
    }

    public Credit(float balance, String accountNumber, float creditLimit) {
        super(balance, accountNumber);
        this.creditLimit = creditLimit;
    }

    public float getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(float creditLimit) {
        this.creditLimit = creditLimit;
    }





    @Override
    public float getBalance() {
        return super.getBalance();
    }


}
