package ru.kyrgyzstan.example.lab2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;

@Configuration
@ComponentScan("ru.kyrgyzstan.example.lesson2")
@EnableAspectJAutoProxy
public class MyConfig {
    @Bean
    public Auditing Auditing() {
        return new Auditing();
    }

    @Bean
    public Tinkoff OptimaBank() {
        return new Tinkoff("OptimaBank", new ArrayList<Client>());
    }

    @Bean
    public BTA DemirBank() {
        return new BTA("DemirBank", new ArrayList<Client>());
    }

    @Bean
    public Transfer Transfer() {
        return new Transfer();
    }
}
