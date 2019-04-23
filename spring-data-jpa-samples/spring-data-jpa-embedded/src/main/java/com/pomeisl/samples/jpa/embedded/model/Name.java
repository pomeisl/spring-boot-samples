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
public class Name {

    @NotNull
    String firstName;

    String middleName;

    String lastName;

}
