### PLAYWRIGHT + CUCUMBER BDD PAGE OBJECT MODEL TEST AUTOMATION FRAMEWORK
## By Allen Almario - SDET

This is a Page Object Model Test Automation Framework using Playwright with Java and Cucumber BDD. It uses TestNG to run the tests and uses Extent Report to generate test result reports.

## Dependencies needed
- Playwright
- Cucumber Java
- Cucumber TestNG
- Extent Reports Cucumber Adapter
- Lombok

## How to run this project

### GitHub Actions
- Go to Actions
- Click on the "Playwright with Cucumber BDD Test Automation Run"
- Select Run workflow
- Ensure branch is set to "main"
- Click Run workflow

### Locally on Terminal/Command Prompt
Run the following:

```
mvn clean test
```

## Where are reports saved

### GitHub Page
https://allenalmario.github.io/PlaywrightCucumberPageObjectFramework/

### Locally
After tests are executed, an Extent Report with test results should be saved in the directory
./target/cucumber-reports/extent.html

*This project was built with the guidance of the Udemy course "Master Microsoft Playwright with Core Java". [CLICK HERE](https://www.udemy.com/course/playwright-java-tutorial/) to check out the course.*