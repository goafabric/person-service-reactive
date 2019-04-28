package org.goafabric.personservice.client;

import org.goafabric.personservice.service.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonServiceReactiveClient {
    @Autowired
    private WebClient webClient;

    public Mono<Person> getById(String id) {
        return webClient.get()
                .uri("/persons/getById/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Person.class);
    }

    public Flux<Person> findAll() {
        return webClient.get()
                .uri("/persons/findAll")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Person.class);
    }

}
