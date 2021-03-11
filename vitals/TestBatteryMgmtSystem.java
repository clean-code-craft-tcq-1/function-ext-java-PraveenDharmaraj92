/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package vitals;

import java.util.function.Function;

/**
 * @author PDH2COB
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
		Battery battery = new Battery(-12, 0.9f, 56);
		BatteryManager batteryManager = new BatteryManager(battery);
		batteryManager.checkHealth().reportHealth();
	}

	/**
	 * test method for testing battery management system
	 */
	public void test() {
		testBatteryHealthPositive(new BatteryHealthCheckFunction());
		testTemperatureNegative(new BatteryHealthCheckFunction());
		testSocNegative(new BatteryHealthCheckFunction());
		testChargeRateNegative(new BatteryHealthCheckFunction());
		testBatteryHealth();
		
	}
}
