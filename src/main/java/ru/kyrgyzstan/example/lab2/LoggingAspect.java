package ru.kyrgyzstan.example.lab2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(public boolean Auditing.validate(*,*,*))")
    public void beforeTransferValidate() {
        System.out.println("beforeValidate: попытка проверки учетных даннных до перевода средств");
    }

    //    @Before("execution(public void validate())")
//    public void beforeBankTransferValidate() {
//        System.out.println("beforeBankValidate: попытка проверки учетных даннных до перевода средств");
//    }

    @Before("execution(public void Auditing.transferInstantiate(*,*,*,*,*))")
    public void beforeTransferInstantiate() {
        System.out.println("beforeTransferInstantiate: попытка банка создать экземпляр сервиса перевода средств");
    }

    @Before("execution(public void Auditing.success(*))")
    public void beforeSuccess() {
        System.out.println("beforeSuccess: банк успешно выполнил перевод средств");
    }

    @Before("execution(public void Auditing.rollback(*))")
    public void beforeRollback() {
        System.out.println("beforeRollback: банк отказал в операции перевода средств");
    }

}
