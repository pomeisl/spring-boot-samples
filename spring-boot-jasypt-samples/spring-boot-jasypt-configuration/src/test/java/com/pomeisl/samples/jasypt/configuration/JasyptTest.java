package com.pomeisl.samples.jasypt.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"jasypt.encryptor.password = samplePassword"})
@ActiveProfiles("test")
public class JasyptTest {

    @Autowired
    Environment environment;

    @Value("${encrypted.property}")
    private String property;

    @Test
    public void whenDecryptedPasswordNeeded_GetFromService() {
        assertThat(property).isEqualTo("sampleSecretPassword");
    }

}
