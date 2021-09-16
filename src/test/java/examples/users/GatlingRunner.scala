package examples

import com.intuit.karate.Runner
import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class GatlingRunner extends Simulation {
    val protocol = karateProtocol(
        "users" -> Nil
    )

    val runTestFeeder = csv("data/gatlingusers.csv").eager.circular
    val runtest = scenario("Testing callonce").feed(runTestFeeder).exec(karateFeature("classpath:examples/users/users.feature@runme"))

    setUp(
        //runtest.inject(rampUsers(10) during (10 seconds)).protocols(protocol)
        runtest.inject(
            rampConcurrentUsers(1).to(5).during(20.seconds)
        ).protocols(protocol)
    )
}