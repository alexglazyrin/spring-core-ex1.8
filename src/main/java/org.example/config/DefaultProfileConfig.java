package org.example.config;

import org.example.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.LinkedHashSet;
import java.util.Set;

@Configuration
@Profile("default")
public class DefaultProfileConfig {

    @Bean
    public Set<Contact> contactList() {
        return new LinkedHashSet<>();
    }
}