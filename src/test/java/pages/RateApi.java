package pages;

import enums.Currency;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RateApi {

    private static final String BASE_URL =
            "https://kurs.onliner.by";

    private static final String RATE_ENDPOINT =
            "/sdapi/kurs/api/bestrate";

    public Response getRate(Currency currency) {
        return given()
                .log().all()
                .queryParam("currency", currency.getCode())
                .queryParam("type", "nbrb")
                .when()
                .get(BASE_URL + RATE_ENDPOINT)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
