package ru.kyrgyzstan.example.lab2;

public class Transfer {
    public boolean transfer(Bank bankFrom, int clientIdFrom, Bank bankTo, int clientIdTo, double cost) {
        boolean a = bankFrom.withdrawBoll(clientIdFrom, cost);
        boolean b = bankTo.putBoll(clientIdTo);
        if (a && b) {
            bankFrom.withdraw(clientIdFrom, cost);
            bankTo.put(clientIdTo, cost);
            return true;
        }
        return false;
    }
}
