package ru.kyrgyzstan.example.lab2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    private static Object OptimaBank;

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Auditing auditing = context.getBean("Auditing", Auditing.class);
        Bank optimaBank = context.getBean("OptimaBank", OptimaBank.class);
        Bank demirBank = context.getBean("DemirBank", DemirBank.class);
        optimaBank.createClient("Artur", 100);
        demirBank.createClient("Nurislam", 0);

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