package OpcionesCucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources/caracteristicas",
		glue = "definicionDePasos",
		tags = "@Regresión",
		plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json" }
)

public class Ejecutor {
	
}