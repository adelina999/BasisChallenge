# ****TestNG UI Automation Challenge - Basis Technologies****

This repository contains UI automation tests for the Basis Technologies website using TestNG framework. The tests are written in Java 11 and utilize Maven for dependency management. The logging is handled using Log4j, and the test reports are generated using Allure.

## **Prerequisites**

Make sure you have the following tools and dependencies installed on your machine:

Java Development Kit (JDK) 11
Apache Maven
Chrome Web Browser (latest version)
Allure Command Line Tool
DriverManager dependency

## **How to Run the Tests**

Clone the repository to your local machine:
git clone https://github.com/adelina999/BasisChallenge.git

Run the tests using Maven:
mvn clean test
Alternatively, you can also run the tests directly from your IDE by executing the test files individually.

## **Test Files**

## **Make sure to update the path to the files you want to attach based on the location on your local machine in Application page- attachResume method**

**JobApplicationTests**
This test file covers end-to-end scenarios for the job application process on the Basis Technologies website. It includes steps from opening the browser to attaching a successful PDF resume format.

**AttachingResumeTests**
The AttachingResumeTests file contains various scenarios and validations for attaching a resume during the job application process.

**PronounsTests**
The PronounsTests file includes scenarios to cover different pronoun options during the job application process.

**BaseTest**
The BaseTest class contains shared code that can be used across multiple test files.

# **Generating Test Reports**

After executing the tests, you can generate the Allure report by running the following command:
allure serve

This will open the test report in your default web browser, allowing you to view the test results.

### **Logging with Log4j**

The tests in this project use Log4j for logging, which allows us to capture and record important events during test execution. The log messages provide useful information for debugging, analysis, and monitoring the test execution process.

The Log4j configuration is set up in the log4j2.xml file. You can customize the log levels, output format, and log file location in this configuration file according to your requirements.