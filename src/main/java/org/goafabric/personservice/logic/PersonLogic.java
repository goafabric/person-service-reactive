package org.goafabric.personservice.logic;

import org.goafabric.personservice.service.dto.Person;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Component
public class PersonLogic {
    public Mono<Person> getById(String id) {
        return Mono.just(
                createPerson());
    }

    public Flux<Person> findAll() {
        return Flux.fromIterable(
                Arrays.asList(
                    createPerson(), createPerson(), createPerson()));
    }

    public Mono<Person> findByIsoCode(String firstName) {
        return Mono.just(
                createPerson());
    }


    public Mono<Person> save(Person person) {
        return Mono.just(
                createPerson());
    }

    private Person createPerson() {
        return Person.builder()
                .firstName("john")
                .lastName("doe " + System.currentTimeMillis())
                .build();
    }
}
