package com.example.fleshcardservice;

import com.example.fleshcardservice.repositories.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class FleshCardServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FleshCardServiceApplication.class, args);
    }

}
