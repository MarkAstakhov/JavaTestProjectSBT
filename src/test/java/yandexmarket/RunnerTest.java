package yandexmarket;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/yandexmarket/features",
        glue = "yandexmarket.steps",
        tags = "@1" // @All, @1, @2

)
public class RunnerTest {

}
