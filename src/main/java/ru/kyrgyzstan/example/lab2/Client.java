package ru.kyrgyzstan.example.lab2;

public class Client {
    Integer id;
    String name;
    double balance;

    public Client(Integer id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void sout(){
        System.out.printf(
                "Id: %d    Name: %30s   Balance: %.2f%n",
                getId(), getName(), getBalance()
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
