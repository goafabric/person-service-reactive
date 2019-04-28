package org.goafabric.personservice.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ReactiveClientConfiguration {
    @Bean
    public WebClient webClient() {
        return WebClient.create("localhost:8080");
    }

    @Bean
    public PersonServiceReactiveClient personServiceReactiveClient() {
        return new PersonServiceReactiveClient();
    }

}
