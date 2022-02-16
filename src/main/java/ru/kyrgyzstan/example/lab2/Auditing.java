package ru.kyrgyzstan.example.lab2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Auditing {

    // До перевода средств
    public boolean validate(Bank bank, int clientIdFrom, int clientIdTo) {
        System.out.println("Auditing: банк проверяет ваши учетные данные до перевода средств");
        return bank.validate(clientIdFrom);
    }

    // До перевода средств
    public boolean transferInstantiate(Bank bankFrom, int clientIdFrom, Bank bankTo, int clientIdTo, double cost) {
        System.out.println("Auditing: банк создает экземпляр сервиса перевода средств");
        return bankFrom.transferInstantiate(bankFrom, clientIdFrom, bankTo, clientIdTo, cost);
    }

    // После перевода средств
    public void success(Bank bank) {
        System.out.println("Auditing: банк успешно выполнил перевод средств");
        bank.success();
    }

    // После неудачного перевода средств
    public void rollback(Bank bank) {
        System.out.println("Auditing: банк отказал в операции перевода средств");
    }

    public void Transfer(Bank bankFrom, int clientIdFrom, Bank bankTo, int clientIdTo, double cost) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Auditing audit = context.getBean("Auditing", Auditing.class);

        boolean status;
        status = audit.validate(bankFrom, clientIdFrom, clientIdTo);
        if (status) {
            if (audit.transferInstantiate(bankFrom, clientIdFrom, bankTo, clientIdTo, cost)) {
                audit.success(bankFrom);
            } else {
                audit.rollback(bankFrom);
            }
        }
    }
}