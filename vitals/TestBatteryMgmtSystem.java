package vitals;

import java.util.function.Function;

/**
 * Test class for Battery management system
 */
public class TestBatteryMgmtSystem {

	private void testTemperatureNegative(Function<Battery, BatteryHealthResult> healthCheckFunction) {
		Battery battery = new Battery(-12, 0.9f, 70);
		assert(healthCheckFunction.apply(battery).isTemperatureBreach());
	}

	private void testSocNegative(Function<Battery, BatteryHealthResult> healthCheckFunction) {
		Battery battery = new Battery(12, 0.9f, 102);
		assert(healthCheckFunction.apply(battery).isSocBreach());
	}

	private void testChargeRateNegative(Function<Battery, BatteryHealthResult> healthCheckFunction) {
		Battery battery = new Battery(12, -0.3f, 56);
		assert(healthCheckFunction.apply(battery).isChargeRateBreach());
	}
	
	private void testBatteryHealthPositive(Function<Battery, BatteryHealthResult> healthCheckFunction){
		Battery battery = new Battery(12, 0.9f, 56);
		BatteryHealthResult result = healthCheckFunction.apply(battery);
		assert(!result.isChargeRateBreach()&&!result.isSocBreach()&&!result.isTemperatureBreach());
	}
	
	private void testBatteryHealth(){
		Battery battery = new Battery(-12, -0.3f, 102);
		BatteryManager batteryManager = new BatteryManager(battery);
		batteryManager.checkHealth().reportHealth();
	}
	
	/**
	 * Test logger functionality
	 */
	private void testLogger(){
		Battery battery = new Battery(-12, -0.3f, 102);
		BatteryManager batteryManager = new BatteryManager(battery);
		report(new LogReporter(batteryManager));
	}
	
	/**
	 * Test accumulator functionality
	 */
	private void testAccumulator(){
		Battery battery = new Battery(-12, -0.3f, 102);
		BatteryManager batteryManager = new BatteryManager(battery);
		BatteryHealthAccumulator batteryHealthAccumulator = new BatteryHealthAccumulator(new BatteryHealthController(batteryManager));
		report(batteryHealthAccumulator);
		assert(batteryHealthAccumulator.getResult()!=null);
	}
	

	/**
	 * test method for testing battery management system
	 */
	public void test() {
		//test battery health check function
		testBatteryHealthPositive(new BatteryHealthCheckFunction());
		testTemperatureNegative(new BatteryHealthCheckFunction());
		testSocNegative(new BatteryHealthCheckFunction());
		testChargeRateNegative(new BatteryHealthCheckFunction());
		
		//test overall battery health
		testBatteryHealth();
		
		//test reporters
		testLogger();
		testAccumulator();
	}
	
	private void report(IReporter batteryHealthReporter){
		batteryHealthReporter.report();
	}
}
