package com.pomeisl.samples.jpa.projection.springdatajpaprojection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@DataJpaTest
@RunWith(SpringRunner.class)
@Sql(scripts = "/beforeTestRun.sql")
@Sql(scripts = "/afterTestRun.sql", executionPhase = AFTER_TEST_METHOD)
public class JpaProjectionIntegrationTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void whenUsingClosedProjections_thenViewWithRequiredPropertiesIsReturned() {
        Collection<AddressView> result = addressRepository.findAllByState("Budapest");

        assertThat(result.stream().map(a -> a.getZipCode())).contains("1061");
    }

    @Test
    public void whenUsingClosedProjection_thenAllViewWithNestedProjectionAreNotNull() {
        Collection<PersonView> result = addressRepository.findAllByState("Budapest").stream().map(AddressView::getPerson).collect(Collectors.toList());

        result.forEach(Assert::assertNotNull);
    }

    @Test
    public void whenUsingOpenProjections_thenViewWithRequiredPropertiesIsReturned() {
        PersonView personView = personRepository.findByLastName("Pomeisl");

        assertThat(personView.getFullName()).isEqualTo("Ferenc Pomeisl");
    }

    @Test
    public void whenUsingDynamicProjections_thenObjectWithRequiredPropertiesIsReturned() {
        Person person = personRepository.findByLastName("Pomeisl", Person.class);
        PersonView personView = personRepository.findByLastName("Pomeisl", PersonView.class);
        PersonDto personDto = personRepository.findByLastName("Pomeisl", PersonDto.class);

        assertThat(person.getFirstName()).isEqualTo("Ferenc");
        assertThat(personView.getFirstName()).isEqualTo("Ferenc");
        assertThat(personDto.getFirstName()).isEqualTo("Ferenc");
    }
}
