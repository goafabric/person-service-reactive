package org.goafabric.personservice.service;

import org.goafabric.personservice.logic.PersonLogic;
import org.goafabric.personservice.service.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping(value = "/personsreactive",
        produces = "application/json")

@RestController
public class PersonServiceReactive {
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
        return personLogic.findAll();
    }

    @GetMapping("findByFirstName")
    public Mono<Person> findByIsoCode(@RequestParam("firstName") String firstName) {
        return personLogic.findByIsoCode(firstName);
    }


    @PostMapping(value = "save", consumes = "application/json")
    public Mono<Person> save(@RequestBody Person person) {
        return personLogic.save(person);
    }

}
