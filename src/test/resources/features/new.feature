Feature: Running Selenium automated test with cucumber through maven
  As a Tester, I want to be able to run my tests through maven,
  So that I can integrate it with Jenkins.

  Scenario: Run Selenium test through maven
    Given chromedriver from "http://chromedriver.chromium.org/" in system folder "/usr/bin/" - for Linux
    #OR Cromedriver should be in your PATH - for Windows, JDK also should be in your PATH
    And artifacts "junit", "cucumber-java", "cucumber-junit", "selenium-java" dependencies in "pom.xml"
    And runner class "TestRunner" in "src/test/java" folder
    And feature file in "src/test/resources/feature" folder
    And step definition class in "src/test/java/stepdefs" folder
    And terminal is opened and the current directory is my project's directory"
    And I ran "mvn test"
    When All preconditions is done
    Then Chrome browser should be opened
    And word "success" should be typed in the search field
    And form should be submitted
    And search result should be shown
    And Chrome browser should be closed
    And in terminal 1 Scenario and 14 steps should be passed
