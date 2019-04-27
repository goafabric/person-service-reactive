package org.goafabric.personservice.service;

import org.goafabric.personservice.client.PersonServiceClient;
import org.goafabric.personservice.service.dto.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class PersonServiceIT {
    @Autowired
    private PersonServiceClient personServiceClient;

    @Test
    public void findAll() {
        List<Person> persons = personServiceClient.findAll();
        assertThat(persons).isNotNull().isNotEmpty();
    }
}