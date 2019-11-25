package by.javatr.task1.validator.test;

import by.javatr.task1.validator.Validator;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    @Test
    public void validatePositiveDoubleTest_Positive_Double() {

        double positiveNumber= 58.9;

        boolean actual=Validator.validatePositiveDouble(positiveNumber);

        Assert.assertTrue(actual);

    }

    @Test
    public void validatePositiveDoubleTest_Negative_Double() {

        double negativeNumber = -74.9;

        boolean actual=Validator.validatePositiveDouble(negativeNumber);

        Assert.assertFalse(actual);

    }
}
