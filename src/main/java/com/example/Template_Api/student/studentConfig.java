package com.example.Template_Api.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository)
    {
        return args -> {

            Student mariam = new Student(
                    "Maraim",
                    "mariam.jamal@gmil.com",
                    LocalDate.of(2000, Month.NOVEMBER,5),
                    21
            );

            Student loki = new Student(
                    "Loki",
                    "loki.jamal@gmil.com",
                    LocalDate.of(2004, Month.NOVEMBER,5),
                    21
            );

                repository.saveAll(
                        List.of(mariam, loki)
                );
        };
    }
}
