package ru.kyrgyzstan.example.lab2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(public boolean Auditing.validate(*,*,*))")
    public void beforeTransferValidate() {
        System.out.println("beforeValidate: trying to check you data before transfer");
    }


    @Before("execution(public void Auditing.transferInstantiate(*,*,*,*,*))")
    public void beforeTransferInstantiate() {
        System.out.println("beforeTransferInstantiate: trying to create an instance of transfer service");
    }

    @Before("execution(public void Auditing.success(*))")
    public void beforeSuccess() {
        System.out.println("beforeSuccess: bank transferred success");
    }

    @Before("execution(public void Auditing.rollback(*))")
    public void beforeRollback() {
        System.out.println("beforeRollback: bank denied your transfer");
    }

}
