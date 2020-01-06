package org.goafabric.personservice.persistence;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PersonRepository extends ReactiveMongoRepository<PersonBo, String> {
    Flux<PersonBo> findByFirstName(String firstName);

}

