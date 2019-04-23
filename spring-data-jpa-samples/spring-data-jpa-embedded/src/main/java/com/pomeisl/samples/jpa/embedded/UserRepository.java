package com.pomeisl.samples.jpa.embedded;

import com.pomeisl.samples.jpa.embedded.model.Name;
import com.pomeisl.samples.jpa.embedded.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByNameFirstName(String firstName);

    User findByEmail(String email);

    boolean existsByName(Name build);
}
