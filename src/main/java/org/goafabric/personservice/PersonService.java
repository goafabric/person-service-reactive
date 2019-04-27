package org.goafabric.personservice;

import org.goafabric.personservice.dto.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/persons",
        produces = "application/json")

@RestController
public class PersonService {

    @GetMapping("")
    public String welcome () {
        return "welcome";
    }

    @GetMapping("getById/{id}")
    public Person getById(@PathVariable("id") String id) {
        return Person.builder().build();
    }

    @GetMapping("findAll")
    public List<Person> findAll() {
        return new ArrayList<>();
    }

    @GetMapping("findByFirstName")
    public Person findByIsoCode(@RequestParam("firstName") String firstName) {
        return Person.builder().build();
    }


    @PostMapping(value = "save", consumes = "application/json")
    public Person save(@RequestBody Person person) {
        return Person.builder().build();
    }

}
