package com.pomeisl.samples.jpa.embedded.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Address {

    @NotNull
    String addressLine1;

    @NotNull
    String addressLine2;

    @NotNull
    String city;

    @NotNull
    String state;

    @NotNull
    String country;

    @NotNull
    String zipCode;
}
