package com.company.bankterminal.model.accounts;

import com.company.bankterminal.model.Client;

public abstract class Account implements IAccountAddSum {
    private float balance;

    public Client getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(Client ownerName) {
        this.ownerName = ownerName;
    }

    private Client ownerName;

    public Account(float balance, Client ownerName, String accountNumber) {
        this.balance = balance;
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
    }

    public Account(float balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.ownerName = null;
    }

    private String accountNumber;

    public float getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void AddSum(float sum) {
        if (sum >0) {
            this.balance = this.balance + sum;
        }

    };

    @Override
    public void TakeSum(float sum) {
        if ((sum>0)&&(sum<30001)) {

            if (sum<=this.balance) {
                this.balance = this.balance - sum;
            } else  {
                System.out.println("Недостаточно средств на счету");
            }

        } else {
            System.out.println("Введена неверная сумма");
        }
    };
}
