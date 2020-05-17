package step;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class LearnHooks {
	
	@Before
	public void beforeScenario(Scenario sc) {
		System.out.println("Scenario Name:" + sc.getName());
		System.out.println("Scenario Id:" + sc.getId());
		System.out.println("Scenario Status before:" + sc.getStatus());

	}
	@After
	public void afterScenario(Scenario sc) {
		System.out.println("Scenario Status after:" + sc.getStatus());


	}

}
