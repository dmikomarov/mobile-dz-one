package tests.browserstack;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class IosTest extends TestBase{

  @Test
  @Tag("ios")
  public void searchIosTest() {
    step("iOS type search", () -> {
      $(id("Text Button")).click();
      $(id("Text Input")).sendKeys("qa.guru homework");
      $(id("Text Input")).pressEnter();
    });
    step("Verify content found", () -> {
      $(id("Text Output")).shouldHave((text("qa.guru homework")));
    });
  }
}
