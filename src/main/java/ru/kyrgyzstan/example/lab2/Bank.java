package ru.kyrgyzstan.example.lab2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public abstract class Bank {
    String name;
    ArrayList<Client> clients;

    public Bank(String name, ArrayList<Client> clients) {
        this.name = name;
        this.clients = clients;
    }

    public boolean validate(int clientIdFrom) {
        System.out.println("Банк: проверяею ваши учетные данные до перевода средств");
        if (foundClient(clientIdFrom)) {
            System.out.println("Банк: проверка успешно пройдена");
            return true;
        }
        System.out.println("Банк: недействительный(-ые) пользователь(-и)");
        return false;
    }

    public boolean transferInstantiate(Bank bankFrom, int clientIdFrom, Bank bankTo, int clientIdTo, double cost) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Transfer transfer = context.getBean("Transfer", Transfer.class);
        return transfer.transfer(bankFrom, clientIdFrom, bankTo, clientIdTo, cost);
    }

    public void success() {
        System.out.println("Банк: транзакция прошла успешно");
    }

    public void rollback() {
        System.out.println("Банк: ошибка! транзакция не выполнена");
    }

    public void sout() {
        System.out.println("Банк:");
        for (Client i : this.clients) {
            System.out.printf(
                    "   Id: %d    Name: %30s   Balance: %.2f%n",
                    i.getId(), i.getName(), i.getBalance()
            );
        }
    }

    public void withdraw(int id, double cost) {
        clients.get(id).setBalance(
                clients.get(id).getBalance() - cost
        );
    }

    public boolean withdrawBoll(int id, double cost) {
        if (foundClient(id)) {
            if (clients.get(id).getBalance() >= cost) {
                return true;
            }
        }
        return false;

    }

    public void put(int id, double cost) {
        clients.get(id).setBalance(
                clients.get(id).getBalance() + cost
        );
    }

    public boolean putBoll(int id) {
        return foundClient(id);
    }

    public boolean foundClient(int id) {
        if (clients.get(id) != null) return true;
        return false;
    }

    public void createClient(String name, double balance) {
        if (clients != null) {
            clients.add(new Client(
                    clients.size(), name, balance
            ));
        } else {
            clients.add(new Client(
                    0, name, balance
            ));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
}
