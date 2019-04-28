package org.goafabric.personservice.service;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.goafabric.personservice.client.PersonServiceReactiveClient;
import org.goafabric.personservice.service.dto.Person;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class PersonServiceLoadNRIT {
    @Autowired
    private PersonServiceReactiveClient personServiceClient;

    @Rule
    public ContiPerfRule rule = new ContiPerfRule();

    @PerfTest(invocations=500000, threads=10)
    @Test
    public void findAll() {
        List<Person> persons =
                personServiceClient.findAll().collectList().block();
        assertThat(persons).isNotNull().isNotEmpty();
    }
}