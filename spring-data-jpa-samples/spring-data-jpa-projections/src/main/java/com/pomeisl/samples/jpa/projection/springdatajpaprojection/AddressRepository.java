package com.pomeisl.samples.jpa.projection.springdatajpaprojection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Collection<AddressView> findAllByState(@Param("state") String state);
}
