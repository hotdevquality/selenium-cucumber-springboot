package com.hotdevquality.seleniumcucumberspring.windowbrowser;

import com.hotdevquality.seleniumcucumberspring.brownng.service.WindowSwitchService;
import com.hotdevquality.seleniumcucumberspring.page.windowbrowser.MainPage;
import com.hotdevquality.seleniumcucumberspring.page.windowbrowser.PageA;
import com.hotdevquality.seleniumcucumberspring.page.windowbrowser.PageB;
import com.hotdevquality.seleniumcucumberspring.page.windowbrowser.PageC;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@TestPropertySource(properties = "browser=firefox")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class WindowSwitchingTest {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private PageC pageC;

    @Autowired
    private WindowSwitchService switchService;

    @BeforeEach
    void setup() {
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test
    void windowSwitchTest() throws InterruptedException {

//        this.switchService.switchByTitle("Page A");
//        this.pageA.addToArea("Hi page A");
//        this.switchService.switchByIndex(2);
//        this.pageB.addToArea("Hello page B");
//        Thread.sleep(10000);
        this.pageA.addToArea("1\n");
        this.pageA.addToArea((2*2) + "\n");
        this.pageA.addToArea((2*3) + "\n");

    }

    @AfterEach
    void cleanup() {
        mainPage.teardown();
    }
}
