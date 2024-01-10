package org.example.config;

import org.example.Contact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

@Configuration
@PropertySource("classpath:application-init.properties")
@Profile("init")
public class InitProfileConfig {

    @Value("${app.path}")
    private String path;

    @Bean
    public Set<Contact> contactList() {
        Set<Contact> contactList = new LinkedHashSet<>();
        try(BufferedReader br = new BufferedReader (new FileReader(path))) {
            String s;
            while((s=br.readLine()) != null) {
                Contact contact = new Contact();
                String[] contactDetails = s.split(";");
                contact.setFullName(contactDetails[0]);
                contact.setPhoneNumber(contactDetails[1]);
                contact.setEmail(contactDetails[2]);
                contactList.add(contact);
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return contactList;
    }
}