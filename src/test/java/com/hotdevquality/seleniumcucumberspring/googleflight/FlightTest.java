package com.hotdevquality.seleniumcucumberspring.googleflight;

import com.hotdevquality.seleniumcucumberspring.page.googleflights.FlightPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FlightTest {

    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails flightAppDetails;

    @Test
    void flightTest() {
        this.flightPage.goTo(flightAppDetails.getUrl());
        assertTrue(this.flightPage.isAt());

        assertEquals(this.flightPage.getLabels(), this.flightAppDetails.getLabels());
    }
}
