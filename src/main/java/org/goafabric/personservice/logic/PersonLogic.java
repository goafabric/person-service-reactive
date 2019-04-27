package org.goafabric.personservice.logic;

import org.goafabric.personservice.service.dto.Person;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Component
public class PersonLogic {
    public Mono<Person> getById(String id) {
        return Mono.just(
                Person.builder().build());
    }

    public Flux<Person> findAll() {
        return Flux.fromIterable(new ArrayList<Person>());
    }

    public Mono<Person> findByIsoCode(String firstName) {
        return Mono.just(
                Person.builder().build());
    }


    public Mono<Person> save(Person person) {
        return Mono.just(
                Person.builder().build());
    }

}
