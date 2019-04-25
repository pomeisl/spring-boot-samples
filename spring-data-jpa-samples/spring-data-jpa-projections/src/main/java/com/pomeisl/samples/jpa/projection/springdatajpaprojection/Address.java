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
public class Address {

    @Id
    Long id;

    @OneToOne
    Person person;

    String state;

    String city;

    String street;

    String zipCode;

}
