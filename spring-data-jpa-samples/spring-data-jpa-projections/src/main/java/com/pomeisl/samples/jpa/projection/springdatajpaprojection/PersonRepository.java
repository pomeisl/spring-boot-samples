package com.pomeisl.samples.jpa.projection.springdatajpaprojection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    PersonView findByLastName(String lastName);
    <T> T findByLastName(String lastName, Class<T> type);
}
