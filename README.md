
---

# Repo Finder

Repo Finder is a project to demonstrate end-to-end testing using Selenium, Java and Cucumber.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- You must have installed [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17).
- Make sure you have [Maven](https://maven.apache.org/download.cgi) installed and added to your environment variables
- The web application against which the end-to-end tests will be run is up. 
You can find and install the Get GitHub Repo application [here](https://github.com/ejhernandezcruz/qa-automation-coding-challenge)



## Installing the Automation Framework

To install the project, follow these steps:

```
mvn clean install
```

## Running Tests

To run tests, follow these steps:

```
mvn test -Dtest=MainRunner

```


## Results Report

Find a cucumber report in html format in the following path:

`
/target/cucumber.html
`

After very execution a report that includes the details of the test execution
and passed tests will be available in the following path:

`
/ExtentReport/SparkReport_d_MMM_YY HH_mm_ss
`

## Config File

In the `src/test/resources` directory, there is a properties file that allows you to modify the default timeout duration and the browser to be used (either Chrome or Firefox). Additionally, you can configure whether the framework execution will be in headless or headed mode.

````
browser=chrome
headless=false
timeout=30
baseurl=http://localhost:3000/
````

## Contributors

Thanks to the following people who have contributed to this project:

- [@Edward Hernandez](https://github.com/ejhernandezcruz) 📖

## Contact

If you want to contact me you can reach me at `<ejhernandezcruz@gmail.com>`.





