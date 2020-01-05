package org.goafabric;

import org.goafabric.personservice.logic.PersonLogic;
import org.goafabric.personservice.service.dto.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by amautsch on 26.06.2015.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner loadData(
            PersonLogic personLogic) {
        return (args) -> {
            personLogic.save(Person.builder()
                    .firstName("Homer").lastName("Simpson")
                    .build()).block();

            personLogic.save(Person.builder()
                    .firstName("Bart").lastName("Simpson")
                    .build()).block();

            personLogic.save(Person.builder()
                    .firstName("Monty").lastName("Burns")
                    .build()).block();
        };

    }
}
