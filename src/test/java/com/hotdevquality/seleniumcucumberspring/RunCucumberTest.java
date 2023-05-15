package com.hotdevquality.seleniumcucumberspring;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

/**
 * This class is for running the Cucumber tests.
 * I used Cucumber JVM 7.x version and Junit Jupiter’s @Suite annotations.
 * @SelectDirectories annotation is for the feature files,
 * and @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = “com.hotquality.seleniumspringboot”)
 * is for gluing the steps files.
 */

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/test/resources/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.hotdevquality.seleniumcucumberspring")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "@googleSearch")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@negative")
public class RunCucumberTest {
}
