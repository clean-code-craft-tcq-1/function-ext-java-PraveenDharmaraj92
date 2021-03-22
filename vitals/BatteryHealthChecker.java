package vitals;

import java.util.function.Function;

/**
 *
 * Battery Health function to check health levels based on parameters
 */
public class BatteryHealthChecker implements Function<Battery, BatteryHealthResult> {

	@Override
	public BatteryHealthResult apply(Battery battery) {
		BatteryHealthResult healthResult = new BatteryHealthResult();
		healthResult.setSocOK(checkSoc(battery));
		healthResult.setChargeRateOK(checkChargeRate(battery));
		healthResult.setTemperatureOK(checkTemperature(battery));
		return healthResult;
	}

	private boolean isWithinRange(float minRange, float maxRange, float batteryParameter) {
		return batteryParameter > minRange && batteryParameter < maxRange;
	}

	private boolean checkChargeRate(Battery battery) {
		return isWithinRange(BatteryParameterRange.CHARGE_RATE.getMin(), BatteryParameterRange.CHARGE_RATE.getMax(),
				battery.getChargeRate());
	}

	private boolean checkSoc(Battery battery) {
		return isWithinRange(BatteryParameterRange.SOC.getMin(), BatteryParameterRange.SOC.getMax(), battery.getSoc());
	}

	private boolean checkTemperature(Battery battery) {
		return isWithinRange(BatteryParameterRange.TEMPERATURE.getMin(), BatteryParameterRange.TEMPERATURE.getMax(),
				battery.getTemperature());
	}

}
