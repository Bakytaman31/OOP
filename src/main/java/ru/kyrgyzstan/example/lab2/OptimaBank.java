package ru.kyrgyzstan.example.lab2;

import java.util.ArrayList;

public class OptimaBank extends Bank {
    public OptimaBank(String name, ArrayList<Client> clients) {
        super(name, clients);
    }

    @Override
    public boolean validate(int clientIdFrom) {
        System.out.println("OptimaBank: проверяею ваши учетные данные до перевода средств ");
        if (foundClient(clientIdFrom)) {
            System.out.println("OptimaBank: проверка успешно пройдена");
            return true;
        }
        System.out.println("OptimaBank: недействительный пользователь!");
        return false;
    }

    @Override
    public boolean transferInstantiate(Bank bankFrom, int clientIdFrom, Bank bankTo, int clientIdTo, double cost) {
        return super.transferInstantiate(bankFrom, clientIdFrom, bankTo, clientIdTo, cost);
    }

    @Override
    public void success() {
        System.out.println("OptimaBank: транзакция прошла успешно");

    }

    @Override
    public void rollback() {
        System.out.println("OptimaBank: ошибка! транзакция не выполнена");
    }

    @Override
    public void withdraw(int id, double cost) {
        super.withdraw(id, cost);
    }

    @Override
    public boolean withdrawBoll(int id, double cost) {
        return super.withdrawBoll(id, cost);
    }

    @Override
    public void put(int id, double cost) {
        super.put(id, cost);
    }

    @Override
    public boolean putBoll(int id) {
        return super.putBoll(id);
    }

    @Override
    public boolean foundClient(int id) {
        return super.foundClient(id);
    }

    @Override
    public void createClient(String name, double balance) {
        super.createClient(name, balance);
    }

    public void sout(){
        System.out.println("OptimaBank:");
        for (Client i : this.clients) {
            System.out.printf(
                    "   Id: %d    Name: %30s   Balance: %.2f%n",
                    i.getId(), i.getName(), i.getBalance()
            );
        }
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public ArrayList<Client> getClients() {
        return super.getClients();
    }

    @Override
    public void setClients(ArrayList<Client> clients) {
        super.setClients(clients);
    }
}