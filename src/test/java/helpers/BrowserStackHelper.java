package helpers;
import org.aeonbits.owner.ConfigFactory;
import config.MobileConfig;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static helpers.CustomAllureListener.withCustomTemplates;
public class BrowserStackHelper {

  public static String getVideoUrl (String sessionId) {

    MobileConfig config = ConfigFactory.create(MobileConfig.class);

    String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

    return given()
            .log().all()
            .filter(withCustomTemplates())
            .auth().basic(config.getUser(), config.getKey())
            .when()
            .get(url)
            .then()
            .log().all()
            .statusCode(200)
            .extract().path("automation_session.video_url");
  }
}
