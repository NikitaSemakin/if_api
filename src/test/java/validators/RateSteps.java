package validators;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;

public class RateSteps {
    public String getResponse() {
       return given()
                .log().all()
                .when()
                .get("https://kurs.onliner.by/sdapi/kurs/api/bestrate?currency=USD&type=nbrb")
                .then().log().all()
                .statusCode(200)
                .header("Content-Type", containsString("application/json"))
                //        .body("amount", equalTo("2,9480"))
                .body("$", hasKey("amount"))
                .body("$", hasKey("grow"))
                .body("$", hasKey("scale"))
                .extract().asString();
    }
}
