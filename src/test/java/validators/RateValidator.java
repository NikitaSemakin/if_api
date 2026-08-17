package validators;

import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasKey;

public class RateValidator {

    public void validateStatusCode(Response response, int expectedStatusCode) {
        response.then()
                .statusCode(expectedStatusCode);
    }

    public void validateSchema(Response response) {
        response.then()
                .body(matchesJsonSchemaInClasspath("schemas/rate_schema.json"));
    }

    public void validateHeaders(Response response) {
        response.then()
                .header("Content-Type", containsString("application/json"));
    }

    public void validateKeys(Response response) {
        response.then()
                .body("$", hasKey("amount"))
                .body("$", hasKey("grow"))
                .body("$", hasKey("scale"));
    }
}
