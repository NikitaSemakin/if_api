package validators;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;

public class RateValidator {
    public void validateSchema(int statusCode) {
        given()
                .log().all()
                .when()
                .get("https://kurs.onliner.by/sdapi/kurs/api/bestrate?currency=USD&type=nbrb")
                .then().log().all()
                .body(matchesJsonSchemaInClasspath("schemas/rate_schema.json"))
                .statusCode(statusCode);
    }

    public void validateHeaders () {
        given()
                .log().all()
                .when()
                .get("https://kurs.onliner.by/sdapi/kurs/api/bestrate?currency=USD&type=nbrb")
                .then().log().all()
                .statusCode(200)
                .header("Content-Type", containsString("application/json"));

    }

    public void validateKeys() {
        given()
                .log().all()
                .when()
                .get("https://kurs.onliner.by/sdapi/kurs/api/bestrate?currency=USD&type=nbrb")
                .then().log().all()
                .statusCode(200)
                .body("$", hasKey("amount"))
                .body("$", hasKey("grow"))
                .body("$", hasKey("scale"));

    }

}
