package calculator;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class MyStepDefs {
    private Calculator calculator;
    private int value1;
    private int value2;
    private int result;
    private boolean error = false;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Given("^Two input values, (-?\\d+) and (-?\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
        value1 = arg0;
        value2 = arg1;
    }

    @When("^I add the two values$")
    public void iAddTheTwoValues() {
        result = calculator.add(value1, value2);
        System.out.println(result);
    }

    @Then("^I expect the result (-?\\d+|\\w+)$")
    public void iExpectTheResult(String arg0) {
        if (error || arg0.equals("error")) {
            error = false;
            Assert.assertEquals(arg0, "error");
        } else {
            int expectedResult = Integer.parseInt(arg0);
            Assert.assertEquals(expectedResult, result);
        }
    }

    @Given("^Input values, (-?\\d+) and (-?\\d+) and (.)$")
    public void calculatorWithThreeInputs(int first, int second, String operator) {
        value1 = first;
        value2 = second;
        switch (operator) {
            case "*" -> {
                result = calculator.multiple(first, second);
            }
            case "/" -> {
                try {
                    result = calculator.divide(value1, value2);
                } catch (Exception e) {
                    error = true;
                }
            }
            case "^" -> {
                result = calculator.power(first, second);
            }
            default -> {
                error = true;
            }
        }
        System.out.println(result);
    }

    @When("I multiple the values")
    public void iMultipleTheResult() {
        result = calculator.multiple(value1, value2);
        System.out.println(result);
    }

    @When("I divide the values")
    public void iDivideTheResult() {
        try {
            result = calculator.divide(value1, value2);
        } catch (Exception e) {
            error = true;
        }
        System.out.println(result);
    }

    @When("I power the values")
    public void iPowerTheResult() {
        result = calculator.power(value1, value2);
        System.out.println(result);
    }

}
