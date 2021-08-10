package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {
    @Test
    public void testRepositoryIssue() {

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("junit-team/junit5-samples");
        $(".header-search-input").submit();

        $(linkText("junit-team/junit5-samples")).click();
        $(partialLinkText("Issues")).click();
        $(byText("Upgradle to 6.0.1")).should(Condition.exist);
    }
}
