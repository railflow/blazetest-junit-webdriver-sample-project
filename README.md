# BlazeTest JUnit WebDriver Sample Project #

This project contains a sample set of tests written using JUnit 5, Selenium and WebDriver that tests the web application at https://www.saucedemo.com/.

## Build ##

You can build this project and run tests using the following command line.

    mvn clean package

## Setting up WebDriver ##

Since this is a set of tests for a web application using Selenium and WebDriver, you must have a browser and a compatible version of WebDriver for that browser installed.

By default the tests uses Chrome. This means you must have a compatible version of `chromedriver` installed on your system. You can find the latest available versions at https://googlechromelabs.github.io/chrome-for-testing/.

## Extracting Tests ##

You can use the TestExtractor utility to extract tests from this project as follows.

    java -jar <test-extractor-jar-path>/TestExtractor-jar-with-dependencies.jar -input <sample-project-path> -output <output-path> -framework junit5

For example;

    java -jar ./blazetest_java_utility/target/TestExtractor-jar-with-dependencies.jar -input ./blazetest-junit-webdriver-sample-project/ -output ./output -framework junit5
