package SEG3102.HMSPMS.contracts

import io.cucumber.junit.platform.engine.Constants
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite

@Suite
@SelectClasspathResource("SEG3102/HMSPMS/contracts")
@ConfigurationParameter(
    key = Constants.GLUE_PROPERTY_NAME,
    value = "SEG3102.HMSPMS.contracts"
)
class CucumberContracts {
}