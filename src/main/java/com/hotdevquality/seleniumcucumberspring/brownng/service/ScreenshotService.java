package com.hotdevquality.seleniumcucumberspring.brownng.service;

import com.hotdevquality.seleniumcucumberspring.brownng.annotation.LazyAutowired;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Lazy
@Service
public class ScreenshotService {

    @Autowired
    private ApplicationContext ctx;


    @LazyAutowired
    private DateTimeService dateTimeService;

    @Value("${screenshot.path}")
    private Path path;

    public void takeTakesScreenshot() throws IOException {
        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve(dateTimeService.dateTimeNow() + ".png").toFile());
    }

    public byte[] getScreenshot(){
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }

//    public void takeTakesScreenshot(final String imgName) throws IOException {
//        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
//        FileCopyUtils.copy(sourceFile, this.path.resolve(dateTimeService.dateTimeNow() + ".png").toFile());
//    }
}
