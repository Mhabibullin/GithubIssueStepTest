package guru.qa;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private static final String REPOSITORY = "junit-team/junit5-samples";
    private static final String ISSUE_NAME = "Upgradle to 6.0.1";

    private WebSteps steps = new WebSteps();

    @Test
    public void shouldSeeIssueInRepository() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName(ISSUE_NAME);
    }
}
