package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import drivers.BrowserstackMobileDriver;
import helpers.Attach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
  @BeforeAll
  static void beforeAll() {
    Configuration.browser = BrowserstackMobileDriver.class.getName();
    Configuration.browserSize = null;
    // костыль для конфигурации селенида для мобильной автоматизации
//        Configuration.timeout = 15000;
//        Configuration.pageLoadTimeout = 15000;
  }

  @BeforeEach
  void addListener() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    open(); // костыль для инициализации селенида для мобильной автоматизации
  }

  @AfterEach
  void afterEach() {

    String sessionId = Selenide.sessionId().toString();

    Attach.pageSource();

    closeWebDriver();

    Attach.addVideo(sessionId);
  }
}
