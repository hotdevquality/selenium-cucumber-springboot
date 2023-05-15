package com.hotdevquality.seleniumcucumberspring.brownng.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Lazy
@Service
public class DateTimeService {

    public String dateTimeNow() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
