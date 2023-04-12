package tests.browserstack;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class AndroidTest extends TestBase {
  @Test
  @Tag("android")
  void searchInputTest() {

    step("Ввод строки поиска в поле поиска", () -> {
      $(accessibilityId("Search Wikipedia")).click();
      $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenide");
    });
    step("Проверка, что есть результаты поиска", () ->
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0)));
  }

  @Test
  @Tag("android")
  void openFoundContentTest() {

    step("Ввод строки поиска в поле поиска", () -> {
      $(accessibilityId("Search Wikipedia")).click();
      $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenide");
    });
    step("Проверка, что есть результаты поиска", () ->
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0)));
    step("Нажать на первый результат поиска", () ->
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click());
    step("Нажать на кнопку GO BACK", () ->
            $(id("org.wikipedia.alpha:id/view_wiki_error_button")).click());
  }
}
