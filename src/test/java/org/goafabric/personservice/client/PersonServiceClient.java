package org.goafabric.personservice.client;

import org.goafabric.personservice.service.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PersonServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String serviceUri;

    public PersonServiceClient(String baseUri) {
        this.serviceUri = baseUri + "/personsreactive";
    }

    public Person getById(String id) {
        return restTemplate.getForObject(serviceUri + "/getById/{id}",
                Person.class, id);
    }

    public List<Person> findAll() {
        return restTemplate.getForObject(serviceUri + "/findAll",
                List.class);
    }


    public Person findByFirstName(String name) {
        return restTemplate.getForObject(serviceUri + "/findByFirstName?firstName={firstName}",
                Person.class, name);
    }

    public Person findByLastName(String name) {
        return restTemplate.getForObject(serviceUri + "/findByLastName?lastName={lastName}",
                Person.class, name);
    }

    public Person save(Person Person) {
        return restTemplate.postForObject(serviceUri + "/save",
                Person, Person.class);
    }

    public void delete(String id) {
        restTemplate.delete(serviceUri + "/delete?id={id}",
                id);
    }
}
