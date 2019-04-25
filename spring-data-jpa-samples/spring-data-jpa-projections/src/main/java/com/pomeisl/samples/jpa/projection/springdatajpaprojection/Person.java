package com.pomeisl.samples.jpa.projection.springdatajpaprojection;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Person {

    @Id
    Long id;

    String firstName;

    String lastName;

    @OneToOne(mappedBy = "person")
    Address address;

}
