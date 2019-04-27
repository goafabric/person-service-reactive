package org.goafabric.personservice.mapper;

import org.goafabric.personservice.persistence.PersonBo;
import org.goafabric.personservice.service.dto.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(source = "familyName", target = "lastName")
    Person toDto(PersonBo person);

    @Mapping(source = "lastName", target = "familyName")
    PersonBo toBo(Person person);
}
