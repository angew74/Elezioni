package com.deltasi.elezioni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories("com.deltasi.elezioni.repository")
@EnableConfigurationProperties
@EnableTransactionManagement
@EntityScan(basePackages = {"com.deltasi.elezioni.model"})  // scan JPA entities
@ComponentScan(basePackages = {"com.deltasi.elezioni.service","com.deltasi.elezioni.model.json", "com.deltasi.elezioni.controllers", "com.deltasi.elezioni.repository","com.deltasi.elezioni.contracts",
"com.deltasi.elezioni"})
public class ElezioniApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElezioniApplication.class, args);
    }

}
