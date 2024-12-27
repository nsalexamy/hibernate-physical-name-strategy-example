package com.alexamy.example.hibernate.naming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(
        exclude = {
                HibernateJpaAutoConfiguration.class
        }
)
public class HibernatePhysicalNameStrategyExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernatePhysicalNameStrategyExampleApplication.class, args);
    }

}
