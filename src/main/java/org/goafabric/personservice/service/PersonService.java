package org.goafabric.personservice.service;

import lombok.extern.slf4j.Slf4j;
import org.goafabric.personservice.logic.PersonLogic;
import org.goafabric.personservice.service.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping(value = "/persons",
        produces = "application/json")

@RestController
@Slf4j
public class PersonService {
    @Autowired
    private PersonLogic personLogic;

    @GetMapping("")
    public String welcome () {
        return "welcome";
    }

    @GetMapping("getById/{id}")
    public Mono<Person> getById(@PathVariable("id") String id) {
        return personLogic.getById(id);
    }

    @GetMapping("findAll")
    public Flux<Person> findAll() {
        Flux<Person> persons = personLogic.findAll();
        persons.subscribe(p -> log.info(p.toString()));
        return persons;
    }

    @GetMapping("findByFirstName")
    public Mono<Person> findByIsoCode(@RequestParam("firstName") String firstName) {
        return personLogic.findByIsoCode(firstName);
    }


    @PostMapping(value = "save", consumes = "application/json")
    public Mono<Person> save(@RequestBody Mono<Person> person) {
        return personLogic.save(person);
    }

}
