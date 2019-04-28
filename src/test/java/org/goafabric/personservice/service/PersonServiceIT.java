package org.goafabric.personservice.service;

import org.goafabric.personservice.client.PersonServiceReactiveClient;
import org.goafabric.personservice.service.dto.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class PersonServiceIT {
    @Autowired
    private PersonServiceReactiveClient personServiceClient;

    @Test
    public void findAll() throws InterruptedException {
        Flux<Person> persons = personServiceClient.findAll();
        assertThat(persons).isNotNull();
        //List<Person> x = persons.collectList().block();

        persons.subscribe(p -> System.out.println(p.toString()));
        //Thread.sleep(5000);
    }
}