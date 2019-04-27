package org.goafabric.personservice.logic;

import org.goafabric.personservice.mapper.PersonMapper;
import org.goafabric.personservice.persistence.PersonRepository;
import org.goafabric.personservice.service.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonLogic {
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    public Mono<Person> getById(String id) {
        return personRepository.getById(id)
                .map(personMapper::toDto);
    }

    public Flux<Person> findAll() {
        return personRepository.findAll()
                .map(personMapper::toDto);
    }

    public Mono<Person> findByIsoCode(String firstName) {
        return personRepository.findByIsoCode(firstName)
                .map(personMapper::toDto);
    }


    public Mono<Person> save(Mono<Person> person) {
        return personRepository.save(
                person.map(personMapper::toBo))
                .map(personMapper::toDto);
    }


}
