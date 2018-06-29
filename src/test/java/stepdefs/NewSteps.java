package stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewSteps {
    private ChromeDriver driver;
    private WebElement searchField;
    private WebElement searchForm;
    private String resultPageTitle;
    private String searchQuery;

    @Before
    public void initialisation() {
        driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println("Initialisation");
    }

    @Given("^chromedriver from \"([^\"]*)\" in system folder \"([^\"]*)\"$")
    public void chromedriverFromInSystemFolder(String url, String path) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Preconditions: chromedriver from " + url + " is in " + path + " folder");
    }

    @And("^artifacts \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" dependencies in \"([^\"]*)\"$")
    public void artifactsDependenciesIn(String dep0, String dep1, String dep2, String dep3, String dir)
            throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Dependencies: " + dep0 + ", " + dep1 + ", "
                + dep2 + ", " + dep3 + " are in " + dir + " folder");
    }

    @And("^runner class \"([^\"]*)\" in \"([^\"]*)\" folder$")
    public void runnerClassInFolder(String className, String dir) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("runner class " + className + " is in " + dir + " folder");
        System.out.println("and it contains @RunWith(Cucumber.class) annotation");
    }

    @And("^feature file in \"([^\"]*)\" folder$")
    public void featureFileInFolder(String dir) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("feature file is in the " + dir + " folder");
    }

    @And("^step definition class in \"([^\"]*)\" folder$")
    public void stepDefinitionClassInFolder(String dir) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("step definition class in the " + dir + " folder");
    }

    @And("^terminal is opened and the current directory is my project's directory\"$")
    public void terminalIsOpenedAndTheCurrentDirectoryIsMyProjectDirectory() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("terminal is opened and the current directory is my project's directory");
    }

    @And("^I ran \"([^\"]*)\"$")
    public void iRan(String command) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I ran " + command);
    }

    @When("^All preconditions is done$")
    public void allPreconditionsIsDone() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When all preconditions is done, test should be ran");
    }

    @Then("^Chrome browser should be opened$")
    public void chromeBrowserShouldBeOpened() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        searchField = driver.findElement(By.name("q"));
        searchForm = driver.findElement(By.name("f"));
        System.out.println("And Chrome browser should be opened");
        System.out.println("And all necessary elements should be found on the page");
    }

    @And("^word \"([^\"]*)\" should be typed in the search field$")
    public void wordShouldBeTypedInTheSearchField(String queryString) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.searchQuery = queryString;
        searchField.sendKeys(queryString);
        System.out.println("And word " + queryString + " should be typed in the search field");
    }

    @And("^form should be submitted$")
    public void buttonShouldBePressed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        searchForm.submit();
        System.out.println("And form should be submitted");
   }

    @And("^search result should be shown$")
    public void searchResultShouldBeShown() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("And search result should be shown");
        resultPageTitle = driver.getTitle();
        Assert.assertTrue(resultPageTitle.contains(searchQuery));
    }

    @And("^Chrome browser should be closed$")
    public void chromeBrowserShouldBeClosed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("And Chrome browser should be closed");
        System.out.println("* actually, this step is realized in @After attrubute");
    }

    @And("^in terminal 1 Scenario and 14 steps should be passed$")
    public void inTerminalScenarioAndStepsShouldBePassed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("And in terminal 1 Scenario and 14 steps should be passed");
    }

    @After
    public void teardown() {
        System.out.println("Teardown");
        driver.quit();
    }

}
