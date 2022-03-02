package ru.kyrgyzstan.example.lab2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    private static Object OptimaBank;

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Auditing auditing = context.getBean("Auditing", Auditing.class);
        Bank optimaBank = context.getBean("TinkoffBank", Tinkoff.class);
        Bank demirBank = context.getBean("BTABank", BTA.class);
        optimaBank.createClient("Jake", 100);
        demirBank.createClient("Sam", 0);

        optimaBank.sout();
        demirBank.sout();

        System.out.println();
        auditing.Transfer(optimaBank, 0, demirBank, 0, 100);
        optimaBank.sout();
        demirBank.sout();

        System.out.println();
        auditing.Transfer(optimaBank, 0, demirBank, 0, 100);
        optimaBank.sout();
        demirBank.sout();

        context.close();
    }
}