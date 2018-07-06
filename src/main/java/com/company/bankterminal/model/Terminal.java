package com.company.bankterminal.model;

import com.company.bankterminal.model.accounts.Account;
import com.company.bankterminal.model.accounts.Credit;
import com.company.bankterminal.model.accounts.Current;
import com.company.bankterminal.model.accounts.Debit;

import java.util.Scanner;

public class Terminal {


    public void workCycle() {
        Client[] clients = new Client[3];
        clients[0] = new Client("Steve");
        clients[1] = new Client("Rojer");
        clients[2] = new Client("Francine");

        Account[] accounts = new Account[8];
        accounts[0] = new Debit(200000, clients[0],"debitacc001", (short)4);
        accounts[1] = new Credit(20000, clients[0],"creditacc001", 90000);

        accounts[2] = new Current(30000, clients[1],"currentacc001");
        accounts[3] = new Current(50000, clients[1],"currentacc002");
        System.out.println("Добрый день. Вас приветствует Банкомат.");

        listClients(clients, accounts);
        Client selectedClient = selectClient(clients);

        listClientAccounts(selectedClient, clients, accounts);
        Account selectedAccount = selectAccount(accounts);

        int action = listActions();

        switch (action) {
            case 1: vnestiSummu(selectedAccount); break;
            case 2: snyatSummu(selectedAccount); break;
        }


    }

    private void snyatSummu(Account selectedAccount) {
        System.out.println("Введите сумму для снятия:");

        float sum = enterFloat();

        if (sum > 0) {
            selectedAccount.TakeSum(sum);
            System.out.println("Сумма на выбранном аккаунте:  " + selectedAccount.getBalance());
        } else {
            System.out.println("Введена неверная сумма");
        }
    }

    private float enterFloat() {


        Scanner sc = new Scanner(System.in);
        String sumStr = sc.next();

        float result = -999;

        try {
            result = Float.parseFloat(sumStr);

        } catch ( NumberFormatException e) {
            System.out.println("Введена неверная сумма");

        }

        return result;
    }

    private void vnestiSummu(Account selectedAccount) {
        System.out.println("Введите вносимую сумму:");

        float sum = enterFloat();

        if (sum > 0) {
            selectedAccount.AddSum(sum);
            System.out.println("Сумма на выбранном аккаунте:  " + selectedAccount.getBalance());
        } else {
            System.out.println("Введена неверная сумма");
        }


    }

    private int listActions() {
        int result = 0;
        System.out.println("Выберите действие:");
        System.out.println("1 - пополнение счета");
        System.out.println("2 - снятие средств со счета");

        Scanner sc = new Scanner(System.in);
        String optionStr = sc.next();
        System.out.println("Вы ввели " + optionStr);

        Integer option = Integer.parseInt(optionStr);

        switch (option) {
           case 1 : System.out.println("Вы выбрали пополнение счета"); result = 1; break;
           case 2 : System.out.println("Вы выбрали снятие средств со счета"); result=2; break;

           default : System.out.println("Invalid choose");
           break;

        }

        return result;
    }

    private Account selectAccount(Account[] accounts) {
        Account result = null;

        Scanner sc = new Scanner(System.in);
        String accountNumber = sc.next();
        System.out.println("Вы ввели " + accountNumber);

        for (Account acc:accounts) {
            if ((acc != null)&&(acc.getAccountNumber().equals(accountNumber))) {
                System.out.println(acc.getAccountNumber());
                result = acc;
            }
        }
        return result;
    }

    private void listClientAccounts(Client selectedClient, Client[] clients, Account[] accounts) {
        if (selectedClient != null) {
            System.out.println("Выберите аккаунт");
            for (Account acc: accounts) {
                if ((acc != null)&&(selectedClient.getName().equals(acc.getOwnerName().getName()))) {
                    System.out.println(acc.getAccountNumber());
                }
            }

        } else {
            System.out.println("Клиент не выбран");
        }

    }

    private Client selectClient(Client[] clients) {
        Client result = null;

        Scanner sc = new Scanner(System.in);
        String clientName = sc.next();
        System.out.println("Вы ввели " + clientName);

        for (Client clnt:clients) {
            if ((clnt != null)&&(clnt.getName().equals(clientName))) {
                System.out.println(clnt.getName());
                result = clnt;
            }
        }
        return result;
    }

    public void listClients(Client[] clients, Account[] accounts) {
        System.out.println("Выберите клиента");

        for (Client clnt:clients) {
            if (clnt != null) {
                System.out.println(clnt.getName());
            }
        }
    }



}
