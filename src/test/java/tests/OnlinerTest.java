package tests;

import enums.Currency;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import validators.RateSteps;
import validators.RateValidator;

public class OnlinerTest {

    private final RateSteps steps = new RateSteps();
    private final RateValidator validator = new RateValidator();

    @DataProvider(name = "currencies")
    public Object[][] currencies() {
        return new Object[][]{
                {Currency.USD},
                {Currency.EUR},
                {Currency.RUB}
        };
    }

    @Test(dataProvider = "currencies")
    public void checkRates(Currency currency) {

        Response response = steps.getResponse(currency);

        validator.validateStatusCode(response, 200);
        validator.validateSchema(response);
        validator.validateHeaders(response);
        validator.validateKeys(response);
    }
}
