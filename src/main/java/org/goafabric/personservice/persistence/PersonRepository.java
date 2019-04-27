package org.goafabric.personservice.persistence;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Component
public class PersonRepository {
    public Mono<PersonBo> getById(String id) {
        return Mono.just(
                createPerson());
    }

    public Flux<PersonBo> findAll() {
        return Flux.fromIterable(
                Arrays.asList(
                        createPerson(), createPerson(), createPerson()));
    }

    public Mono<PersonBo> findByIsoCode(String firstName) {
        return Mono.just(
                createPerson());
    }


    public Mono<PersonBo> save(Mono<PersonBo> person) {
        return Mono.just(
                createPerson());
    }

    private PersonBo createPerson() {
        return PersonBo.builder()
                .firstName("john")
                .familyName("doe")
                .build();
    }

}
