package org.goafabric.personservice.service.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Person {
    private String firstName;
    private String lastName;
}
