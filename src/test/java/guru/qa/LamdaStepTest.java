package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LamdaStepTest {

    private static final String REPOSITORY = "junit-team/junit5-samples";
    private static final String ISSUE_NAME = "Upgradle to 6.0.1";

    @Test
    public void testRepositoryIssue() {

        step("Открываем главную страницу", ()-> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, ()-> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").pressEnter();
        });

        step("переходим в репозиторий", ()-> {
            $(linkText("junit-team/junit5-samples")).click();
        });

        step("переходим в issues", ()-> {
            $(partialLinkText("Issues")).click();
        });

        step("проверяем что существует issue с названием " + ISSUE_NAME, ()-> {
            $(withText( ISSUE_NAME)).should(Condition.exist);
        });



    }

}
