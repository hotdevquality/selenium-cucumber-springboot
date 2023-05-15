package com.hotdevquality.seleniumcucumberspring.visa;

import com.hotdevquality.seleniumcucumberspring.entity.Customer;
import com.hotdevquality.seleniumcucumberspring.page.visa.VisaRegistrationPage;
import com.hotdevquality.seleniumcucumberspring.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Query Creation Reference link
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html//#jpa.query-methods.query-creation
 *
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomerVisaTest {

    private static final Logger log = LoggerFactory.getLogger(CustomerVisaTest.class);

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private VisaRegistrationPage visaRegistrationPage;

    @Test
    void readDataTest() {
        System.out.println(
                this.repository.findAll().size()
        );

        this.repository.findById(99)
                .ifPresent(customer -> System.out.println(
                        customer.getFirstName() +" "+ customer.getLastName()
                ));
    }

    @Test
    void visaTest() {

        List<Customer> customers = this.repository.findAll()
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        for (Customer customer : customers) {
            this.visaRegistrationPage.goTo();
            this.visaRegistrationPage.inputNames(customer.getFirstName(), customer.getLastName());
            this.visaRegistrationPage.setCountryFromAndTo(customer.getFromCountry(), customer.getToCountry());
            this.visaRegistrationPage.setDob(customer.getDob().toLocalDate());
            this.visaRegistrationPage.setContactDetails(customer.getEmail(), customer.getPhone());
            this.visaRegistrationPage.inputComments(customer.getComments());
            this.visaRegistrationPage.submit();

            System.out.println(
                    this.visaRegistrationPage.getConfirmationNumber()
            );
        }
    }

    @Test
    void visaCustomMethodTest() {

//        List<Customer> customers = this.repository.findByFirstNameStartingWith("Mil")
        List<Customer> customers = this.repository.findByDobBetween(Date.valueOf("1995-01-01"), Date.valueOf("1999-01-01"))
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        for (Customer customer : customers) {
            this.visaRegistrationPage.goTo();
            this.visaRegistrationPage.inputNames(customer.getFirstName(), customer.getLastName());
            this.visaRegistrationPage.setCountryFromAndTo(customer.getFromCountry(), customer.getToCountry());
            this.visaRegistrationPage.setDob(customer.getDob().toLocalDate());
            this.visaRegistrationPage.setContactDetails(customer.getEmail(), customer.getPhone());
            this.visaRegistrationPage.inputComments(customer.getComments());
            this.visaRegistrationPage.submit();

            log.info("Visa Request Number INFO : " + this.visaRegistrationPage.getConfirmationNumber());
            log.warn("Visa Request Number WARN : " + this.visaRegistrationPage.getConfirmationNumber());
        }
    }
}
