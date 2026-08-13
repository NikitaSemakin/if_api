package tests;

import org.testng.annotations.Test;
import validators.RateSteps;
import validators.RateValidator;


public class OnlinerTest {
    private final RateSteps steps = new RateSteps();
    private final RateValidator validator = new RateValidator();

    @Test
    public void checkRates(String currency) {
    String response = steps.getResponse();
    validator.validateSchema(200);
    validator.validateHeaders();
    validator.validateKeys();
    }
}
