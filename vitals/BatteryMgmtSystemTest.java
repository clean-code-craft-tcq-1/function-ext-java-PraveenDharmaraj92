package vitals;

import java.util.function.Function;

/**
 * Test class for Battery management system
 */
public class BatteryMgmtSystemTest {

	private void testTemperatureNegative(Function<Battery, BatteryHealthResult> healthCheckFunction) {
		Battery battery = new Battery(-12, 0.9f, 70);
		assert(!healthCheckFunction.apply(battery).isTemperatureOK());
	}

	private void testSocNegative(Function<Battery, BatteryHealthResult> healthCheckFunction) {
		Battery battery = new Battery(12, 0.9f, 102);
		assert(!healthCheckFunction.apply(battery).isSocOK());
	}

	private void testChargeRateNegative(Function<Battery, BatteryHealthResult> healthCheckFunction) {
		Battery battery = new Battery(12, -0.3f, 56);
		assert(!healthCheckFunction.apply(battery).isChargeRateOK());
	}
	
	private void testBatteryHealthPositive(Function<Battery, BatteryHealthResult> healthCheckFunction){
		Battery battery = new Battery(12, 0.9f, 56);
		BatteryHealthResult result = healthCheckFunction.apply(battery);
		assert(result.isChargeRateOK()&&result.isSocOK()&&result.isTemperatureOK());
	}
	
	
	/**
	 * Test logger functionality
	 */
	private void testLogger(IBatteryHealthChecker healthChecker){
		healthChecker.checkHealth();
	}
	
	/**
	 * Test accumulator functionality
	 */
	private void testAccumulator(IBatteryHealthChecker healthChecker){
		BatteryHealthAccumulator accumulator  = ((BatteryHealthAccumulator)healthChecker);
		accumulator.checkHealth();
		assert(accumulator.getResult()!=null);
	}
	

	/**
	 * test method for testing battery management system
	 */
	public void test() {
		//test battery health check function
		testBatteryHealthPositive(new BatteryHealthChecker());
		testTemperatureNegative(new BatteryHealthChecker());
		testSocNegative(new BatteryHealthChecker());
		testChargeRateNegative(new BatteryHealthChecker());

		//test reporters
		testLogger(new BatteryHealthReporter(new Battery(-12, -0.3f, 102)));
		testAccumulator(new BatteryHealthAccumulator(new Battery(-12, -0.3f, 102)));
	}
	
}
