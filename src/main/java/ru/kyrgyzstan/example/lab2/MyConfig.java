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
    public OptimaBank OptimaBank() {
        return new OptimaBank("OptimaBank", new ArrayList<Client>());
    }

    @Bean
    public DemirBank DemirBank() {
        return new DemirBank("DemirBank", new ArrayList<Client>());
    }

    @Bean
    public Transfer Transfer() {
        return new Transfer();
    }
}
