package com.hotdevquality.seleniumcucumberspring.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
public class Customer {

    @Id
    private Integer id;
    private String fromCountry;
    private String toCountry;
    private Date dob;
    private String firstName;
    private String lastName;
    @Column(name = "customer_email")
    private String email;
    private String phone;
    private String comments;

}
