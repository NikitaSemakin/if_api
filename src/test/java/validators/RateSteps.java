package validators;

import enums.Currency;
import io.restassured.response.Response;
import pages.RateApi;

public class RateSteps {

    private final RateApi rateApi = new RateApi();

    public Response getResponse(Currency currency) {
        return rateApi.getRate(currency);
    }
}
