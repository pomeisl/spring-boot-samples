package com.pomeisl.samples.jpa.embedded;

import com.pomeisl.samples.jpa.embedded.model.Address;
import com.pomeisl.samples.jpa.embedded.model.Name;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({
        @Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
        @Sql(executionPhase = AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql")
})
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private com.pomeisl.samples.jpa.embedded.UserRepository userRepository;

    @Test
    public void existsByEmbeddedName_Exists() {
        assertThat(userRepository
                .existsByName(Name.builder()
                        .firstName("firstName")
                        .middleName("middleName")
                        .lastName("lastName")
                        .build()))
                .isTrue();
    }

    @Test
    public void findByEmail_HasExpectedAddress() {
        val result = userRepository.findByEmail("test@test.com");

        assertThat(result.getAddress())
                .isEqualTo(Address.builder()
                        .addressLine1("addressLine1")
                        .addressLine2("addressLine2")
                        .city("city")
                        .country("country")
                        .state("state")
                        .zipCode("zipCode")
                        .build());
    }

}
