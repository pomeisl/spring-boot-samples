package com.pomeisl.samples.jpa.projection.springdatajpaprojection;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class PersonDto {
    String firstName;
    String lastName;
}
