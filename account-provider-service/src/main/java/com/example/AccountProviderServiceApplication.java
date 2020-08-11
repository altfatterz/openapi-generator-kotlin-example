package com.example;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class AccountProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountProviderServiceApplication.class, args);
    }

}

@RestController
class AccountRestController {

    @GetMapping("/accounts")
    public List<Account> getAccounts(@RequestHeader("Cookie") String cookie) {
        System.out.println("Received cookie: " + cookie);
        return List.of(new Account("123.456.789", "Checking Account", "CH93 0076 2011 6238 5295 7"));
    }

}

class Account {

    String id;
    String name;
    String iban;

    public Account(String id, String name, String iban) {
        this.id = id;
        this.name = name;
        this.iban = iban;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIban() {
        return iban;
    }
}